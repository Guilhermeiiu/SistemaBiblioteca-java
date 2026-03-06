package modelo;
import java.io.Serializable;

public abstract class Livro implements Serializable {
    protected String titulo;
    protected String autor;
    protected float preco;

    public Livro(String titulo, String autor, float preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public float getPreco() {
        return preco;
    }

    public abstract void detalhes();
}