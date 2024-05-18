package pos.fiap.lanchonete.objectmother;

import pos.fiap.lanchonete.adapter.in.api.dto.ClienteResponseDto;

public class ClienteResponseDtoObjectMother {

    public static ClienteResponseDto getClienteResponseDtoMock() {
        return ClienteResponseDto.builder()
                .cpf("1234")
                .email("teste@teste.com")
                .nome("Fulano")
                .build();
    }
}
