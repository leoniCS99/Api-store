package api.store.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ProdutoDto {

   private Integer Tamanho;
   private String Categoria;
   private String Cor;
   private BigDecimal preco;
   private String marca;
   private Date dataCadastro;
   private Integer quantidadeEstoque;
   private String descrição;
}
