package pos.fiap.lanchonete.objectmother;

import pos.fiap.lanchonete.adapter.in.api.dto.ClienteRequestDto;

public class ClienteRequestDtoObjectMother {

    public static ClienteRequestDto getClienteRequestDtoMock() {
        return ClienteRequestDto.builder()
                .cpf("123")
                .email("teste@teste.com")
                .nome("Fulano")
                .build();
    }
}
