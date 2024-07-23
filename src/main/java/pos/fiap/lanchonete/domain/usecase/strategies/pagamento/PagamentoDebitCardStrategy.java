package pos.fiap.lanchonete.domain.usecase.strategies.pagamento;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import pos.fiap.lanchonete.port.PagamentoMongoAdapterPort;

import static pos.fiap.lanchonete.domain.enums.StatusPagamentoEnum.APROVADO;

@Component
@RequiredArgsConstructor
public class PagamentoDebitCardStrategy implements PagamentoStrategy {
    private final PagamentoMongoAdapterPort pagamentoMongoAdapterPort;

    @Override
    public DadosPagamento checkoutPagamento(DadosPagamento dadosPagamento) {
        var message = String.format("Pagamento via cartão de débito no valor de %.2f" +
                " foi realizado com sucesso e seu pedido está em preparação", dadosPagamento.getDadosPedido().getValorTotal());

        dadosPagamento.getDadosPedido().setMensagemPedido(message);
        dadosPagamento.setStatusPagamento(APROVADO);
        return pagamentoMongoAdapterPort.salvarPagamento(dadosPagamento);
    }

    @Override
    public void atualizarPagamento(DadosPagamento dadosPagamento) {
        pagamentoMongoAdapterPort.salvarPagamento(dadosPagamento);
    }
}
