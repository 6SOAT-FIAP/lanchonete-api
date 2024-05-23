package pos.fiap.lanchonete.objectmother;

import pos.fiap.lanchonete.adapter.in.api.dto.PedidoRequestDto;

import java.util.List;

import static pos.fiap.lanchonete.objectmother.ProdutoRequestDtoObjectMother.getProdutoRequestDtoMock;

public class PedidoRequestDtoObjectMother {

    public static PedidoRequestDto getPedidoRequestDtoMock() {
        return PedidoRequestDto.builder()
                .cpfCliente("12345648")
                .itens(List.of(getProdutoRequestDtoMock()))
                .build();
    }
}
