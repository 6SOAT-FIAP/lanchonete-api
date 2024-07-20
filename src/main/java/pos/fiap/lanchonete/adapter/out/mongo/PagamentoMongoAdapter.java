package pos.fiap.lanchonete.adapter.out.mongo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pos.fiap.lanchonete.adapter.out.mongo.entities.mapper.PagamentoEntityMapper;
import pos.fiap.lanchonete.adapter.out.mongo.repository.PagamentoRepository;
import pos.fiap.lanchonete.domain.model.entity.Pagamento;
import pos.fiap.lanchonete.port.PagamentoMongoAdapterPort;

import static pos.fiap.lanchonete.utils.Constantes.FIM;
import static pos.fiap.lanchonete.utils.Constantes.INICIO;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagamentoMongoAdapter implements PagamentoMongoAdapterPort {

    private static final String SERVICE_NAME = "PagamentoMongoAdapter";
    private static final String BUSCAR_STATUS_PAGAMENTO_METHOD_NAME = "buscarStatusPagamento";
    private static final String STRING_LOG_FORMAT = "%s_%s_%s {}";

    private final PagamentoRepository pagamentoRepository;
    private final PagamentoEntityMapper pagamentoEntityMapper;

    @Override
    public Pagamento buscarStatusPagamento(String idPedido) {
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, BUSCAR_STATUS_PAGAMENTO_METHOD_NAME, INICIO), idPedido);

        var pagamentoEntity = pagamentoRepository.findByIdPedido(idPedido);

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, BUSCAR_STATUS_PAGAMENTO_METHOD_NAME, FIM), idPedido);
        return pagamentoEntityMapper.toPagamento(pagamentoEntity);
    }
}