package pos.fiap.lanchonete.adapter.out.mongo.entities;

import lombok.Builder;
import lombok.Data;
import pos.fiap.lanchonete.domain.enums.MetodoPagamentoEnum;
import pos.fiap.lanchonete.domain.enums.StatusPagamentoEnum;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDateTime;
import java.util.UUID;

import static pos.fiap.lanchonete.domain.enums.StatusPagamentoEnum.AGUARDANDO;

@Data
@DynamoDbBean
//@Document("pagamento")
public class PagamentoEntity {

    private String id;
    private StatusPagamentoEnum statusPagamento;
    private String idPedido;
    private String qrCode;
    private String qrCodeId;
    private MetodoPagamentoEnum metodoPagamento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbAttribute("status_pagamento_enum")
    public StatusPagamentoEnum getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamentoEnum statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    @DynamoDbAttribute("id_pedido")
    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    @DynamoDbAttribute("qr_code")
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @DynamoDbAttribute("qr_code_ID")
    public String getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    @DynamoDbAttribute("metodo_pagamento")
    public MetodoPagamentoEnum getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamentoEnum metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    @DynamoDbAttribute("data_criacao")
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @DynamoDbAttribute("data_atualizacao")
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

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