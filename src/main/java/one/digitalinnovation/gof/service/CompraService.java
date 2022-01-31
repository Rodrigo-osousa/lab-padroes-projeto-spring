package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Compra;
import one.digitalinnovation.gof.model.DadosCompra;

public interface CompraService {
    DadosCompra comprarProduto(Compra compra) throws Exception;

    Iterable<DadosCompra> buscarTodos();
}
