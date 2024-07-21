package pos.fiap.lanchonete.adapter.out.mongo.entities.mapper;

import org.mapstruct.Mapper;
import pos.fiap.lanchonete.adapter.out.mongo.entities.PagamentoEntity;
import pos.fiap.lanchonete.domain.model.entity.Pagamento;

@Mapper(componentModel = "spring")
public interface PagamentoEntityMapper {

    Pagamento toPagamento(PagamentoEntity pagamentoEntity);
}