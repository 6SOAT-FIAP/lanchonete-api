package pos.fiap.lanchonete.domain.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class DadosPedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 767704268070979122L;

    private String cpfCliente;
    private String numeroPedido;
    private List<DadosProduto> itens;
    private Double valorTotal;
    private String mensagemPedido;
}
