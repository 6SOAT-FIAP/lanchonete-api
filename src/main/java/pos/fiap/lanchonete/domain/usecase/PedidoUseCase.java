package pos.fiap.lanchonete.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pos.fiap.lanchonete.domain.model.DadosPedido;
import pos.fiap.lanchonete.domain.model.DadosProduto;
import pos.fiap.lanchonete.domain.model.entity.mapper.PedidoMapper;
import pos.fiap.lanchonete.port.MongoAdapterPort;
import pos.fiap.lanchonete.port.PedidoUseCasePort;

import java.util.List;

import static pos.fiap.lanchonete.utils.Constantes.PEDIDO_COM_SUCESSO;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoUseCase implements PedidoUseCasePort {

    private final PedidoMapper pedidoMapper;
    private final MongoAdapterPort mongoAdapterPort;

    @Override
    public DadosPedido checkout(DadosPedido dadosPedido) {
        var valorTotal = calculaValorPedido(dadosPedido.getItens());
        var pedido = pedidoMapper.fromDadosPedido(valorTotal, dadosPedido);
        var pedidoResponse = mongoAdapterPort.cadastrarPedido(pedido);
        pedidoResponse.setMensagemPedido(PEDIDO_COM_SUCESSO);
        return pedidoMapper.toDadosPedido(pedidoResponse);
    }

    private Double calculaValorPedido(List<DadosProduto> itens) {
        return itens.stream().map(DadosProduto::getPreco).reduce(0.0, Double::sum);
    }
}
