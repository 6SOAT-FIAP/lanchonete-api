package pos.fiap.lanchonete.domain.usecase.strategies.pagamento;

import pos.fiap.lanchonete.domain.model.DadosPagamento;

public interface PagamentoStrategy {

    DadosPagamento checkoutPagamento(DadosPagamento dadosPagamento);

    void atualizarPagamento(DadosPagamento dadosPagamento);

}
