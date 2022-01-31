package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class DadosPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipoPagamento;
    private LocalDateTime data;

    public DadosPagamento() {
    }

    public DadosPagamento(Long id, String tipoPagamento, LocalDateTime data) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.data = data;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DadosPagamento{" +
                "id=" + id +
                ", tipoPagamento='" + tipoPagamento + '\'' +
                ", data=" + data +
                '}';
    }
}
