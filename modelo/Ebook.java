package modelo;
import java.text.NumberFormat;

public class Ebook extends Livro {
    private String formato;

    public Ebook(String titulo, String autor, float preco, String formato) {
        super(titulo, autor, preco);
        this.formato = formato;
    }

    @Override
    public void detalhes() {
        System.out.println("Ebook: " + titulo + " | Formato: " + formato + " | Preço: " + NumberFormat.getCurrencyInstance().format(preco));
    }
}