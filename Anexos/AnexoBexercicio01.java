import java.util.Scanner;

class Pessoa {
    private String nome;
    private int idade;
    private double peso;
    private double altura;

    public Pessoa() {}

    public Pessoa(String nome) {
        setNome(nome);
    }

    public Pessoa(String nome, int idade, double peso, double altura) {
        setNome(nome);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso < 0) {
            throw new IllegalArgumentException("Peso não pode ser negativo.");
        }
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero.");
        }
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }
}

public class ListaAnexoBExercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();
            
            System.out.print("Digite o peso (kg): ");
            double peso = scanner.nextDouble();
            
            System.out.print("Digite a altura (m): ");
            double altura = scanner.nextDouble();
            
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setIdade(idade);
            pessoa.setPeso(peso);
            pessoa.setAltura(altura);
            
            System.out.println("\nInformações da Pessoa:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println("Peso: " + pessoa.getPeso());
            System.out.println("Altura: " + pessoa.getAltura());
            System.out.printf("IMC: %.2f\n", pessoa.calcularIMC());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
