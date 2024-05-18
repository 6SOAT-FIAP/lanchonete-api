package pos.fiap.lanchonete.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pos.fiap.lanchonete.domain.model.DadosCliente;
import pos.fiap.lanchonete.domain.model.entity.mapper.ClienteMapper;
import pos.fiap.lanchonete.port.ClienteUseCasePort;
import pos.fiap.lanchonete.port.MongoAdapterPort;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteUseCase implements ClienteUseCasePort {
    private final ClienteMapper clienteMapper;
    private final MongoAdapterPort mongoAdapterPort;

    @Override
    public DadosCliente cadastrar(DadosCliente dadosCliente) {
        var cliente = clienteMapper.fromDadosCliente(dadosCliente);
        cliente = mongoAdapterPort.cadastrarCliente(cliente);
        return clienteMapper.toDadosCliente(cliente);
    }

    @Override
    public Optional<DadosCliente> procurarPorCpf(String cpf) {
        var cliente = mongoAdapterPort.procurarClientePorCpf(cpf);
        return cliente.map(clienteMapper::toDadosCliente);
    }
}
