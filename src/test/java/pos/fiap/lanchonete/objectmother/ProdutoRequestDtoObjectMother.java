package pos.fiap.lanchonete.objectmother;

import pos.fiap.lanchonete.adapter.in.api.dto.ProdutoRequestDto;

import static pos.fiap.lanchonete.adapter.in.api.enums.CategoriaEnum.ACOMPANHAMENTO;

public class ProdutoRequestDtoObjectMother {

    public static ProdutoRequestDto getProdutoRequestDtoMock() {
        return ProdutoRequestDto.builder()
                .id("123")
                .nome("Produto Teste")
                .categoria(ACOMPANHAMENTO)
                .preco(Double.valueOf("100.00"))
                .descricao("Produto de teste")
                .build();
    }
}
