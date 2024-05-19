package pos.fiap.lanchonete.port;

import pos.fiap.lanchonete.domain.model.DadosPedido;

public interface PedidoUseCasePort {

    DadosPedido checkout(DadosPedido dadosPedido);
}
