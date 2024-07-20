package pos.fiap.lanchonete.adapter.out.mongo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pos.fiap.lanchonete.adapter.in.api.enums.StatusPagamentoEnum;

import java.util.UUID;

@Data
@Document("pagamento")
public class PagamentoEntity {

    @Id
    @Indexed(unique = true)
    private String id;
    private StatusPagamentoEnum statusPagamento;
    private String idPedido;

    public PagamentoEntity(StatusPagamentoEnum statusPagamento, String idPedido) {
        this.id = UUID.randomUUID().toString();
        this.statusPagamento = statusPagamento;
        this.idPedido = idPedido;
    }
}