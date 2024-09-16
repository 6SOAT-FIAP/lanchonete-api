package pos.fiap.lanchonete.adapter.out.mongo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pos.fiap.lanchonete.adapter.out.mongo.entities.mapper.ClienteEntityMapper;
import pos.fiap.lanchonete.adapter.out.mongo.repository.ClienteRepository;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProdutoMongoAdapterTest {
    @Mock
    private ClienteRepository clienteRepository;
    @Spy
    private ClienteEntityMapper clienteEntityMapper = Mappers.getMapper(ClienteEntityMapper.class);
    @InjectMocks
    private ProdutoDbAdapter mongoAdapter;


}
