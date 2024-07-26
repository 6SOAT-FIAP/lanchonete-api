package pos.fiap.lanchonete.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pos.fiap.lanchonete.domain.enums.StatusPedidoEnum;
import pos.fiap.lanchonete.domain.model.DadosPedido;
import pos.fiap.lanchonete.domain.model.DadosProduto;
import pos.fiap.lanchonete.domain.model.entity.mapper.PedidoMapper;
import pos.fiap.lanchonete.port.PedidoMongoAdapterPort;
import pos.fiap.lanchonete.port.PedidoUseCasePort;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static pos.fiap.lanchonete.domain.enums.StatusPedidoEnum.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoUseCase implements PedidoUseCasePort {

    private final PedidoMapper pedidoMapper;
    private final PedidoMongoAdapterPort pedidoMongoAdapterPort;

    @Override
    public DadosPedido checkout(DadosPedido dadosPedido) {
        var valorTotal = calculaValorPedido(dadosPedido.getItens());
        var pedido = pedidoMapper.fromDadosPedido(valorTotal, dadosPedido);
        var pedidoResponse = pedidoMongoAdapterPort.cadastrarPedido(pedido);
        return pedidoMapper.toDadosPedido(pedidoResponse);
    }

    @Override
    public List<DadosPedido> listar() {
        var pedidos = pedidoMongoAdapterPort.buscarPedidos();
        return pedidoMapper.toListDadosPedido(pedidos).stream()
                .sorted(Comparator.comparing(DadosPedido::getStatusPedido, (status1, status2) -> {
                    List<StatusPedidoEnum> order = List.of(PRONTO, EM_PREPARACAO, RECEBIDO);
                    return Integer.compare(order.indexOf(status1), order.indexOf(status2));
                }).thenComparing(DadosPedido::getDataCriacao))
                .collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public DadosPedido obterPedidoPorId(String idPedido) {
        var pedido = pedidoMongoAdapterPort.obterPedidoPorId(idPedido);
        return pedidoMapper.toDadosPedido(pedido);
    }

    @Override
    public DadosPedido atualizar(String idPedido, DadosPedido dadosPedido) {
        var pedido = pedidoMongoAdapterPort.obterPedidoPorId(idPedido);
        pedido.setStatusPedido(dadosPedido.getStatusPedido());
        pedido.setDataAtualizacao(LocalDateTime.now());

        var pedidoResponse = pedidoMongoAdapterPort.cadastrarPedido(pedido);
        return pedidoMapper.toDadosPedido(pedidoResponse);
    }

    private Double calculaValorPedido(List<DadosProduto> itens) {
        return itens.stream().map(DadosProduto::getPreco).reduce(0.0, Double::sum);
    }
}
