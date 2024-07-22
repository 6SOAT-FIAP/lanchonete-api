package pos.fiap.lanchonete.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pos.fiap.lanchonete.port.MercadoPagoPort;
import pos.fiap.lanchonete.port.PagamentoUseCasePort;
import pos.fiap.lanchonete.port.PagamentoWebHookPort;
import pos.fiap.lanchonete.port.PedidoUseCasePort;

import java.time.LocalDateTime;

import static pos.fiap.lanchonete.adapter.in.api.enums.StatusPagamentoEnum.APROVADO;

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
        var dadosPedido = pedidoUseCasePort.obterPedidoPorId(numeroPedido);
        dadosPedido.setDataAtualizacao(LocalDateTime.now());
        var dadosPagamento = pagamentoUseCasePort.obterDadosPagamento(numeroPedido);
        dadosPagamento.setStatusPagamento(APROVADO);
        pagamentoUseCasePort.atualizarPagamento(dadosPagamento);
    }
}
