package pos.fiap.lanchonete.objectmother;

import pos.fiap.lanchonete.adapter.in.api.dto.PedidoResponseDto;

import java.util.List;

import static pos.fiap.lanchonete.objectmother.DadosProdutoObjectMother.getDadosProdutoMock;

public class PedidoResponseDtoObjectMother {

    public static PedidoResponseDto getPedidoResponseDtoMock() {
        return PedidoResponseDto.builder()
                .cpfCliente("56165163")
                .numeroPedido("1651652")
                .itens(List.of(getDadosProdutoMock()))
                .valorTotal(Double.valueOf("100.00"))
                .mensagemPedido("")
                .build();
    }
}
