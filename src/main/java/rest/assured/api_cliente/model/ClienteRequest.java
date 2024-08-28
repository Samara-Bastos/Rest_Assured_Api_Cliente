package rest.assured.api_cliente.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ClienteRequest {
    
    private String nome;
    private LocalDate nascimento;
    private String email;
    private String telefone;
    private String escolaridade;
    private String estCivil;
    private Boolean filhos;
    private String descricao;

}
