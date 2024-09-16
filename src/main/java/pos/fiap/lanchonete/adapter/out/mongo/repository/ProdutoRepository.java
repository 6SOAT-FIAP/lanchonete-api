package pos.fiap.lanchonete.adapter.out.mongo.repository;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pos.fiap.lanchonete.adapter.out.mongo.entities.ProdutoEntity;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProdutoRepository {

    private DynamoDbTemplate dynamoDbTemplate;

    public ProdutoEntity save(ProdutoEntity produtoEntity) {
        return dynamoDbTemplate.save(produtoEntity);
    }

    public Optional<ProdutoEntity> findById(String id) {
        var key = Key.builder().partitionValue(id).build();
        return Optional.ofNullable(dynamoDbTemplate.load(key, ProdutoEntity.class));
    }

    public List<ProdutoEntity> findByCategoria(String categoria) {
        var produtos = new ArrayList<ProdutoEntity>();
        dynamoDbTemplate.scanAll(ProdutoEntity.class, categoria).stream()
                .forEach(produtoEntityPage -> produtos.addAll(produtoEntityPage.items()));
        return produtos;
    }

    public void delete(ProdutoEntity produtoEntity) {
        dynamoDbTemplate.delete(produtoEntity);
    }
}
