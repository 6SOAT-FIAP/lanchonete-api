package pos.fiap.lanchonete.objectmother;

import pos.fiap.lanchonete.adapter.in.api.dto.ProdutoResponseDto;

import static pos.fiap.lanchonete.adapter.in.api.enums.CategoriaEnum.ACOMPANHAMENTO;

public class ProdutoResponseDtoObjectMother {

    public static ProdutoResponseDto getProdutoResponseDtoMock() {
        return ProdutoResponseDto.builder()
                .id("165152")
                .nome("Produto Teste")
                .categoria(ACOMPANHAMENTO)
                .preco(Double.valueOf("100.00"))
                .descricao("Produto de teste")
                .build();
    }
}
