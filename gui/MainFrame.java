package gui;
import javax.swing.*;

import modelo.Biblioteca;
import modelo.Cliente;
import modelo.Funcionario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    Biblioteca biblioteca;
    public Cliente clienteAutenticado; // Adicione isso
    public Funcionario funcionarioPadrao;
    private ClientePanel clientePanel;

    public MainFrame() {
        setTitle("Sistema Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        biblioteca = new Biblioteca();
        biblioteca.carregarLivros("livros.dat");

        // Carregar clientes do arquivo e adicionar à biblioteca
        java.util.List<modelo.Cliente> clientes = modelo.SistemaBiblioteca.lerClientes("clientes.dat");
        for (modelo.Cliente c : clientes) {
            biblioteca.adicionarCliente(c);
        }

        funcionarioPadrao = new Funcionario(
            "Guilherme Correia França",
            "guilherme@biblioteca.com",
            "Assistente Bibliotecário",
            "senha"
        );

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize panels
        TelaLoginGUI loginPanel = new TelaLoginGUI(this, biblioteca);
        TelaFuncionarioGUI funcionarioPanel = new TelaFuncionarioGUI(biblioteca);
        TelaLoginFuncionarioGUI loginFuncionarioPanel = new TelaLoginFuncionarioGUI(this, funcionarioPadrao);
        clientePanel = new ClientePanel(biblioteca, this);
        LivrosPanel livrosPanel = new LivrosPanel(this); // ajuste conforme implementação
        PedidoPanel pedidoPanel = new PedidoPanel(); // ajuste conforme implementação
        PagamentoPanel pagamentoPanel = new PagamentoPanel(this); // ajuste conforme implementação

        // Add panels to mainPanel
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(loginFuncionarioPanel, "LoginFuncionario");
        mainPanel.add(funcionarioPanel, "Funcionario");
        mainPanel.add(clientePanel, "Cliente");
        mainPanel.add(livrosPanel, "Livros");
        mainPanel.add(pedidoPanel, "Pedido");
        mainPanel.add(pagamentoPanel, "Pagamento");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                biblioteca.salvarLivros("livros.dat");
                modelo.SistemaBiblioteca.salvarClientes(biblioteca.getListaClientes(), "clientes.dat");
            }
        });
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public ClientePanel getClientePanel() {
        return clientePanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}