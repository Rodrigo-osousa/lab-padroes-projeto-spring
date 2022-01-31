package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduto;
    private Long cliente;
    private String cepEntrega;
    private String numeroDaCasa;
    private String pagamento;

    public Compra() {
    }

    public Compra(Long cliente, String cepEntrega, String numeroDaCasa, Long idProduto, String pagamento) {
        this.cliente = cliente;
        this.cepEntrega = cepEntrega;
        this.numeroDaCasa = numeroDaCasa;
        this.idProduto = idProduto;
        this.pagamento = pagamento;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public String getCepEntrega() {
        return cepEntrega;
    }

    public void setCepEntrega(String cepEntrega) {
        this.cepEntrega = cepEntrega;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "cliente='" + cliente + '\'' +
                ", cepEntrega='" + cepEntrega + '\'' +
                ", numeroDaCasa='" + numeroDaCasa + '\'' +
                ", idProduto='" + idProduto + '\'' +
                ", pagamento=" + pagamento +
                '}';
    }
}
