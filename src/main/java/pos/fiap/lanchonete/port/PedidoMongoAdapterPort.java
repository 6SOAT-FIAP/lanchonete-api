package pos.fiap.lanchonete.port;

import pos.fiap.lanchonete.domain.model.entity.Pedido;

import java.util.List;

public interface PedidoMongoAdapterPort {

    Pedido cadastrarPedido(Pedido pedido);

    List<Pedido> buscarPedidos();
}
