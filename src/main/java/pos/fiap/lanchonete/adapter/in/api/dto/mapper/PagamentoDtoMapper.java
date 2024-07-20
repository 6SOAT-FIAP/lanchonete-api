package pos.fiap.lanchonete.adapter.in.api.dto.mapper;

import org.mapstruct.Mapper;
import pos.fiap.lanchonete.adapter.in.api.dto.PagamentoResponseDto;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import pos.fiap.lanchonete.utils.Constantes;

@Mapper(componentModel = "spring", imports = Constantes.class)
public interface PagamentoDtoMapper {

    PagamentoResponseDto toPagamentoResponseDtoFromDadosPagamento(DadosPagamento dadosPagamento);
}