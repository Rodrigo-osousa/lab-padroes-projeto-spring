package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.repository.ProdutoRepository;
import one.digitalinnovation.gof.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    @Override
    public Iterable<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

    @Override
    public void inserir(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public void atualizar(Long id, Produto produto) {
        Optional<Produto> produtoDb = produtoRepository.findById(id);
        if (produtoDb.isPresent()) {
            produtoRepository.save(produto);
        }

    }

    @Override
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
