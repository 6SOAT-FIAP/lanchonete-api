package pos.fiap.lanchonete.adapter.out.mongo.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("cliente")
public class ClienteEntity {
    @Id
    @Indexed(unique = true)
    private String cpf;
    private String nome;
    private String email;
}
