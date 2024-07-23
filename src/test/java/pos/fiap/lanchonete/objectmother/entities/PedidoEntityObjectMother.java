package pos.fiap.lanchonete.objectmother.entities;

import pos.fiap.lanchonete.adapter.out.mongo.entities.PedidoEntity;

import java.util.List;

import static pos.fiap.lanchonete.objectmother.entities.ProdutoEntityObjectMother.getProdutoEntityMock;

public class PedidoEntityObjectMother {

    public static PedidoEntity getPedidoEntityMock() {
        return PedidoEntity.builder()
                .numeroPedido("12342")
                .cpfCliente("12345678")
                .valorTotal(Double.valueOf("100.00"))
                .itens(List.of(getProdutoEntityMock()))
                .build();
    }
}
