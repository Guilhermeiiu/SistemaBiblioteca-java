package gui;

import modelo.Biblioteca;
import modelo.Cliente;
import modelo.Livro;
import modelo.LivroFisico;
import modelo.Ebook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaFuncionarioGUI extends JPanel {
    private Biblioteca biblioteca;
    private JTextArea areaInfo;

    public TelaFuncionarioGUI(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setLayout(new BorderLayout());

        JPanel botoesPanel = new JPanel();
        JButton btnAddFisico = new JButton("Adicionar Livro Físico");
        JButton btnAddEbook = new JButton("Adicionar Ebook");
        JButton btnListarClientes = new JButton("Listar Clientes");
        JButton btnListarLivros = new JButton("Listar Livros");

        botoesPanel.add(btnAddFisico);
        botoesPanel.add(btnAddEbook);
        botoesPanel.add(btnListarClientes);
        botoesPanel.add(btnListarLivros);

        add(botoesPanel, BorderLayout.NORTH);

        areaInfo = new JTextArea(18, 50);
        areaInfo.setEditable(false);
        add(new JScrollPane(areaInfo), BorderLayout.CENTER);

        btnAddFisico.addActionListener((ActionEvent e) -> {
            JTextField titulo = new JTextField();
            JTextField autor = new JTextField();
            JTextField preco = new JTextField();
            JTextField estoque = new JTextField();
            Object[] campos = {
                "Título:", titulo,
                "Autor:", autor,
                "Preço:", preco,
                "Estoque:", estoque
            };
            int res = JOptionPane.showConfirmDialog(this, campos, "Adicionar Livro Físico", JOptionPane.OK_CANCEL_OPTION);
            if (res == JOptionPane.OK_OPTION) {
                try {
                    LivroFisico livro = new LivroFisico(
                        titulo.getText(),
                        autor.getText(),
                        Float.parseFloat(preco.getText()),
                        Integer.parseInt(estoque.getText())
                    );
                    biblioteca.adicionarLivro(livro);
                    JOptionPane.showMessageDialog(this, "Livro físico adicionado!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Dados inválidos.");
                }
            }
        });

        btnAddEbook.addActionListener((ActionEvent e) -> {
            JTextField titulo = new JTextField();
            JTextField autor = new JTextField();
            JTextField preco = new JTextField();
            JTextField formato = new JTextField();
            Object[] campos = {
                "Título:", titulo,
                "Autor:", autor,
                "Preço:", preco,
                "Formato (ex: PDF, EPUB):", formato
            };
            int res = JOptionPane.showConfirmDialog(this, campos, "Adicionar Ebook", JOptionPane.OK_CANCEL_OPTION);
            if (res == JOptionPane.OK_OPTION) {
                try {
                    Ebook ebook = new Ebook(
                        titulo.getText(),
                        autor.getText(),
                        Float.parseFloat(preco.getText()),
                        formato.getText()
                    );
                    biblioteca.adicionarLivro(ebook);
                    JOptionPane.showMessageDialog(this, "Ebook adicionado!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Dados inválidos.");
                }
            }
        });

        btnListarClientes.addActionListener((ActionEvent e) -> {
            StringBuilder sb = new StringBuilder();
            for (Cliente c : biblioteca.getListaClientes()) {
                sb.append(c.getNome()).append(" - ").append(c.getEmail()).append("\n");
            }
            areaInfo.setText(sb.toString());
        });

        btnListarLivros.addActionListener((ActionEvent e) -> {
            StringBuilder sb = new StringBuilder();
            for (Livro livro : biblioteca.getListaLivros()) {
                sb.append("Título: ").append(livro.getTitulo()).append("\n");
                sb.append("Autor: ").append(livro.getAutor()).append("\n");
                sb.append("Tipo: ");
                if (livro instanceof LivroFisico) {
                    LivroFisico lf = (LivroFisico) livro;
                    sb.append("Físico\n");
                    sb.append("Estoque: ").append(lf.getEstoque()).append("\n");
                } else if (livro instanceof Ebook) {
                    sb.append("Ebook\n");
                    sb.append("Estoque: Ilimitado\n");
                } else {
                    sb.append("Outro\n");
                }
                sb.append("Preço: R$").append(String.format("%.2f", livro.getPreco())).append("\n");
                sb.append("------\n");
            }
            areaInfo.setText(sb.toString());
        });
    }
}