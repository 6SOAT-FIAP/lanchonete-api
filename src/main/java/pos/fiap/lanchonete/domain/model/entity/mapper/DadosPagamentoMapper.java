package pos.fiap.lanchonete.domain.model.entity.mapper;

import org.mapstruct.Mapper;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import pos.fiap.lanchonete.domain.model.entity.Pagamento;

@Mapper(componentModel = "spring")
public interface DadosPagamentoMapper {

    DadosPagamento fromPagamento(Pagamento pagamento);

}