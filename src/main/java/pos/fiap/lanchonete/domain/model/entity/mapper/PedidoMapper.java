package pos.fiap.lanchonete.domain.model.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pos.fiap.lanchonete.domain.model.DadosPedido;
import pos.fiap.lanchonete.domain.model.entity.Pedido;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "dadosPedido.itens")
    Pedido fromDadosPedido(Double valorTotal, DadosPedido dadosPedido);

    DadosPedido toDadosPedido(Pedido pedido);

    @Mapping(target = "itens", source = "pedido.itens")
    List<DadosPedido> toListDadosPedido(List<Pedido> pedidos);
}