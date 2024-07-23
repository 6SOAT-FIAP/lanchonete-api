package pos.fiap.lanchonete.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import pos.fiap.lanchonete.domain.model.DadosPedido;
import pos.fiap.lanchonete.port.MercadoPagoPort;
import pos.fiap.lanchonete.port.PagamentoUseCasePort;
import pos.fiap.lanchonete.port.PagamentoWebHookPort;
import pos.fiap.lanchonete.port.PedidoUseCasePort;

import static pos.fiap.lanchonete.domain.enums.StatusPagamentoEnum.APROVADO;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoWebHookUseCase implements PagamentoWebHookPort {
    private final PedidoUseCasePort pedidoUseCasePort;
    private final MercadoPagoPort mercadoPagoPort;
    private final PagamentoUseCasePort pagamentoUseCasePort;

    @Override
    public void processarPagamento(String merchantOrderId) {
        var numeroPedido = mercadoPagoPort.obterNumeroPedido(merchantOrderId);
        var dadosPedido = obterDadosPedido(numeroPedido);
        var dadosPagamento = pagamentoUseCasePort.obterDadosPagamento(numeroPedido);

        atualizarDadosPagamento(dadosPagamento, dadosPedido);
        pagamentoUseCasePort.atualizarPagamento(dadosPagamento);
    }

    private static void atualizarDadosPagamento(DadosPagamento dadosPagamento, DadosPedido dadosPedido) {
        dadosPagamento.setDadosPedido(dadosPedido);
        dadosPagamento.setStatusPagamento(APROVADO);
    }

    private DadosPedido obterDadosPedido(String numeroPedido) {
        var dadosPedido = pedidoUseCasePort.obterPedidoPorId(numeroPedido);
        dadosPedido.atualizarData();
        return dadosPedido;
    }
}
