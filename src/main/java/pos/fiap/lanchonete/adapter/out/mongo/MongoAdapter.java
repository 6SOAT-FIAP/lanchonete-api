package pos.fiap.lanchonete.adapter.out.mongo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pos.fiap.lanchonete.adapter.out.mongo.entities.mapper.ClienteEntityMapper;
import pos.fiap.lanchonete.adapter.out.mongo.entities.mapper.PedidoEntityMapper;
import pos.fiap.lanchonete.adapter.out.mongo.entities.mapper.ProdutoEntityMapper;
import pos.fiap.lanchonete.adapter.out.mongo.repository.ClienteRepository;
import pos.fiap.lanchonete.adapter.out.mongo.repository.PedidoRepository;
import pos.fiap.lanchonete.adapter.out.mongo.repository.ProdutoRepository;
import pos.fiap.lanchonete.domain.model.entity.Cliente;
import pos.fiap.lanchonete.domain.model.entity.Pedido;
import pos.fiap.lanchonete.domain.model.entity.Produto;
import pos.fiap.lanchonete.port.MongoAdapterPort;

import java.util.List;
import java.util.Optional;

import static pos.fiap.lanchonete.utils.Constantes.FIM;
import static pos.fiap.lanchonete.utils.Constantes.INICIO;

@Slf4j
@Component
@RequiredArgsConstructor
public class MongoAdapter implements MongoAdapterPort {
    private static final String SERVICE_NAME = "MongoAdapter";
    private static final String STRING_LOG_FORMAT = "%s_%s_%s {}";
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;
    private final ClienteEntityMapper clienteEntityMapper;
    private final ProdutoEntityMapper produtoEntityMapper;
    private final PedidoEntityMapper pedidoEntityMapper;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        var methodName = "cadastrarCliente";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), cliente);

        var clienteEntity = clienteEntityMapper.toEntity(cliente);
        clienteEntity = clienteRepository.save(clienteEntity);

        var clienteSaved = clienteEntityMapper.toCliente(clienteEntity);
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), clienteEntity);
        return clienteSaved;
    }

    @Override
    public Optional<Cliente> procurarClientePorCpf(String cpf) {
        var methodName = "procurarClientePorCpf";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), cpf);

        var clienteEntity = clienteRepository.findById(cpf);

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), clienteEntity);
        return clienteEntity.map(clienteEntityMapper::toCliente);
    }

    @Override
    public Produto cadastrarProduto(Produto produto) {
        var methodName = "cadastrarProduto";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), produto);

        var produtoEntity = produtoEntityMapper.toEntity(null, produto);
        produtoEntity = produtoRepository.save(produtoEntity);

        var produtoSaved = produtoEntityMapper.toProduto(produtoEntity);
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), produtoEntity);
        return produtoSaved;
    }

    @Override
    public Produto alterarProduto(String id, Produto produto) {
        var methodName = "alterarProduto";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), produto);

        var produtoEntity = produtoEntityMapper.toEntity(id, produto);
        produtoEntity = produtoRepository.save(produtoEntity);

        var produtoSaved = produtoEntityMapper.toProduto(produtoEntity);
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), produtoEntity);
        return produtoSaved;
    }

    @Override
    public void removerProduto(String id) {
        var methodName = "removerProduto";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), id);

        var produtoEntity = produtoRepository.findById(id);
        produtoRepository.delete(produtoEntity.get());

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), id);
    }

    @Override
    public List<Produto> buscarProdutoPorCategoria(String categoria) {
        var methodName = "buscarProdutoPorCategoria";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), categoria);

        var produtoEntityList = produtoRepository.findByCategoria(categoria);

        var produtoList = produtoEntityMapper.toListProduto(produtoEntityList);

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), categoria);

        return produtoList;
    }

    @Override
    public Pedido cadastrarPedido(Pedido pedido) {
        var methodName = "cadastrarPedido";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), pedido);

        var pedidoEntity = pedidoEntityMapper.toEntity(pedido);

        var entity = pedidoRepository.save(pedidoEntity);

        var pedidoResponse = pedidoEntityMapper.toPedido(entity);

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), pedido);
        return pedidoResponse;
    }

    @Override
    public List<Pedido> buscarPedidos() {
        var methodName = "buscarPedidos";
        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, INICIO), "pedidos");

        var entity = pedidoRepository.findAll();
        var pedidoList = pedidoEntityMapper.toListPedido(entity);

        log.info(String.format(STRING_LOG_FORMAT, SERVICE_NAME, methodName, FIM), "pedidos");
        return pedidoList;
    }
}