package pagamento;

import java.text.NumberFormat;

public class Boleto extends Pagamento {
    private String codBarras;

    public Boleto(float valor, String codBarras) {
        super(valor);
        this.codBarras = codBarras;
        System.out.println("Boleto gerado com código: " + codBarras + " | Valor: " + NumberFormat.getCurrencyInstance().format(valor));
    }
}