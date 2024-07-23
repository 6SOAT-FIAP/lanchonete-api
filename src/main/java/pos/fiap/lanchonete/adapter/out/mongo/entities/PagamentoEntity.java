package pos.fiap.lanchonete.adapter.out.mongo.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pos.fiap.lanchonete.domain.enums.MetodoPagamentoEnum;
import pos.fiap.lanchonete.domain.enums.StatusPagamentoEnum;
import pos.fiap.lanchonete.domain.model.DadosPagamento;

import java.time.LocalDateTime;
import java.util.UUID;

import static pos.fiap.lanchonete.domain.enums.StatusPagamentoEnum.AGUARDANDO;

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

    public void atualizarDadosEntity(DadosPagamento dadosPagamento) {
        this.statusPagamento = dadosPagamento.getStatusPagamento();
        this.idPedido = dadosPagamento.getDadosPedido().getNumeroPedido();
        this.qrCode = dadosPagamento.getQrCode();
        this.qrCodeId = dadosPagamento.getQrCodeId();
        this.metodoPagamento = dadosPagamento.getMetodoPagamento();
        this.dataAtualizacao = LocalDateTime.now();
    }
}