package pos.fiap.lanchonete.adapter.in.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteRequestDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3401826491154036524L;
    private String cpf;
    private String nome;
    private String email;
}
