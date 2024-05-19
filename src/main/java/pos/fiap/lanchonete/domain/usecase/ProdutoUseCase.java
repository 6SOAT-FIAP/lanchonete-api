package pos.fiap.lanchonete.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pos.fiap.lanchonete.domain.model.DadosProduto;
import pos.fiap.lanchonete.domain.model.entity.mapper.ProdutoMapper;
import pos.fiap.lanchonete.port.MongoAdapterPort;
import pos.fiap.lanchonete.port.ProdutoUseCasePort;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoUseCase implements ProdutoUseCasePort {

    private final ProdutoMapper produtoMapper;
    private final MongoAdapterPort mongoAdapterPort;

    @Override
    public DadosProduto cadastrar(DadosProduto dadosProduto) {
        var produto = produtoMapper.fromDadosProduto(dadosProduto);
        produto = mongoAdapterPort.cadastrarProduto(produto);
        return produtoMapper.toDadosProduto(produto);
    }

    @Override
    public DadosProduto alterar(String id, DadosProduto dadosProduto) {
        var produto = produtoMapper.fromDadosProduto(dadosProduto);
        produto = mongoAdapterPort.alterarProduto(id, produto);
        return produtoMapper.toDadosProduto(produto);
    }

    @Override
    public void remover(String id) {
        mongoAdapterPort.removerProduto(id);
    }

    @Override
    public List<DadosProduto> buscarPorCategoria(String categoria) {
        var produtoList = mongoAdapterPort.buscarProdutoPorCategoria(categoria);
        return produtoMapper.toListDadosProduto(produtoList);
    }
}
