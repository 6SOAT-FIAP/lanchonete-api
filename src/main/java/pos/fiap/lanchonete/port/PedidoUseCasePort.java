package pos.fiap.lanchonete.port;

import pos.fiap.lanchonete.domain.model.DadosPedido;

import java.util.List;

public interface PedidoUseCasePort {

    DadosPedido checkout(DadosPedido dadosPedido);

    List<DadosPedido> listar();
}
