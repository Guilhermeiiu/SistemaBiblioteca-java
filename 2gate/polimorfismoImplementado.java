// Uso de polimorfismo por substituição no sistema de biblioteca:
abstract class Livro {
    protected String titulo;
    protected String autor;
    protected float preco;

    public Livro(String titulo, String autor, float preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    // Método polimórfico
    public abstract void detalhes(); 
}

class Ebook extends Livro {
    private String formato;

    public Ebook(String titulo, String autor, float preco, String formato) {
        super(titulo, autor, preco);
        this.formato = formato;
    }

    @Override
    public void detalhes() {
        System.out.println("Ebook: " + titulo + " | Autor: " + autor + " | Formato: " + formato + " | Preço: R$" + preco);
    }
}

class LivroFisico extends Livro {
    private int estoque;

    public LivroFisico(String titulo, String autor, float preco, int estoque) {
        super(titulo, autor, preco);
        this.estoque = estoque;
    }

    @Override
    public void detalhes() {
        System.out.println("Livro Físico: " + titulo + " | Autor: " + autor + " | Estoque: " + estoque + " unidades | Preço: R$" + preco);
    }
}

public class polimorfismoImplementado {
    public static void main(String[] args) {
      
        Livro ebook = new Ebook("Java para Iniciantes", "João Silva", 29.90f, "PDF");
        Livro livroFisico = new LivroFisico("A Arte da Programação", "Donald Knuth", 149.90f, 20);

        // Usando polimorfismo para chamar o método detalhes()
        ebook.detalhes(); 
        livroFisico.detalhes(); 
    }
}
