package pagamento;

import java.text.NumberFormat;

public class CartaoCredito extends Pagamento {
    private String numCartao;

    public CartaoCredito(float valor, String numCartao) {
        super(valor);
        this.numCartao = numCartao;
        System.out.println("Pagamento aprovado no cartão " + numCartao + " | Valor: " + NumberFormat.getCurrencyInstance().format(valor));
    }
}