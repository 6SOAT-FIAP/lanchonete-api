package pos.fiap.lanchonete.adapter.out.mongo.repository;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pos.fiap.lanchonete.adapter.out.mongo.entities.PagamentoEntity;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PagamentoRepository {

    private DynamoDbTemplate dynamoDbTemplate;

    public Optional<PagamentoEntity> findByIdPedido(String idPedido) {
        var key = Key.builder().partitionValue(idPedido).build();
        return Optional.ofNullable(dynamoDbTemplate.load(key, PagamentoEntity.class));
    }

    public PagamentoEntity save(PagamentoEntity pagamentoEntity) {
        return dynamoDbTemplate.save(pagamentoEntity);
    }

    public void delete(PagamentoEntity pagamentoEntity) {
        dynamoDbTemplate.delete(pagamentoEntity);
    }
}