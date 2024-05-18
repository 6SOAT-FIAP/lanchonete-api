package pos.fiap.lanchonete.port;

import pos.fiap.lanchonete.domain.model.entity.Cliente;

import java.util.Optional;

public interface MongoAdapterPort {

    Cliente cadastrarCliente(Cliente cliente);

    Optional<Cliente> procurarClientePorCpf(String cpf);
}
