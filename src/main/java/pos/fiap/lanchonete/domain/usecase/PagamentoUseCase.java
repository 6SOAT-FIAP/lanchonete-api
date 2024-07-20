package pos.fiap.lanchonete.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import pos.fiap.lanchonete.domain.model.entity.mapper.PagamentoMapper;
import pos.fiap.lanchonete.port.PagamentoMongoAdapterPort;
import pos.fiap.lanchonete.port.PagamentoUseCasePort;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoUseCase implements PagamentoUseCasePort {

    private final PagamentoMongoAdapterPort pagamentoMongoAdapterPort;
    private final PagamentoMapper pagamentoMapper;

    @Override
    public DadosPagamento getStatusPagamento(String idPedido) {
        var pagamento = pagamentoMongoAdapterPort.buscarStatusPagamento(idPedido);
        return pagamentoMapper.fromPagamento(pagamento);
    }
}