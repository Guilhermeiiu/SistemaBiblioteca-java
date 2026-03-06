package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Biblioteca;
import modelo.Livro;

public class LivrosPanel extends JPanel {
    private Biblioteca biblioteca;
    private DefaultListModel<String> modelLivros;
    private JList<String> listaLivros;
    private JButton btnAtualizar;

    public LivrosPanel(MainFrame mainFrame) {
        // Recupera a biblioteca do MainFrame
        this.biblioteca = mainFrame != null ? mainFrame.biblioteca : new Biblioteca();

        setLayout(new BorderLayout());

        modelLivros = new DefaultListModel<>();
        listaLivros = new JList<>(modelLivros);
        JScrollPane scrollPane = new JScrollPane(listaLivros);
        add(scrollPane, BorderLayout.CENTER);

        btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarListaLivros();
            }
        });

        add(btnAtualizar, BorderLayout.SOUTH);

        atualizarListaLivros();
    }

    private void atualizarListaLivros() {
        modelLivros.clear();
        for (Livro livro : biblioteca.getListaLivros()) {
            modelLivros.addElement(livro.getTitulo() + " - " + livro.getAutor() + " (R$ " + livro.getPreco() + ")");
        }
    }
}
