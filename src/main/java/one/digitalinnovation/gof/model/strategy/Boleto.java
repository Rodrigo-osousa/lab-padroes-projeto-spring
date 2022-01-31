package one.digitalinnovation.gof.model.strategy;

import one.digitalinnovation.gof.model.DadosPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Boleto implements Pagamento {

    @Override
    public DadosPagamento pagar(BigDecimal valor) throws InterruptedException {
        System.out.println("Realizando Pagamento de boleto");
        Thread.sleep(2000);
        System.out.println("Pagamento realizado com sucesso");

        DadosPagamento dadosPagamento = new DadosPagamento();
        dadosPagamento.setTipoPagamento("BOLETO");
        dadosPagamento.setData(LocalDateTime.now());

        return dadosPagamento;
    }
}
