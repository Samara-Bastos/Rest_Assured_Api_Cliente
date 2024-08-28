package rest.assured.api_cliente.fixture;

import rest.assured.api_cliente.model.ClienteRequest;
import java.time.LocalDate;

public class ClienteRequestFixture {

    public static ClienteRequest createClienteValido() {
        return ClienteRequest.builder()
                .nome("Maria Silva")
                .nascimento(LocalDate.of(1990, 5, 20))
                .email("maria.silva@gmail.com")
                .telefone("11999999999")
                .escolaridade("Superior Completo")
                .estCivil("solteiro")
                .filhos(false)
                .descricao("Cliente exemplar")
                .build();
    }

    public static ClienteRequest createClienteInvalido() {
        return ClienteRequest.builder()
                .nome("")  
                .nascimento(LocalDate.of(2010, 5, 20))
                .build();
    }
}
