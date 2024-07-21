package pos.fiap.lanchonete.port;

import pos.fiap.lanchonete.domain.model.DadosPagamento;

public interface PagamentoUseCasePort {
    DadosPagamento getStatusPagamento(String idPedido);
}