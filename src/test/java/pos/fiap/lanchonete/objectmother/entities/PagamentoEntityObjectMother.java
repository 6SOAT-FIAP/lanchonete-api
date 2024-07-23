package pos.fiap.lanchonete.objectmother.entities;

import pos.fiap.lanchonete.adapter.out.mongo.entities.PagamentoEntity;

import static pos.fiap.lanchonete.domain.enums.StatusPagamentoEnum.APROVADO;

public class PagamentoEntityObjectMother {

    public static PagamentoEntity getPagamentoAprovadoEntityMock() {
        return PagamentoEntity.builder()
                .statusPagamento(APROVADO)
                .idPedido("123")
                .build();
    }
}
