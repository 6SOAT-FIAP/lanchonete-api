package pos.fiap.lanchonete.adapter.out.mongo.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pos.fiap.lanchonete.adapter.out.mongo.entities.PedidoEntity;
import pos.fiap.lanchonete.domain.model.entity.Pedido;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface PedidoEntityMapper {

    @Mapping(target = "numeroPedido", defaultExpression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "valorTotal", source = "pedido.valorTotal")
    PedidoEntity toEntity(Pedido pedido);

    Pedido toPedido(PedidoEntity entity);

    List<Pedido> toListPedido(List<PedidoEntity> entity);
}
