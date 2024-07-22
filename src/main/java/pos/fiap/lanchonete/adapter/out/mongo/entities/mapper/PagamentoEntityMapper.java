package pos.fiap.lanchonete.adapter.out.mongo.entities.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pos.fiap.lanchonete.adapter.out.mongo.entities.PagamentoEntity;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import pos.fiap.lanchonete.domain.model.entity.Pagamento;

@Mapper(componentModel = "spring")
public interface PagamentoEntityMapper {

    Pagamento toPagamento(PagamentoEntity pagamentoEntity);

    @Mapping(target = "idPedido", source = "dadosPagamento.dadosPedido.numeroPedido")
    @Mapping(target = "qrCode", source = "dadosPagamento.qrCode")
    @Mapping(target = "qrCodeId", source = "dadosPagamento.qrCodeId")
    PagamentoEntity toEntity(DadosPagamento dadosPagamento);

    @Mapping(target = "dadosPedido.numeroPedido", source = "pagamentoEntity.idPedido")
    DadosPagamento toDadosPagamento(PagamentoEntity pagamentoEntity);

}