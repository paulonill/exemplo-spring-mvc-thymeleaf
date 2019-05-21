package br.com.pjr.exemplospringbootthymeleaf.entidade;

import br.com.pjr.exemplospringbootthymeleaf.entidade.type.StatusProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome não pode ser vazio!")
	@Column(nullable = false, unique = true)
	private String nome;

	@Column(nullable = false, precision = 10, scale = 2)
	@NumberFormat(pattern = "#,##0.00")
	@NotNull(message = "O campo valor não pode ser vazio!")
	private BigDecimal valor;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "O campo data não pode ser vazio!")
	private LocalDate dataCadastro;

	@Enumerated(EnumType.STRING)
	private StatusProduto statusProduto;
}
