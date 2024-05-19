package pos.fiap.lanchonete.port;

import pos.fiap.lanchonete.domain.model.DadosProduto;

import java.util.List;

public interface ProdutoUseCasePort {

    DadosProduto cadastrar(DadosProduto dadosProduto);

    DadosProduto alterar(String id, DadosProduto dadosProduto);

    void remover(String id);

    List<DadosProduto> buscarPorCategoria(String categoria);
}
