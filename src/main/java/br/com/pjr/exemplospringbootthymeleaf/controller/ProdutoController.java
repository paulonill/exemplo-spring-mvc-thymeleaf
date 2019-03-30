package br.com.pjr.exemplospringbootthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.pjr.exemplospringbootthymeleaf.entidade.Produto;
import br.com.pjr.exemplospringbootthymeleaf.entidade.type.StatusProduto;
import br.com.pjr.exemplospringbootthymeleaf.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	private final String PAGINA_CADASTRO = "produto";
	private final String PAGINA_LISTA = "listaProduto";

	@Autowired
	private ProdutoRepository repository;

	@GetMapping(value = "/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(PAGINA_CADASTRO);
		mv.addObject(new Produto());
		return mv;
	}

	@PostMapping
	public ModelAndView salvar(@Validated Produto produto, Errors errors, RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {
			return new ModelAndView(PAGINA_CADASTRO);
		}

		this.repository.save(produto);

		redirectAttributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");

		return new ModelAndView("redirect:/produtos/novo");
	}

	@ModelAttribute("todosStatusProduto")
	public StatusProduto[] todosStatusProduto() {
		return StatusProduto.values();
	}

	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView(PAGINA_LISTA);
		List<Produto> produtos = repository.findAll();

		mv.addObject("produtos", produtos);
		return mv;
	}

	@GetMapping(value = "/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Produto produto = this.repository.findById(id).orElseThrow(()-> new EmptyResultDataAccessException(1));
		ModelAndView mv = new ModelAndView(PAGINA_CADASTRO);
		mv.addObject(produto);
		return mv;
	}
	
	@GetMapping(value = "/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
		return new ModelAndView("redirect:/produtos");
	}
}
