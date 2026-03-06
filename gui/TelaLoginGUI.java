package gui;

import javax.swing.*;
import modelo.Biblioteca;
import modelo.Cliente;
import java.awt.*;
import java.awt.event.*;

public class TelaLoginGUI extends JPanel {
    private MainFrame mainFrame;
    private Biblioteca biblioteca;

    public TelaLoginGUI(MainFrame mainFrame, Biblioteca biblioteca) {
        this.mainFrame = mainFrame;
        this.biblioteca = biblioteca;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblUsuario = new JLabel("Usuário:");
        JTextField txtUsuario = new JTextField(20);
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(20);
        JButton btnEntrar = new JButton("Entrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLoginFuncionario = new JButton("Login Funcionário");
        JLabel lblMensagem = new JLabel("");
        lblMensagem.setForeground(Color.RED);

        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0; gbc.gridy = 0; add(lblUsuario, gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(txtUsuario, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(lblSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(txtSenha, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(btnEntrar, gbc);
        gbc.gridx = 1; gbc.gridy = 2; add(btnLimpar, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; add(lblMensagem, gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; add(btnCadastrar, gbc);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; add(btnLoginFuncionario, gbc);

        // Foco automático
        SwingUtilities.invokeLater(txtUsuario::requestFocusInWindow);

        // Entrar ao pressionar Enter
        txtSenha.addActionListener(e -> btnEntrar.doClick());
        txtUsuario.addActionListener(e -> btnEntrar.doClick());

        btnEntrar.addActionListener(e -> {
            String usuario = txtUsuario.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();
            if (usuario.isEmpty() || senha.isEmpty()) {
                lblMensagem.setText("Preencha usuário e senha.");
                return;
            }
            Cliente cliente = biblioteca.autenticarCliente(usuario, senha);
            if (cliente != null) {
                mainFrame.clienteAutenticado = cliente;
                mainFrame.getClientePanel().atualizarCliente(cliente); // <-- Atualiza o painel com o novo cliente
                lblMensagem.setText("");
                JOptionPane.showMessageDialog(this, "Bem-vindo, " + cliente.getNome() + "!");
                mainFrame.showPanel("Cliente");
            } else {
                lblMensagem.setText("Usuário ou senha inválidos.");
            }
        });

        btnLimpar.addActionListener(e -> {
            txtUsuario.setText("");
            txtSenha.setText("");
            lblMensagem.setText("");
            txtUsuario.requestFocusInWindow();
        });

        btnCadastrar.addActionListener(e -> mostrarCadastroCliente());
        btnLoginFuncionario.addActionListener(e -> {
            mainFrame.showPanel("LoginFuncionario");
        });
    }

    private void mostrarCadastroCliente() {
        JTextField nomeField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        Object[] campos = {
            "Nome:", nomeField,
            "Email:", emailField,
            "Senha:", senhaField
        };
        int res = JOptionPane.showConfirmDialog(this, campos, "Cadastro de Novo Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText().trim();
            String email = emailField.getText().trim();
            String senha = new String(senhaField.getPassword()).trim();
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                return;
            }
            if (biblioteca.autenticarCliente(email, senha) != null) {
                JOptionPane.showMessageDialog(this, "Já existe um cliente com este email.");
                return;
            }
            Cliente novo = new Cliente(nome, email, senha);
            biblioteca.adicionarCliente(novo);
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso! Faça login para continuar.");
        }
    }
}
