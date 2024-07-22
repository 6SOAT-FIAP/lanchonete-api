package pos.fiap.lanchonete.adapter.out.mongo.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pos.fiap.lanchonete.adapter.in.api.enums.MetodoPagamentoEnum;
import pos.fiap.lanchonete.adapter.in.api.enums.StatusPagamentoEnum;

import java.time.LocalDateTime;
import java.util.UUID;

import static pos.fiap.lanchonete.adapter.in.api.enums.StatusPagamentoEnum.AGUARDANDO;

@Data
@Document("pagamento")
public class PagamentoEntity {

    @Id
    @Indexed(unique = true)
    private String id;
    private StatusPagamentoEnum statusPagamento;
    private String idPedido;
    private String qrCode;
    private String qrCodeId;
    private MetodoPagamentoEnum metodoPagamento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public PagamentoEntity() {
        this.id = UUID.randomUUID().toString();
        this.statusPagamento = AGUARDANDO;
        this.dataCriacao = LocalDateTime.now();
    }

    @Builder
    public PagamentoEntity(StatusPagamentoEnum statusPagamento, String idPedido, String qrCode, String qrCodeId,
                           MetodoPagamentoEnum metodoPagamento) {
        this.id = UUID.randomUUID().toString();
        this.statusPagamento = statusPagamento;
        this.idPedido = idPedido;
        this.qrCode = qrCode;
        this.qrCodeId = qrCodeId;
        this.metodoPagamento = metodoPagamento;
        this.dataCriacao = LocalDateTime.now();
    }

    @Builder(builderMethodName = "buildAtt")
    public PagamentoEntity(String id, StatusPagamentoEnum statusPagamento, String idPedido, String qrCode,
                           String qrCodeId, MetodoPagamentoEnum metodoPagamento, LocalDateTime dataCriacao) {
        this.id = id;
        this.statusPagamento = statusPagamento;
        this.idPedido = idPedido;
        this.qrCode = qrCode;
        this.qrCodeId = qrCodeId;
        this.metodoPagamento = metodoPagamento;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = LocalDateTime.now();
    }

    @Builder
    public PagamentoEntity(String idPedido) {
        this.id = UUID.randomUUID().toString();
        this.statusPagamento = AGUARDANDO;
        this.idPedido = idPedido;
    }
}