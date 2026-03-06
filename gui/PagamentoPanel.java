package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pagamento.Boleto;
import pagamento.CartaoCredito;

public class PagamentoPanel extends JPanel {
    private JTextField valorField;
    private JButton btnBoleto;
    private JButton btnCartao;
    private JTextArea outputArea;

    public PagamentoPanel(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Valor a pagar:"));
        valorField = new JTextField();
        inputPanel.add(valorField);

        btnBoleto = new JButton("Pagar com Boleto");
        btnCartao = new JButton("Pagar com Cartão");
        inputPanel.add(btnBoleto);
        inputPanel.add(btnCartao);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea(8, 30);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        btnBoleto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float valor = lerValor();
                if (valor > 0) {
                    String cod = java.util.UUID.randomUUID().toString().substring(0, 13);
                    new Boleto(valor, cod);
                    outputArea.append("Boleto gerado! Código: " + cod + " | Valor: R$" + valor + "\n");
                }
            }
        });

        btnCartao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float valor = lerValor();
                if (valor > 0) {
                    String numCartao = JOptionPane.showInputDialog("Digite o número do cartão:");
                    if (numCartao != null && !numCartao.isEmpty()) {
                        new CartaoCredito(valor, numCartao);
                        outputArea.append("Pagamento aprovado no cartão: " + numCartao + " | Valor: R$" + valor + "\n");
                    }
                }
            }
        });
    }

    private float lerValor() {
        try {
            return Float.parseFloat(valorField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido.");
            return 0;
        }
    }
}
