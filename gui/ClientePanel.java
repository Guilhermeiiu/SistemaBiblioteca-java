package gui;
import javax.swing.*;
import modelo.Biblioteca;
import modelo.Livro;
import modelo.LivroFisico;
import modelo.Ebook;
import modelo.Cliente;
import pagamento.Pedido;
import pagamento.Boleto;
import pagamento.CartaoCredito;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.UUID;

public class ClientePanel extends JPanel {
    private Biblioteca biblioteca;
    private JList<String> listaLivros;
    private DefaultListModel<String> modelLivros;
    private JButton btnAdicionarPedido;
    private JButton btnVisualizarLivros;
    private JButton btnFinalizarPedido;
    private JTextArea areaCarrinho;
    private Pedido pedido;
    private MainFrame mainFrame;
    private Cliente clienteAutenticado;

    public ClientePanel(Biblioteca biblioteca) {
        this(biblioteca, null);
    }

    public ClientePanel(Biblioteca biblioteca, MainFrame mainFrame) {
        this.biblioteca = biblioteca;
        this.mainFrame = mainFrame;
        this.clienteAutenticado = mainFrame != null ? mainFrame.clienteAutenticado : null;
        setLayout(new BorderLayout());

        modelLivros = new DefaultListModel<>();
        listaLivros = new JList<>(modelLivros);
        JScrollPane scrollPane = new JScrollPane(listaLivros);
        add(scrollPane, BorderLayout.CENTER);

        areaCarrinho = new JTextArea(6, 40);
        areaCarrinho.setEditable(false);
        add(new JScrollPane(areaCarrinho), BorderLayout.EAST);

        JPanel panelButtons = new JPanel();
        btnVisualizarLivros = new JButton("Visualizar Livros");
        btnAdicionarPedido = new JButton("Adicionar ao Pedido");
        btnFinalizarPedido = new JButton("Finalizar Compra");

        panelButtons.add(btnVisualizarLivros);
        panelButtons.add(btnAdicionarPedido);
        panelButtons.add(btnFinalizarPedido);
        add(panelButtons, BorderLayout.SOUTH);

        pedido = new Pedido(clienteAutenticado != null ? clienteAutenticado : new Cliente("Cliente", "cliente@exemplo.com", "senha"));

        btnVisualizarLivros.addActionListener((ActionEvent e) -> exibirLivros());

        btnAdicionarPedido.addActionListener((ActionEvent e) -> adicionarAoPedido());

        btnFinalizarPedido.addActionListener((ActionEvent e) -> finalizarPedido());
    }

    private void exibirLivros() {
        modelLivros.clear();
        List<Livro> livros = biblioteca.getListaLivros();
        for (Livro livro : livros) {
            String tipo = (livro instanceof LivroFisico) ? "Físico" : (livro instanceof Ebook ? "Ebook" : "Outro");
            modelLivros.addElement(
                livro.getTitulo() + " | Autor: " + livro.getAutor() +
                " | Tipo: " + tipo +
                " | Preço: R$" + String.format("%.2f", livro.getPreco())
            );
        }
    }

    private void adicionarAoPedido() {
        int idx = listaLivros.getSelectedIndex();
        if (idx >= 0 && idx < biblioteca.getListaLivros().size()) {
            Livro livro = biblioteca.getListaLivros().get(idx);
            if (livro instanceof LivroFisico) {
                LivroFisico lf = (LivroFisico) livro;
                if (!lf.diminuirEstoque()) {
                    JOptionPane.showMessageDialog(this, "Livro fora de estoque.");
                    return;
                }
            }
            pedido.adicionarLivro(livro);
            atualizarCarrinho();
            JOptionPane.showMessageDialog(this, "Livro adicionado ao pedido: " + livro.getTitulo());
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um livro.");
        }
    }

    private void atualizarCarrinho() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrinho:\n");
        for (Livro l : pedido.getListaLivros()) {
            sb.append("- ").append(l.getTitulo()).append(" (R$").append(String.format("%.2f", l.getPreco())).append(")\n");
        }
        sb.append("Total: R$").append(String.format("%.2f", pedido.calcularTotal()));
        areaCarrinho.setText(sb.toString());
    }

    private void finalizarPedido() {
        float total = pedido.calcularTotal();
        if (total == 0) {
            JOptionPane.showMessageDialog(this, "Carrinho vazio.");
            return;
        }
        String[] opcoes = {"Boleto", "Cartão de Crédito"};
        int escolha = JOptionPane.showOptionDialog(this, "Total do pedido: R$" + String.format("%.2f", total) + "\nEscolha a forma de pagamento:",
                "Finalizar Compra", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha == 0) {
            String cod = UUID.randomUUID().toString().substring(0, 13);
            new Boleto(total, cod);
            JOptionPane.showMessageDialog(this, "Boleto gerado! Código: " + cod + " | Valor: R$" + String.format("%.2f", total));
        } else if (escolha == 1) {
            String cartao = JOptionPane.showInputDialog(this, "Digite o número do cartão:");
            if (cartao != null && !cartao.isEmpty()) {
                new CartaoCredito(total, cartao);
                JOptionPane.showMessageDialog(this, "Pagamento aprovado no cartão: " + cartao + " | Valor: R$" + String.format("%.2f", total));
            }
        }
        // Limpa carrinho para o cliente autenticado
        pedido = new Pedido(clienteAutenticado != null ? clienteAutenticado : new Cliente("Cliente", "cliente@exemplo.com", "senha"));
        atualizarCarrinho();
    }

    public void atualizarCliente(Cliente novoCliente) {
        this.clienteAutenticado = novoCliente;
        this.pedido = new Pedido(novoCliente);
        atualizarCarrinho();
    }
}