package pos.fiap.lanchonete.adapter.in.api.dto.mapper;

import org.mapstruct.Mapper;
import pos.fiap.lanchonete.adapter.in.api.dto.ClienteRequestDto;
import pos.fiap.lanchonete.adapter.in.api.dto.ClienteResponseDto;
import pos.fiap.lanchonete.domain.model.DadosCliente;

@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {

    DadosCliente toDadosClientefromRequestDto(ClienteRequestDto clienteRequestDto);

    ClienteResponseDto toClienteResponseDtoFromDadosCliente(DadosCliente dadosCliente);
}
