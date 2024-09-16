package pos.fiap.lanchonete.adapter.out.mongo.entities;

import lombok.Builder;
import lombok.Data;
import pos.fiap.lanchonete.domain.enums.CategoriaEnum;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.net.URL;

@Data
@Builder
//@Document("produto")
@DynamoDbBean
public class ProdutoEntity {

    //    @Id
    private String id;
    private String nome;
    private CategoriaEnum categoria;
    private Double preco;
    private String descricao;
    private URL imagem;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("numero_pedido")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbAttribute("nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @DynamoDbAttribute("categoria")
    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    @DynamoDbAttribute("preco")
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @DynamoDbAttribute("descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @DynamoDbAttribute("imagem")
    public URL getImagem() {
        return imagem;
    }

    public void setImagem(URL imagem) {
        this.imagem = imagem;
    }
}
