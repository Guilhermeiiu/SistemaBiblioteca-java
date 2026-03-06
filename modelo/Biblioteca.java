package modelo;
import java.io.*;
import java.util.*;

public class Biblioteca {
    private List<Livro> listaLivros = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }

    public void adicionarCliente(Cliente cliente) {
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
        }
    }
    
    public Livro buscarLivro(String titulo) {
        for (Livro livro : listaLivros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public boolean removerLivro(Livro livro) {
        return listaLivros.remove(livro);
    }

    public void exibirLivros() {
        if (listaLivros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
        } else {
            System.out.println("Lista de livros disponíveis:\n");
            for (int i = 0; i < listaLivros.size(); i++) {
                System.out.print(i + ". ");
                listaLivros.get(i).detalhes();
            }
        }
    }

    public void salvarLivros(String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaLivros);
            System.out.println("Livros salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os livros: " + e.getMessage());
        }
    }

    public void carregarLivros(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaLivros = (List<Livro>) ois.readObject();
            System.out.println("Livros carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os livros: " + e.getMessage());
        }
    }

    /**
     * Autentica um cliente pelo email e senha.
     * Retorna o Cliente autenticado ou null se não encontrar.
     */
    public Cliente autenticarCliente(String usuario, String senha) {
        for (Cliente c : listaClientes) {
            if (c.getEmail().equalsIgnoreCase(usuario) && c.getSenha().equals(senha)) {
                return c;
            }
        }
        return null;
    }
}