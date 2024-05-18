package pos.fiap.lanchonete.adapter.out.mongo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pos.fiap.lanchonete.adapter.out.mongo.entities.mapper.ClienteEntityMapper;
import pos.fiap.lanchonete.adapter.out.mongo.repository.ClienteRepository;
import pos.fiap.lanchonete.domain.model.entity.Cliente;
import pos.fiap.lanchonete.port.MongoAdapterPort;

import java.util.Optional;

import static pos.fiap.lanchonete.utils.Constantes.FIM;
import static pos.fiap.lanchonete.utils.Constantes.INICIO;

@Slf4j
@Component
@RequiredArgsConstructor
public class MongoAdapter implements MongoAdapterPort {
    private static final String SERVICE_NAME = "MongoAdapter";
    private static final String STRING_LOG_FORMAT = "%s_%s_%s {}";
    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        var methodName = "cadastrarCliente";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), cliente);

        var clienteEntity = clienteEntityMapper.toEntity(cliente);
        clienteEntity = clienteRepository.save(clienteEntity);

        var clienteSaved = clienteEntityMapper.toCliente(clienteEntity);
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), clienteEntity);
        return clienteSaved;
    }

    @Override
    public Optional<Cliente> procurarClientePorCpf(String cpf) {
        var methodName = "procurarClientePorCpf";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), cpf);

        var clienteEntity = clienteRepository.findById(cpf);

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), clienteEntity);
        return clienteEntity.map(clienteEntityMapper::toCliente);
    }
}
