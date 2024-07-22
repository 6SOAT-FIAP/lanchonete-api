package pos.fiap.lanchonete.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import pos.fiap.lanchonete.domain.model.entity.mapper.DadosPagamentoMapper;
import pos.fiap.lanchonete.domain.usecase.strategies.pagamento.PagamentoContext;
import pos.fiap.lanchonete.port.PagamentoMongoAdapterPort;
import pos.fiap.lanchonete.port.PagamentoUseCasePort;
import pos.fiap.lanchonete.port.PedidoUseCasePort;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoUseCase implements PagamentoUseCasePort {

    private final PagamentoMongoAdapterPort pagamentoMongoAdapterPort;
    private final DadosPagamentoMapper dadosPagamentoMapper;
    private final PedidoUseCasePort pedidoUseCasePort;
    private final PagamentoContext pagamentoContext;

    @Override
    public DadosPagamento obterDadosPagamento(String idPedido) {
        return pagamentoMongoAdapterPort.obterDadosPagamento(idPedido);
    }

    @Override
    @SneakyThrows
    public DadosPagamento processarPagamento(pos.fiap.lanchonete.domain.model.DadosPagamento dadosPagamento) {
        var dadosPedido = pedidoUseCasePort.obterPedidoPorId(dadosPagamento.getDadosPedido().getNumeroPedido());
        dadosPagamento.setDadosPedido(dadosPedido);
        return pagamentoContext.processarPagamento(dadosPagamento);
    }

    @Override
    public void atualizarPagamento(pos.fiap.lanchonete.domain.model.DadosPagamento dadosPagamento) {
        pagamentoContext.atualizarPagamento(dadosPagamento);
    }
}