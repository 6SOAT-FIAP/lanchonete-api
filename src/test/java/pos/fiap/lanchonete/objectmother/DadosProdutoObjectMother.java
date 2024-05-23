package pos.fiap.lanchonete.objectmother;

import pos.fiap.lanchonete.domain.model.DadosProduto;

import static pos.fiap.lanchonete.adapter.in.api.enums.CategoriaEnum.ACOMPANHAMENTO;

public class DadosProdutoObjectMother {

    public static DadosProduto getDadosProdutoMock() {
        return DadosProduto.builder()
                .id("13541")
                .nome("Pedido Teste")
                .categoria(ACOMPANHAMENTO)
                .preco(Double.valueOf("100.00"))
                .descricao("Pedido de teste")
                .build();
    }
}
