package modelo;
public class Funcionario extends Usuario {
    private String cargo;
    private String senha;

    public Funcionario(String nome, String email, String cargo, String senha) {
        super(nome, email);
        this.cargo = cargo;
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}