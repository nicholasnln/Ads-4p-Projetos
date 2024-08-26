package entity;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 2, max = 100, message = "Nome deve ter de 2 a 100 caracteres")
    private String nome;

    @NotNull(message = "Idade não pode ser nula")
    @Min(value = 18, message = "Idade mínima deve ser 18")
    @Max(value = 125, message = "Idade máxima deve ser 125")
    private Integer idade;

    @NotNull(message = "CPF não pode ser nulo")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String cpf;

    @NotNull
    @Column(unique = true) // Faz com que a matricula seja uma chave única no banco de dados
    private String matricula;

    // Métodos getter e setter gerados manualmente para o campo id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
