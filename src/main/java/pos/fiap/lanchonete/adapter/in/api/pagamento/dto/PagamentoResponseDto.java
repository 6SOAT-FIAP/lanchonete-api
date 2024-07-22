package pos.fiap.lanchonete.adapter.in.api.pagamento.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pos.fiap.lanchonete.adapter.in.api.enums.StatusPagamentoEnum;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagamentoResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -164114208446131289L;
    private StatusPagamentoEnum statusPagamento;
    private String qrCode;
}