package br.edu.senior.devnapratica.pedidospdv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senior.devnapratica.pedidospdv.dao.ProdutoDAO;
import br.edu.senior.devnapratica.pedidospdv.domain.Produto;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoDAO produtoDAO;

	public List<Produto> buscarTodos() {
		return produtoDAO.buscarTodos();
	}

	public Optional<Produto> buscar(Long produtoId) {
		return produtoDAO.buscar(produtoId);
	}

	public Produto salvar(Produto produto) {

		if (produto.getValor() <= 0) {
			throw new IllegalArgumentException("Insira um valor válido.");
		} else {
			return produtoDAO.salvar(produto);
		}
	}

	public Produto alterar(Produto produto) {

		if (produto.getValor() <= 0) {
			throw new IllegalArgumentException("Insira um valor válido.");
		} else {
			return produtoDAO.salvar(produto);
		}

	}

	public void excluir(Long produtoId) {
		produtoDAO.excluir(produtoId);
	}
}
