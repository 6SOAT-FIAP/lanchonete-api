package pos.fiap.lanchonete.adapter.in.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.fiap.lanchonete.adapter.in.api.dto.ProdutoRequestDto;
import pos.fiap.lanchonete.adapter.in.api.dto.ProdutoResponseDto;
import pos.fiap.lanchonete.adapter.in.api.dto.mapper.ProdutoDtoMapper;
import pos.fiap.lanchonete.port.ProdutoUseCasePort;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/produto")
@RestController
public class ProdutoController {

    private final ProdutoDtoMapper dtoMapper;
    private final ProdutoUseCasePort produtoUseCasePort;

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> cadastrar(@RequestBody ProdutoRequestDto produtoRequest) {
        log.info("Produto request: {}", produtoRequest);

        var dadosProduto = dtoMapper.toDadosProdutoFromRequestDto(produtoRequest);

        var produtoCadastrado = produtoUseCasePort.cadastrar(dadosProduto);

        var produtoResponse = dtoMapper.toProdutoResponseDtoFromDadosProduto(produtoCadastrado);
        log.info("Produto response: {}", produtoResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> editar(@PathVariable String id, @RequestBody ProdutoRequestDto produtoRequestDto) {
        log.info("Produto request: {}", produtoRequestDto);

        var dadosProduto = dtoMapper.toDadosProdutoFromRequestDto(produtoRequestDto);

        var produtoAlterado = produtoUseCasePort.alterar(id, dadosProduto);

        var produtoResponse = dtoMapper.toProdutoResponseDtoFromDadosProduto(produtoAlterado);

        log.info("Produto response: {}", produtoResponse);
        return ResponseEntity.status(OK).body(produtoResponse);
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id) {
        log.info("Produto id: {}", id);

        produtoUseCasePort.remover(id);

        log.info("Produto Id: {} removido", id);
    }

    @GetMapping("/{categoria}")
    public List<ProdutoResponseDto> buscar(@PathVariable String categoria) {
        log.info("Categoria request: {}", categoria);

        var produtosList = produtoUseCasePort.buscarPorCategoria(categoria);

        var produtoResponseList = dtoMapper.toListProdutoResponseDtoFromListDadosProduto(produtosList);

        log.info("List Produto response: {} por categoria: {}", produtoResponseList, categoria);
        return produtoResponseList;
    }
}
