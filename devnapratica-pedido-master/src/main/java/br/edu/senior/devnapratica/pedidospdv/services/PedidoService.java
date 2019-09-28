package br.edu.senior.devnapratica.pedidospdv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senior.devnapratica.pedidospdv.dao.PedidoDAO;
import br.edu.senior.devnapratica.pedidospdv.domain.Pedido;

@Service
public class PedidoService {

	@Autowired
	private PedidoDAO pedidoDAO;

	public List<Pedido> buscarTodos() {
		return pedidoDAO.buscarTodos();
	}

	public Optional<Pedido> buscar(Long pedidoId) {
		return pedidoDAO.buscar(pedidoId);
	}

	public Pedido salvar(Pedido pedido) {

		if (pedido.getProdutos() == null) {
			throw new IllegalArgumentException("Selecione um produto");
		} else if (pedido.getQuantidade() <= 0) {
			throw new IllegalArgumentException("Adicione um valor");
		} else {
			return pedidoDAO.salvar(pedido);
		}

	}

	public Pedido alterar(Pedido pedido) {
		return pedidoDAO.alterar(pedido);
	}

	public void excluir(Long pedidoId) {
		pedidoDAO.excluir(pedidoId);
	}
}
