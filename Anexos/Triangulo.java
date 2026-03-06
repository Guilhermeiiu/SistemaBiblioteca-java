/* Escreva uma classe Triangulo que encapsule três valores de ponto flutuante correspondentes 
aos lados do triângulo. Os valores devem ser passados para o construtor da classe. Nesta 
classe, escreva os métodos calculaPerímetro() e calculaÁrea() que calculam o perímetro e 
área do triângulo. Escreva também o método tipo() que retorna 1 se o triângulo for escaleno, 
2 se o triângulo for isósceles e 3 se for equilátero. */
public class Triangulo {
    private double lado1, lado2, lado3;

    // Construtor
    public Triangulo(double l1, double l2, double l3) {
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
    }

    // Calcula o perímetro
    public double calculaPerimetro() {
        return lado1 + lado2 + lado3;
    }

    // Calcula a área (Fórmula de Heron)
    public double calculaArea() {
        double p = calculaPerimetro() / 2; // Semi-perímetro
        return Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3));
    }

    // Retorna o tipo do triângulo (1 = Escaleno, 2 = Isósceles, 3 = Equilátero)
    public int tipo() {
        if (lado1 == lado2 && lado2 == lado3) return 3; // Equilátero
        if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) return 2; // Isósceles
        return 1; // Escaleno
    }

    // Testando a classe
    public static void main(String[] args) {
        Triangulo t = new Triangulo(3, 4, 5);
        System.out.println("Perímetro: " + t.calculaPerimetro());
        System.out.println("Área: " + t.calculaArea());
        System.out.println("Tipo: " + t.tipo());
    }
}
