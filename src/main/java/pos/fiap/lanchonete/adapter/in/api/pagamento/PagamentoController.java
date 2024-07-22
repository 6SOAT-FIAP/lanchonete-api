package pos.fiap.lanchonete.adapter.in.api.pagamento;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.fiap.lanchonete.adapter.in.api.pagamento.dto.PagamentoRequestDto;
import pos.fiap.lanchonete.adapter.in.api.pagamento.dto.PagamentoResponseDto;
import pos.fiap.lanchonete.adapter.in.api.pagamento.mapper.PagamentoDtoMapper;
import pos.fiap.lanchonete.adapter.out.exception.PedidoNotFoundException;
import pos.fiap.lanchonete.port.PagamentoUseCasePort;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Pagamento", description = "APIs referente aos Pagamentos")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/pagamento")
@RestController
public class PagamentoController {

    private final PagamentoUseCasePort pagamentoUseCasePort;
    private final PagamentoDtoMapper pagamentoDtoMapper;

    @Operation(summary = "Realizar pagamento pedido",
            description = "Realizar o pagamento de um pedido especifico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = PagamentoResponseDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @ResponseStatus(OK)
    @PostMapping
    public ResponseEntity<PagamentoResponseDto> realizarPagamento(@RequestBody @Valid PagamentoRequestDto pagamentoRequestDto) {
        try {
            log.info("Realizando pagamento {}", pagamentoRequestDto);

            var dadosPagamento = pagamentoDtoMapper.toDadosPagamentoFromPagamentoRequestDto(pagamentoRequestDto);
            var pagamentoProcessado = pagamentoUseCasePort.processarPagamento(dadosPagamento);
            var pagamentoResponse = pagamentoDtoMapper.toPagamentoResponseDtoFromDadosPagamento(pagamentoProcessado);

            log.info("Pagamento realizado {}", pagamentoResponse);
            return ResponseEntity.status(OK).body(pagamentoResponse);
        } catch (Exception e) {
            if (e instanceof PedidoNotFoundException) {
                return ResponseEntity.status(NOT_FOUND).build();
            }

            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Buscar status pagamento pedido",
            description = "Buscar status do pagamento de um pedido especifico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = PagamentoResponseDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @ResponseStatus(OK)
    @GetMapping("/{idPedido}")
    public ResponseEntity<PagamentoResponseDto> buscarStatusPagamento(@PathVariable String idPedido) {
        log.info("Listando status do pedido " + idPedido);

        var dadosPagamento = pagamentoUseCasePort.obterDadosPagamento(idPedido);
        var pagamentoResponse = pagamentoDtoMapper.toPagamentoResponseDtoFromDadosPagamento(dadosPagamento);

        log.info("Fim da listagem do status do pedido " + pagamentoResponse);
        return ResponseEntity.status(OK).body(pagamentoResponse);
    }
}