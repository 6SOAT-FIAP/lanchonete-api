package pos.fiap.lanchonete.adapter.out.mongo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pos.fiap.lanchonete.adapter.out.mongo.entities.PagamentoEntity;
import pos.fiap.lanchonete.adapter.out.mongo.entities.mapper.PagamentoEntityMapper;
import pos.fiap.lanchonete.adapter.out.mongo.repository.PagamentoRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static pos.fiap.lanchonete.objectmother.entities.PagamentoEntityObjectMother.getPagamentoAprovadoEntityMock;

@ExtendWith(MockitoExtension.class)
class PagamentoMongoAdapterTest {
    @Mock
    private PagamentoRepository pagamentoRepository;
    @Spy
    private PagamentoEntityMapper pagamentoEntityMapper = Mappers.getMapper(PagamentoEntityMapper.class);
    @InjectMocks
    private PagamentoMongoAdapter pagamentoMongoAdapter;

    @Test
    void testObterDadosPagamento_Success() {
        when(pagamentoRepository.findByIdPedido(anyString())).thenReturn(getPagamentoAprovadoEntityMock());

        var pagamento = pagamentoMongoAdapter.obterDadosPagamento("123");

        verify(pagamentoRepository, times(1)).findByIdPedido(anyString());
        verify(pagamentoEntityMapper, times(1)).toPagamento(any(PagamentoEntity.class));
        assertNotNull(pagamento);
    }
}
