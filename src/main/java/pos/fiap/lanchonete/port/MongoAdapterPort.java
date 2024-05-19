package pos.fiap.lanchonete.port;

import pos.fiap.lanchonete.domain.model.entity.Cliente;
import pos.fiap.lanchonete.domain.model.entity.Pedido;
import pos.fiap.lanchonete.domain.model.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface MongoAdapterPort {

    Cliente cadastrarCliente(Cliente cliente);

    Optional<Cliente> procurarClientePorCpf(String cpf);

    Produto cadastrarProduto(Produto produto);

    Produto alterarProduto(String id, Produto produto);

    void removerProduto(String id);

    List<Produto> buscarProdutoPorCategoria(String categoria);

    Pedido cadastrarPedido(Pedido pedido);
}