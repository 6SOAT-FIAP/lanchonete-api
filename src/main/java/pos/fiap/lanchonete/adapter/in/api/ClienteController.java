package pos.fiap.lanchonete.adapter.in.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.fiap.lanchonete.adapter.in.api.dto.ClienteRequestDto;
import pos.fiap.lanchonete.adapter.in.api.dto.ClienteResponseDto;
import pos.fiap.lanchonete.adapter.in.api.dto.mapper.ClienteDtoMapper;
import pos.fiap.lanchonete.port.ClienteUseCasePort;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final ClienteDtoMapper clienteDtoMapper;
    private final ClienteUseCasePort clienteUseCasePort;

    @PostMapping
    public ResponseEntity<ClienteResponseDto> cadastrar(@RequestBody ClienteRequestDto clienteRequestDto) {
        log.info("Cliente request: {}", clienteRequestDto);
        var dadosCliente = clienteDtoMapper.toDadosClientefromRequestDto(clienteRequestDto);

        final var clienteCadastrado = clienteUseCasePort.cadastrar(dadosCliente);

        var clienteResponse = clienteDtoMapper.toClienteResponseDtoFromDadosCliente(clienteCadastrado);
        log.info("Cliente response: {}", clienteResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<ClienteResponseDto> procurarPorCpf(@PathVariable String cpf) {
        log.info("CPF request: {}", cpf);
        final var clienteCadastrado = clienteUseCasePort.procurarPorCpf(cpf);

        if (clienteCadastrado.isPresent()) {
            var clienteResponse = clienteDtoMapper.toClienteResponseDtoFromDadosCliente(clienteCadastrado.get());
            log.info("Cliente response: {}", clienteResponse);
            return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);

        } else {
            log.info("Cliente not found: {}", cpf);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
