package br.com.pjr.exemplospringbootthymeleaf.entidade.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusProduto {

	DISPONIVEL("Disponivel"), INSDISPONIVEL("Indisponivel"), NAO_CATALOGADO("Não catalogado");

	private String descricao;
}
