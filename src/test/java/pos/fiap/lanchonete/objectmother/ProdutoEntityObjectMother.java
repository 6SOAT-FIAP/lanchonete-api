package pos.fiap.lanchonete.objectmother;

import lombok.SneakyThrows;
import pos.fiap.lanchonete.adapter.in.api.enums.CategoriaEnum;
import pos.fiap.lanchonete.adapter.out.mongo.entities.ProdutoEntity;

public class ProdutoEntityObjectMother {

    @SneakyThrows
    public static ProdutoEntity getProdutoEntityMock() {
        return ProdutoEntity.builder()
                .id("1234")
                .nome("Produto Teste")
                .categoria(CategoriaEnum.LANCHE)
                .preco(Double.valueOf("1.00"))
                .descricao("Produto utilizado para teste")
                .build();
    }
}
