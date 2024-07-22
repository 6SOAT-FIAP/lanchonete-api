package pos.fiap.lanchonete.objectmother.dtos.in.webhook;

import pos.fiap.lanchonete.adapter.in.api.webhook.dto.WebHookRequestDto;

public class WebHookRequestDtoObjectMother {

    public static WebHookRequestDto getWebHookRequestDtoMock() {
        return WebHookRequestDto.builder()
                .action("teste")
                .apiVersion("1")
                .data(buildWebhookDadosPedidoRequestDtoMock())
                .id(1234L)
                .dateCreated("2024-07-20")
                .type("teste")
                .userId("214")
                .build();
    }

    public static WebHookRequestDto getWebHookRequestDtoSemDadosMock() {
        return WebHookRequestDto.builder()
                .action("teste")
                .apiVersion("1")
                .id(1234L)
                .dateCreated("2024-07-20")
                .type("teste")
                .userId("214")
                .build();
    }

    private static WebHookRequestDto.WebhookDadosPedidoRequestDto buildWebhookDadosPedidoRequestDtoMock() {
        return WebHookRequestDto.WebhookDadosPedidoRequestDto.builder()
                .id("123")
                .build();
    }
}
