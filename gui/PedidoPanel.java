package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import modelo.Cliente;
import modelo.Livro;
import pagamento.Pedido;
public class PedidoPanel extends JPanel {
    private JComboBox<Livro> livroComboBox;
    private JButton adicionarButton;
    private JTextArea pedidoTextArea;
    private Pedido pedido;

    public PedidoPanel() {
        pedido = new Pedido(new Cliente("Cliente", "cliente@exemplo.com", "senha")); // Exemplo de cliente
        setLayout(new BorderLayout());

        // Painel para seleção de livro
        JPanel selectionPanel = new JPanel();
        livroComboBox = new JComboBox<>();
        adicionarButton = new JButton("Adicionar ao Pedido");
        selectionPanel.add(livroComboBox);
        selectionPanel.add(adicionarButton);

        // Área de texto para exibir o pedido
        pedidoTextArea = new JTextArea(10, 30);
        pedidoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(pedidoTextArea);

        // Adicionando componentes ao painel principal
        add(selectionPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Ação do botão para adicionar livro ao pedido
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Livro livroSelecionado = (Livro) livroComboBox.getSelectedItem();
                if (livroSelecionado != null) {
                    pedido.adicionarLivro(livroSelecionado);
                    atualizarPedidoTextArea();
                }
            }
        });
    }

    public void atualizarComboBox(List<Livro> livros) {
        livroComboBox.removeAllItems();
        for (Livro livro : livros) {
            livroComboBox.addItem(livro);
        }
    }

    private void atualizarPedidoTextArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("Livros no Pedido:\n");
        for (Livro livro : pedido.getListaLivros()) {
            sb.append("- ").append(livro.getTitulo()).append("\n");
        }
        sb.append("Total: ").append(pedido.calcularTotal());
        pedidoTextArea.setText(sb.toString());
    }
}