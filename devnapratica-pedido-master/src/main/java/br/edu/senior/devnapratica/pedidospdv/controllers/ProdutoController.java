package br.edu.senior.devnapratica.pedidospdv.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senior.devnapratica.pedidospdv.domain.Produto;
import br.edu.senior.devnapratica.pedidospdv.services.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(method = RequestMethod.GET, path = "/v1/produtos")
	public ResponseEntity<List<Produto>> listar() {
		List<Produto> produto = produtoService.buscarTodos();

		return ResponseEntity.ok(produto);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/v1/produtos")
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {

		Produto produtoSalvo = produtoService.salvar(produto);

		return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET, path = "/v1/produtos/{produtoId}")
	public ResponseEntity<Produto> buscar(@PathVariable("produtoId") Long idDoProduto) {

		Optional<Produto> produtoOpt = produtoService.buscar(idDoProduto);

		if (produtoOpt.isPresent()) {
			return ResponseEntity.ok(produtoOpt.get());
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/v1/produtos/{produto.id}")
	public ResponseEntity<Produto> alterar(@RequestBody Produto produto) {

		Produto produtoAlterado = produtoService.alterar(produto);

		return new ResponseEntity<Produto>(produtoAlterado, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, path = "/v1/produtos/{produto.id}")
	public void remover(@PathVariable("produtoId") Long produtoId) {
		produtoService.excluir(produtoId);
	}
}
