package br.com.pjr.exemplospringbootthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pjr.exemplospringbootthymeleaf.entidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
