package pos.fiap.lanchonete.adapter.out.mongo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pos.fiap.lanchonete.adapter.out.mongo.entities.mapper.PedidoEntityMapper;
import pos.fiap.lanchonete.adapter.out.mongo.repository.PedidoRepository;
import pos.fiap.lanchonete.domain.model.entity.Pedido;
import pos.fiap.lanchonete.port.PedidoMongoAdapterPort;

import java.util.List;

import static pos.fiap.lanchonete.utils.Constantes.FIM;
import static pos.fiap.lanchonete.utils.Constantes.INICIO;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoMongoAdapter implements PedidoMongoAdapterPort {
    private static final String SERVICE_NAME = "PedidoMongoAdapter";
    private static final String CADASTRAR_PEDIDO_METHOD_NAME = "cadastrarPedido";
    private static final String BUSCAR_PEDIDOS_METHOD_NAME = "buscarPedidos";
    private static final String STRING_LOG_FORMAT = "%s_%s_%s {}";
    private final PedidoRepository pedidoRepository;
    private final PedidoEntityMapper pedidoEntityMapper;

    @Override
    public Pedido cadastrarPedido(Pedido pedido) {
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, CADASTRAR_PEDIDO_METHOD_NAME, INICIO), pedido);

        var pedidoEntity = pedidoEntityMapper.toEntity(pedido);

        var entity = pedidoRepository.save(pedidoEntity);

        var pedidoResponse = pedidoEntityMapper.toPedido(entity);

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, CADASTRAR_PEDIDO_METHOD_NAME, FIM), pedido);
        return pedidoResponse;
    }

    @Override
    public List<Pedido> buscarPedidos() {
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, BUSCAR_PEDIDOS_METHOD_NAME, INICIO), "pedidos");

        var entity = pedidoRepository.findAll();
        var pedidoList = pedidoEntityMapper.toListPedido(entity);

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, BUSCAR_PEDIDOS_METHOD_NAME, FIM), "pedidos");
        return pedidoList;
    }
}
