
import java.io.*;
import java.util.*;

class IOeColeçoesNoProjeto {
    private List<Livro> listaLivros = new ArrayList<>(); //Uso de Coleções 

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
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

    public void salvarLivros(String nomeArquivo) { //Operações I/O
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
    }}