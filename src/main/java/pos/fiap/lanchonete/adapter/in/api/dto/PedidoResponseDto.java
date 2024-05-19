package pos.fiap.lanchonete.adapter.in.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5675009956810195511L;
    private String numeroPedido;
    private String mensagemPedido;
}
