package pos.fiap.lanchonete.domain.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pos.fiap.lanchonete.domain.model.DadosCliente;
import pos.fiap.lanchonete.domain.model.entity.Cliente;
import pos.fiap.lanchonete.domain.model.entity.mapper.ClienteMapper;
import pos.fiap.lanchonete.port.MongoAdapterPort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static pos.fiap.lanchonete.objectmother.ClienteObjectMother.getClienteMock;
import static pos.fiap.lanchonete.objectmother.DadosClienteObjectMother.getDadosClienteMock;

@ExtendWith(MockitoExtension.class)
class ClienteUseCaseTest {
    @Mock
    private MongoAdapterPort mongoAdapterPort;
    @Spy
    private ClienteMapper clienteMapper = Mappers.getMapper(ClienteMapper.class);
    @InjectMocks
    private ClienteUseCase clienteUseCase;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = getClienteMock();
    }

    @Test
    void givenCliente_whenSendDadosCliente_thenSucceed() {
        when(mongoAdapterPort.cadastrarCliente(any(Cliente.class))).thenReturn(cliente);

        var dadosCliente = clienteUseCase.cadastrar(getDadosClienteMock());

        verify(mongoAdapterPort, times(1)).cadastrarCliente(any(Cliente.class));
        verify(clienteMapper, times(1)).fromDadosCliente(any(DadosCliente.class));
        verify(clienteMapper, times(1)).toDadosCliente(any(Cliente.class));
        assertNotNull(dadosCliente);
        assertNotNull(dadosCliente.getCpf());
    }

    @Test
    void givenCliente_whenSendACpfFromCliente_thenSucceed() {
        when(mongoAdapterPort.procurarClientePorCpf(anyString())).thenReturn(Optional.of(cliente));

        var dadosCliente = clienteUseCase.procurarPorCpf("1234");

        verify(mongoAdapterPort, times(1)).procurarClientePorCpf(cliente.getCpf());
        verify(clienteMapper, times(1)).toDadosCliente(any(Cliente.class));
        assertTrue(dadosCliente.isPresent());
        assertNotNull(dadosCliente.get());
    }

    @Test
    void givenANotPresentCliente_whenSendAInvalidCpf_thenSucceed() {
        when(mongoAdapterPort.procurarClientePorCpf(anyString())).thenReturn(Optional.empty());

        var dadosCliente = clienteUseCase.procurarPorCpf("1");

        verify(mongoAdapterPort, times(1)).procurarClientePorCpf("1");
        verify(clienteMapper, times(0)).toDadosCliente(any(Cliente.class));
        assertFalse(dadosCliente.isPresent());
    }
}
