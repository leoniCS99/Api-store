package api.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer Tamanho;
    private String Categoria;
    private String Cor;
    private BigDecimal preco;
    private String marca;
    private Date dataCadastro;
    private Integer quantidadeEstoque;
    private String descrição;
}
