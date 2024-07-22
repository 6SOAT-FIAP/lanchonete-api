package pos.fiap.lanchonete.adapter.in.api.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StatusPagamentoEnum {

    AGUARDANDO("aguardando"),
    APROVADO("aprovado"),
    RECUSADO("recusado");

    private final String label;
}