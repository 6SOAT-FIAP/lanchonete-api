package pos.fiap.lanchonete.port;

import pos.fiap.lanchonete.domain.model.entity.Pagamento;

public interface PagamentoMongoAdapterPort {
    Pagamento buscarStatusPagamento(String idPedido);
}