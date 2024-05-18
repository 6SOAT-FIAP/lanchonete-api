package pos.fiap.lanchonete.domain.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pos.fiap.lanchonete.domain.model.entity.mapper.ClienteMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static pos.fiap.lanchonete.domain.objectmother.DadosClienteObjectMother.getDadosClienteMock;

@ExtendWith(MockitoExtension.class)
class ClienteUseCaseTest {
    @Spy
    private ClienteMapper clienteMapper = Mappers.getMapper(ClienteMapper.class);

    @InjectMocks
    private ClienteUseCase clienteUseCase;

    @Test
    void givenCliente_whenSendDadosCliente_thenSucceed() {
        var cliente = clienteUseCase.cadastrar(getDadosClienteMock());

        assertNotNull(cliente);
        assertNotNull(cliente.getCpf());
    }
}
