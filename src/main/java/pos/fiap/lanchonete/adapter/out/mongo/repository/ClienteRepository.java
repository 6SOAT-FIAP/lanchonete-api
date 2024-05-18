package pos.fiap.lanchonete.adapter.out.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pos.fiap.lanchonete.adapter.out.mongo.entities.ClienteEntity;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {
}
