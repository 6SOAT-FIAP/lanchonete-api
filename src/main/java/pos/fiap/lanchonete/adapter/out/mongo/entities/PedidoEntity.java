package pos.fiap.lanchonete.adapter.out.mongo.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pos.fiap.lanchonete.domain.enums.StatusPedidoEnum;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
//@Document("pedido")
@DynamoDbBean
public class PedidoEntity {

    private String numeroPedido;
    private String cpfCliente;
    private Double valorTotal;
    private List<ProdutoEntity> itens;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private StatusPedidoEnum statusPedido;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("numero_pedido")
    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    @DynamoDbAttribute("cpf_cliente")
    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    @DynamoDbAttribute("valor_total")
    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @DynamoDbAttribute("itens")
    public List<ProdutoEntity> getItens() {
        return itens;
    }

    public void setItens(List<ProdutoEntity> itens) {
        this.itens = itens;
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

    @DynamoDbAttribute("status_pedido")
    public StatusPedidoEnum getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedidoEnum statusPedido) {
        this.statusPedido = statusPedido;
    }
}
