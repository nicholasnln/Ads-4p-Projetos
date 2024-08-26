package entity;

import lombok.Data;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome do produto não pode ser nulo")
    @Size(min = 1, max = 100, message = "Nome do produto deve ter entre 1 e 100 caracteres")
    private String nome;

    @NotNull(message = "Valor do produto não pode ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser positivo")
    private Double valor;

    // Comentado pois não é utilizado no momento
    //@NotNull
    //private int quantidadeEstoque;

    // Métodos getter e setter para o campo id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
