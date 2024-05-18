package pos.fiap.lanchonete.domain.port;

import pos.fiap.lanchonete.domain.model.DadosCliente;

public interface ClienteUseCasePort {

    DadosCliente cadastrar(DadosCliente dadosCliente);
}
