package pos.fiap.lanchonete.domain.port;

import pos.fiap.lanchonete.domain.model.DadosCliente;
import pos.fiap.lanchonete.domain.model.entity.Cliente;

public interface ClienteUseCasePort {

    Cliente cadastrar(DadosCliente dadosCliente);
}
