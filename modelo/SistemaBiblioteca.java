package modelo;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;

import pagamento.Boleto;
import pagamento.CartaoCredito;
import pagamento.Pedido;
public class SistemaBiblioteca {

    @SuppressWarnings("unchecked")
    public static List<Cliente> carregarClientes(String nomeArquivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            clientes = (List<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return clientes;
    }

    public static void salvarClientes(List<Cliente> clientes, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os clientes: " + e.getMessage());
        }
    }

    public static void exibirClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\nLista de clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("- " + cliente.getNome() + " (" + cliente.getEmail() + ")");
            }
        }
    }

    public static float lerFloatValido(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
            }
        }
    }

    public static List<Cliente> lerClientes(String nomeArquivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            clientes = (List<Cliente>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Arquivo ainda não existe, retorna lista vazia
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler os clientes: " + e.getMessage());
        }
        return clientes;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        List<Cliente> clientesCarregados = carregarClientes("clientes.dat");
        for (Cliente c : clientesCarregados) {
            biblioteca.adicionarCliente(c);
        }

        Funcionario funcionario = new Funcionario("Guilherme", "guilherme@biblioteca.com", "Assistente Bibliotecário", "admin123");
        biblioteca.carregarLivros("livros.dat");

        OUTER:
        while (true) {
            System.out.println("\nVocê é: 1. Funcionário  2. Cliente   3. Sair");
            int escolha = teclado.nextInt();
            teclado.nextLine();
            switch (escolha) {
                case 1:
                    {
                        System.out.print("Digite seu email: ");
                        String email = teclado.nextLine();
                        if (email.equals(funcionario.getEmail())) {
                            System.out.println("Bem-vindo, " + funcionario.getCargo() + " " + funcionario.getNome() + "!");
                            OUTER_1:
                            while (true) {
                                System.out.println("\n1. Adicionar Livro Físico\n2. Adicionar Ebook\n3. Exibir Livros\n4. Remover Livro\n5. Listar Clientes\n6. Voltar");
                                int opcao = teclado.nextInt();
                                teclado.nextLine();
                                switch (opcao) {
                                    case 1:
                                        {
                                            System.out.print("Título: ");
                                            String titulo = teclado.nextLine();
                                            System.out.print("Autor: ");
                                            String autor = teclado.nextLine();
                                            System.out.print("Preço: ");
                                            float preco = lerFloatValido(teclado);
                                            System.out.print("Estoque: ");
                                            int estoque = teclado.nextInt();
                                            teclado.nextLine();
                                            biblioteca.adicionarLivro(new LivroFisico(titulo, autor, preco, estoque));
                                            System.out.println("Livro Físico adicionado!");
                                            break;
                                        }
                                    case 2:
                                        {
                                            System.out.print("Título: ");
                                            String titulo = teclado.nextLine();
                                            System.out.print("Autor: ");
                                            String autor = teclado.nextLine();
                                            System.out.print("Preço: ");
                                            float preco = lerFloatValido(teclado);
                                            teclado.nextLine();
                                            System.out.print("Formato: ");
                                            String formato =teclado.nextLine();
                                            biblioteca.adicionarLivro(new Ebook(titulo, autor, preco, formato));
                                            System.out.println("Ebook adicionado!");
                                            break;
                                        }
                                    case 3:
                                        biblioteca.exibirLivros();
                                        break;
                                    case 4:
                                        {
                                            System.out.print("Digite o título do livro a remover: ");
                                            String titulo = teclado.nextLine();
                                            Livro livro = biblioteca.buscarLivro(titulo);
                                            if (livro != null && biblioteca.removerLivro(livro)) {
                                                System.out.println("Livro removido.");
                                            } else {
                                                System.out.println("Livro não encontrado.");
                                            }       break;
                                        }
                                    case 5:
                                        exibirClientes(biblioteca.getListaClientes());
                                        break;
                                    case 6:
                                        break OUTER_1;
                                    default:
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Acesso negado. Você não é um funcionário autorizado.");
                        }       break;
                    }
                case 2:
                    {
                        System.out.print("Nome: ");
                        String nome = teclado.nextLine();
                        System.out.print("Email: ");
                        String email = teclado.nextLine();
                        System.out.print("Senha: ");
                        String senha = teclado.nextLine();

                        if (email.equals(funcionario.getEmail()) && senha.equals(funcionario.getSenha())) {
                            // Login autorizado
                            System.out.println("Bem-vindo, " + funcionario.getCargo() + " " + funcionario.getNome() + "!");
                            OUTER_1:
                            while (true) {
                                System.out.println("\n1. Adicionar Livro Físico\n2. Adicionar Ebook\n3. Exibir Livros\n4. Remover Livro\n5. Listar Clientes\n6. Voltar");
                                int opcao = teclado.nextInt();
                                teclado.nextLine();
                                switch (opcao) {
                                    case 1:
                                        {
                                            System.out.print("Título: ");
                                            String titulo = teclado.nextLine();
                                            System.out.print("Autor: ");
                                            String autor = teclado.nextLine();
                                            System.out.print("Preço: ");
                                            float preco = lerFloatValido(teclado);
                                            System.out.print("Estoque: ");
                                            int estoque = teclado.nextInt();
                                            teclado.nextLine();
                                            biblioteca.adicionarLivro(new LivroFisico(titulo, autor, preco, estoque));
                                            System.out.println("Livro Físico adicionado!");
                                            break;
                                        }
                                    case 2:
                                        {
                                            System.out.print("Título: ");
                                            String titulo = teclado.nextLine();
                                            System.out.print("Autor: ");
                                            String autor = teclado.nextLine();
                                            System.out.print("Preço: ");
                                            float preco = lerFloatValido(teclado);
                                            teclado.nextLine();
                                            System.out.print("Formato: ");
                                            String formato =teclado.nextLine();
                                            biblioteca.adicionarLivro(new Ebook(titulo, autor, preco, formato));
                                            System.out.println("Ebook adicionado!");
                                            break;
                                        }
                                    case 3:
                                        biblioteca.exibirLivros();
                                        break;
                                    case 4:
                                        {
                                            System.out.print("Digite o título do livro a remover: ");
                                            String titulo = teclado.nextLine();
                                            Livro livro = biblioteca.buscarLivro(titulo);
                                            if (livro != null && biblioteca.removerLivro(livro)) {
                                                System.out.println("Livro removido.");
                                            } else {
                                                System.out.println("Livro não encontrado.");
                                            }       break;
                                        }
                                    case 5:
                                        exibirClientes(biblioteca.getListaClientes());
                                        break;
                                    case 6:
                                        break OUTER_1;
                                    default:
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Acesso negado. Email ou senha incorretos.");
                        }       break;
                    }
                case 3:
                    biblioteca.salvarLivros("livros.dat");
                    salvarClientes(biblioteca.getListaClientes(), "clientes.dat");
                    System.out.println("Saindo...");
                    break OUTER;
                default:
                    break;
            }
        }

        teclado.close();
    }
}