package pos.fiap.lanchonete.adapter.in.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pos.fiap.lanchonete.adapter.in.api.dto.PedidoRequestDto;
import pos.fiap.lanchonete.adapter.in.api.dto.PedidoResponseDto;
import pos.fiap.lanchonete.adapter.in.api.dto.mapper.PedidoDtoMapper;
import pos.fiap.lanchonete.port.PedidoUseCasePort;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/pedido")
@RestController
public class PedidoController {

    private final PedidoDtoMapper dtoMapper;
    private final PedidoUseCasePort pedidoUseCasePort;

    @PostMapping
    public ResponseEntity<PedidoResponseDto> checkout(@RequestBody PedidoRequestDto pedidoRequestDto) {
        log.info("Pedido request, itens: {}", pedidoRequestDto);

        var dadosPedido = dtoMapper.toDadosPedidoFromRequestDto(pedidoRequestDto);

        var pedido = pedidoUseCasePort.checkout(dadosPedido);

        var pedidoResponse = dtoMapper.toPedidoResponseDtoFromDadosPedido(pedido);

        log.info("Pedido enviado para a fila: {}", dadosPedido);
        return ResponseEntity.status(CREATED).body(pedidoResponse);
    }

    public void listar() {

    }
}
