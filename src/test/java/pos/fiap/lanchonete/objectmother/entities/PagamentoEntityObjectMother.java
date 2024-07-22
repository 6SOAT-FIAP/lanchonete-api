package pos.fiap.lanchonete.objectmother.entities;

import pos.fiap.lanchonete.adapter.out.mongo.entities.PagamentoEntity;

import static pos.fiap.lanchonete.adapter.in.api.enums.StatusPagamentoEnum.APROVADO;

public class PagamentoEntityObjectMother {

    public static PagamentoEntity getPagamentoAprovadoEntityMock() {
        var pagamentoEntity = PagamentoEntity.builder()
                .statusPagamento(APROVADO)
                .idPedido("123")
                .build();
        pagamentoEntity.setId("123");
        return pagamentoEntity;
    }
}
