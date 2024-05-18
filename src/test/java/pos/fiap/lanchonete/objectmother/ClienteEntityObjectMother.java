package pos.fiap.lanchonete.objectmother;

import pos.fiap.lanchonete.adapter.out.mongo.entities.ClienteEntity;

public class ClienteEntityObjectMother {

    public static ClienteEntity getClienteEntityMock() {
        return ClienteEntity.builder()
                .cpf("1234")
                .email("teste@teste.com")
                .nome("Fulano")
                .build();
    }
}
