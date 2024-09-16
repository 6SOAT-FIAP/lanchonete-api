package pos.fiap.lanchonete.adapter.out.mongo.repository;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pos.fiap.lanchonete.adapter.out.mongo.entities.ClienteEntity;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ClienteRepository {

    private DynamoDbTemplate dynamoDbTemplate;

    public Optional<ClienteEntity> findById(String cpf) {
        var key = Key.builder().partitionValue(cpf).build();
        return Optional.ofNullable(dynamoDbTemplate.load(key, ClienteEntity.class));
    }

    public ClienteEntity save(ClienteEntity clienteEntity) {
        return dynamoDbTemplate.save(clienteEntity);
    }

}
