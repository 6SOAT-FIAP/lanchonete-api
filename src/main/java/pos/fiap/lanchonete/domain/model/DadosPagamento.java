package pos.fiap.lanchonete.domain.model;

import lombok.Builder;
import lombok.Data;
import pos.fiap.lanchonete.adapter.in.api.enums.StatusPagamentoEnum;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class DadosPagamento implements Serializable {

    @Serial
    private static final long serialVersionUID = -8888154278106197658L;
    private StatusPagamentoEnum statusPagamento;
}