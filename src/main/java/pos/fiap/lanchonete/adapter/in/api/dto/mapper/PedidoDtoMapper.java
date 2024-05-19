package pos.fiap.lanchonete.adapter.in.api.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pos.fiap.lanchonete.adapter.in.api.dto.PedidoRequestDto;
import pos.fiap.lanchonete.adapter.in.api.dto.PedidoResponseDto;
import pos.fiap.lanchonete.domain.model.DadosPedido;
import pos.fiap.lanchonete.utils.Constantes;

import java.util.List;

@Mapper(componentModel = "spring", imports = Constantes.class)
public interface PedidoDtoMapper {
    @Mapping(target = "itens", source = "pedidoRequest.itens")
    @Mapping(target = "cpfCliente", source = "pedidoRequest.cpfCliente")
    DadosPedido toDadosPedidoFromRequestDto(PedidoRequestDto pedidoRequest);

    @Mapping(target = "numeroPedido", source = "pedido.numeroPedido")
    @Mapping(target = "mensagemPedido", source = "pedido.mensagemPedido")
    PedidoResponseDto toPedidoResponseDtoFromDadosPedido(DadosPedido pedido);

    List<PedidoResponseDto> toListPedidoResponseDtoFromListDadosPedido(List<DadosPedido> pedidos);
}
