package modelo;
import modelo.Livro;
import java.text.NumberFormat;

public class LivroFisico extends Livro {
    private int estoque;

    public LivroFisico(String titulo, String autor, float preco, int estoque) {
        super(titulo, autor, preco);
        this.estoque = estoque;
    }

    @Override
    public void detalhes() {
        System.out.println("Livro Físico: " + titulo + " | Estoque: " + estoque + " | Preço: " + NumberFormat.getCurrencyInstance().format(preco));
    }

    public boolean diminuirEstoque() {
        if (estoque > 0) {
            estoque--;
            return true;
        }
        return false;
    }

    public int getEstoque() {
        return estoque;
    }
}