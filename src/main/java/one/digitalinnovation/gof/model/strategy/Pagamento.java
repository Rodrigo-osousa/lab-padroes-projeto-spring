package one.digitalinnovation.gof.model.strategy;

import one.digitalinnovation.gof.model.DadosPagamento;

import java.math.BigDecimal;

public interface Pagamento {
    DadosPagamento pagar(BigDecimal valor) throws InterruptedException;
}
