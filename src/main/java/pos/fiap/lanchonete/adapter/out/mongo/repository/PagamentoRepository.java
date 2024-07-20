package pos.fiap.lanchonete.adapter.out.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pos.fiap.lanchonete.adapter.out.mongo.entities.PagamentoEntity;

@Repository
public interface PagamentoRepository extends MongoRepository<PagamentoEntity, String> {

    PagamentoEntity findByIdPedido(String idPedido);
}