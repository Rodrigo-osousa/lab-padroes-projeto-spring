package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.*;
import one.digitalinnovation.gof.model.strategy.Boleto;
import one.digitalinnovation.gof.model.strategy.CartaoDeCredito;
import one.digitalinnovation.gof.model.strategy.CartaoDeDebito;
import one.digitalinnovation.gof.model.strategy.Pagamento;
import one.digitalinnovation.gof.repository.*;
import one.digitalinnovation.gof.service.CompraService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ViaCepService viaCepService;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    DadosCompraRepository dadosCompraRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    DadosPagamentoRepository dadosPagamentoRepository;

    @Override
    public DadosCompra comprarProduto(Compra compra) throws Exception {
        Optional<Cliente> buscarCliente = clienteRepository.findById(compra.getCliente());
        if (buscarCliente.isEmpty()) {
            throw new Exception("Cliente não existe");
        }
        Endereco enderecoEntrega = enderecoRepository.findById(compra.getCepEntrega()).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(compra.getCepEntrega());
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        Optional<Produto> produto = produtoRepository.findById(compra.getIdProduto());

        DadosPagamento dadosPagamento = pagarCompra(compra.getPagamento(), produto.get().getValor());

        DadosCompra dadosCompra = new DadosCompra();
        dadosCompra.setCliente(buscarCliente.get());
        dadosCompra.setEnderecoEntrega(enderecoEntrega);
        dadosCompra.setDadosPagamento(dadosPagamento);

        dadosCompraRepository.save(dadosCompra);

        return dadosCompra;
    }

    @Override
    public Iterable<DadosCompra> buscarTodos() {
        return dadosCompraRepository.findAll();
    }

    private DadosPagamento pagarCompra(String formaPagamento, BigDecimal valor) throws InterruptedException {
        DadosPagamento dadosPagamento;
        if (Objects.equals(formaPagamento, "CARTAO_CREDITO")) {
            Pagamento strategy = new CartaoDeCredito();
            dadosPagamento = strategy.pagar(valor);
        } else if (Objects.equals(formaPagamento, "CARTAO_DEBITO")) {
            Pagamento strategy = new CartaoDeDebito();
            dadosPagamento = strategy.pagar(valor);
        } else {
            Pagamento strategy = new Boleto();
            dadosPagamento = strategy.pagar(valor);
        }
        dadosPagamentoRepository.save(dadosPagamento);
        return dadosPagamento;
    }
}
