package pos.fiap.lanchonete.domain.model;

import lombok.Builder;
import lombok.Data;
import pos.fiap.lanchonete.domain.enums.StatusPedidoEnum;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private String qrCode;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private StatusPedidoEnum statusPedido;

    public void atualizarData() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
