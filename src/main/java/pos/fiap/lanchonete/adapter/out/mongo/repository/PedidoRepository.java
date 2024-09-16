package pos.fiap.lanchonete.adapter.out.mongo.repository;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pos.fiap.lanchonete.adapter.out.mongo.entities.PedidoEntity;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PedidoRepository {
    private DynamoDbTemplate dynamoDbTemplate;

    public Optional<PedidoEntity> findById(String idPedido) {
        var key = Key.builder().partitionValue(idPedido).build();
        return Optional.ofNullable(dynamoDbTemplate.load(key, PedidoEntity.class));
    }

    public PedidoEntity save(PedidoEntity pedidoEntity) {
        return dynamoDbTemplate.save(pedidoEntity);
    }

    public List<PedidoEntity> findAll() {
        var pedidos = new ArrayList<PedidoEntity>();
        dynamoDbTemplate.scanAll(PedidoEntity.class).stream()
                .forEach(pedidoEntityPage -> pedidos.addAll(pedidoEntityPage.items()));
        return pedidos;
    }

    public void delete(PedidoEntity pedidoEntity) {
        dynamoDbTemplate.delete(pedidoEntity);
    }
}