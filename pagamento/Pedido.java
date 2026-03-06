package pagamento;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Livro;

public class Pedido {
    private List<Livro> listaLivros = new ArrayList<>();
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }

    public float calcularTotal() {
        float total = 0;
        for (Livro livro : listaLivros) {
            total += livro.getPreco();
        }
        return total;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public Cliente getCliente() {
        return cliente;
    }
}