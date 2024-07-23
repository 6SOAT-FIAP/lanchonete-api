package pos.fiap.lanchonete.domain.usecase.strategies.pagamento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pos.fiap.lanchonete.domain.model.DadosPagamento;
import pos.fiap.lanchonete.port.MercadoPagoPort;
import pos.fiap.lanchonete.port.PagamentoMongoAdapterPort;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static pos.fiap.lanchonete.objectmother.dtos.out.PagamentoMPResponseDtoObjectMother.getPagamentoMPResponseDtoMock;
import static pos.fiap.lanchonete.objectmother.model.DadosPagamentoObjectMother.getDadosPagamentoMock;

@ExtendWith(MockitoExtension.class)
class PagamentoDebitCardStrategyTest {
    @Mock
    private MercadoPagoPort mercadoPagoPort;
    @Mock
    private PagamentoMongoAdapterPort pagamentoMongoAdapterPort;
    @InjectMocks
    private PagamentoDebitCardStrategy pagamentoDebitCardStrategy;

    @Test
    void processarPagamento_whenSendDadosPagamento_thenSucceed() {
        var dadosPagamento = getDadosPagamentoMock();
        when(mercadoPagoPort.gerarPagamentoQRCode(any(DadosPagamento.class)))
                .thenReturn(getPagamentoMPResponseDtoMock());
        when(pagamentoMongoAdapterPort.salvarPagamento(any(DadosPagamento.class))).thenReturn(dadosPagamento);

        var retorno = pagamentoDebitCardStrategy.processarPagamento(dadosPagamento);

        assertNotNull(retorno);
        verify(mercadoPagoPort, times(1)).gerarPagamentoQRCode(any(DadosPagamento.class));
        verify(pagamentoMongoAdapterPort, times(1)).salvarPagamento(any(DadosPagamento.class));
    }

    @Test
    void atualizarPagamento_whenSendDadosPagamento_thenSucceed() {
        var dadosPagamento = getDadosPagamentoMock();
        when(pagamentoMongoAdapterPort.salvarPagamento(any(DadosPagamento.class))).thenReturn(dadosPagamento);

        pagamentoDebitCardStrategy.atualizarPagamento(dadosPagamento);

        verify(pagamentoMongoAdapterPort, times(1)).salvarPagamento(any(DadosPagamento.class));
    }
}
