package pos.fiap.lanchonete.adapter.out.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pos.fiap.lanchonete.adapter.out.mongo.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends MongoRepository<PedidoEntity, String> {
}