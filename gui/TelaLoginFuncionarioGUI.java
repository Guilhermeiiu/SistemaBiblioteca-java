package gui;
import javax.swing.*;
import modelo.Funcionario;
import java.awt.*;

public class TelaLoginFuncionarioGUI extends JPanel {
    public TelaLoginFuncionarioGUI(MainFrame mainFrame, Funcionario funcionario) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);
        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(20);
        JButton btnEntrar = new JButton("Entrar");
        JButton btnLimpar = new JButton("Limpar");
        JLabel lblMensagem = new JLabel("");
        lblMensagem.setForeground(Color.RED);

        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0; gbc.gridy = 0; add(lblEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(txtEmail, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(lblSenha, gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(txtSenha, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(btnEntrar, gbc);
        gbc.gridx = 1; gbc.gridy = 2; add(btnLimpar, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; add(lblMensagem, gbc);

        // Foco automático
        SwingUtilities.invokeLater(txtEmail::requestFocusInWindow);

        // Entrar ao pressionar Enter
        txtSenha.addActionListener(e -> btnEntrar.doClick());
        txtEmail.addActionListener(e -> btnEntrar.doClick());

        btnEntrar.addActionListener(e -> {
            String email = txtEmail.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();
            if (email.isEmpty() || senha.isEmpty()) {
                lblMensagem.setText("Preencha email e senha.");
                return;
            }
            if (email.equals(funcionario.getEmail()) && senha.equals(funcionario.getSenha())) {
                lblMensagem.setText("");
                JOptionPane.showMessageDialog(this, "Bem-vindo, " + funcionario.getNome() + "!");
                mainFrame.showPanel("Funcionario");
            } else {
                lblMensagem.setText("Email ou senha inválidos.");
            }
        });

        btnLimpar.addActionListener(e -> {
            txtEmail.setText("");
            txtSenha.setText("");
            lblMensagem.setText("");
            txtEmail.requestFocusInWindow();
        });
    }
}