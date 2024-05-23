package pos.fiap.lanchonete.domain.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pos.fiap.lanchonete.adapter.in.api.enums.CategoriaEnum;
import pos.fiap.lanchonete.domain.model.DadosProduto;
import pos.fiap.lanchonete.domain.model.entity.Produto;
import pos.fiap.lanchonete.domain.model.entity.mapper.ProdutoMapper;
import pos.fiap.lanchonete.port.ProdutoMongoAdapterPort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static pos.fiap.lanchonete.adapter.in.api.enums.CategoriaEnum.ACOMPANHAMENTO;
import static pos.fiap.lanchonete.objectmother.DadosProdutoObjectMother.getDadosProdutoMock;
import static pos.fiap.lanchonete.objectmother.ProdutoObjectMother.getProdutoMock;

@ExtendWith(MockitoExtension.class)
class ProdutoUseCaseTest {

    @Mock
    private ProdutoMongoAdapterPort produtoMongoAdapterPort;
    @Spy
    private ProdutoMapper produtoMapper = Mappers.getMapper(ProdutoMapper.class);
    @InjectMocks
    private ProdutoUseCase produtoUseCase;

    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = getProdutoMock();
    }

    @Test
    void givenProduto_whenSendDadosProduto_thenSucceed() {
        when(produtoMongoAdapterPort.cadastrarProduto(any(Produto.class))).thenReturn(produto);

        var dadosProduto = produtoUseCase.cadastrar(getDadosProdutoMock());

        verify(produtoMongoAdapterPort, times(1)).cadastrarProduto(any(Produto.class));
        verify(produtoMapper, times(1)).fromDadosProduto(any(DadosProduto.class));
        verify(produtoMapper, times(1)).toDadosProduto(any(Produto.class));
        assertNotNull(dadosProduto);
        assertFalse(dadosProduto.getId().isEmpty());
    }

    @Test
    void givenProduto_whenSendDadosProdutoToChange_thenSucceed() {
        when(produtoMongoAdapterPort.alterarProduto(anyString(), any(Produto.class))).thenReturn(produto);

        var dadosProduto = produtoUseCase.alterar("1", getDadosProdutoMock());

        verify(produtoMongoAdapterPort, times(1)).alterarProduto(anyString(), any(Produto.class));
        verify(produtoMapper, times(1)).fromDadosProduto(any(DadosProduto.class));
        verify(produtoMapper, times(1)).toDadosProduto(any(Produto.class));
        assertNotNull(dadosProduto);
        assertFalse(dadosProduto.getId().isEmpty());
    }

    @Test
    void givenProduto_whenSendFindByCategoria_thenSucceed() {
        when(produtoMongoAdapterPort.buscarProdutoPorCategoria(any(CategoriaEnum.class))).thenReturn(List.of(produto));

        var dadosProduto = produtoUseCase.buscarPorCategoria(ACOMPANHAMENTO);

        verify(produtoMongoAdapterPort, times(1))
                .buscarProdutoPorCategoria(any(CategoriaEnum.class));
        verify(produtoMapper, times(1)).toListDadosProduto(anyList());
        assertNotNull(dadosProduto);
        assertFalse(dadosProduto.isEmpty());
    }

    @Test
    void givenAnOptionalWithProduto_whenSendIdToDeleteProduto_thenSucceed() {
        when(produtoMongoAdapterPort.buscarPorId(anyString())).thenReturn(Optional.of(getProdutoMock()));
        doNothing().when(produtoMongoAdapterPort).removerProduto(anyString());

        var produto = produtoUseCase.remover("1");

        assertFalse(produto.isEmpty());
        assertNotNull(produto.get());
    }

    @Test
    void givenAnEmptyOptional_whenSendIdToDeleteProduto_thenSucceed() {
        when(produtoMongoAdapterPort.buscarPorId(anyString())).thenReturn(Optional.empty());

        var produto = produtoUseCase.remover("1");

        assertTrue(produto.isEmpty());
    }
}
