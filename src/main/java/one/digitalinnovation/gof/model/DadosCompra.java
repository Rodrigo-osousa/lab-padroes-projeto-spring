package one.digitalinnovation.gof.model;

import javax.persistence.*;

@Entity
public class DadosCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private DadosPagamento dadosPagamento;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Endereco enderecoEntrega;

    public DadosCompra() {
    }

    public DadosCompra(Long id, DadosPagamento dadosPagamento, Cliente cliente, Endereco enderecoEntrega) {
        this.id = id;
        this.dadosPagamento = dadosPagamento;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public String toString() {
        return "DadosCompra{" +
                "id=" + id +
                ", dadosPagamento=" + dadosPagamento +
                ", cliente=" + cliente +
                ", enderecoEntrega=" + enderecoEntrega +
                '}';
    }
}
