//- Construa um algoritmo que receba como entrada de dados o peso e a altura de uma
//pessoa. Após ler os dados, o algoritmo deverá calcular e mostrar o seu IMC

import java.util.Scanner; 

public class questao5 {
    public static void main(String[] args)  {
        try (Scanner scanner = new Scanner (System.in)){
            while (true) {
                
           
        System.out.println("Bem vindo!!");
        System.out.println("Qual seu nome ?");
        String nome = scanner.next();
        System.out.println("Qual sua altura ? (em metros (M,cm))");
        double altura = scanner.nextDouble();
        System.out.println("Qual seu peso (em KG) ");
        double peso = scanner.nextDouble();
        double imc = peso/(altura*altura);

        System.out.println(nome + " Seu IMC é " + imc);
        
if (imc < 16 ) {
    System.out.println("Você está abaixo do peso (grau 1)");}

else if (imc >= 16 && imc <= 16.99) {
    System.out.println("Você está abaixo do peso (grau 2)");
}
else if (imc >= 17 && imc <= 18.49) {
    System.out.println("Você está abaixo do peso (grau 3)");
}
else if (imc >= 18.5 && imc <= 24.99) {
    System.out.println("Você está com peso adequado");
}
else if (imc >= 25 && imc <= 29.99) {
    System.out.println("Você está sobrepeso");
}
else if (imc >= 30 && imc <= 34.99) {
    System.out.println("Você está com obesidade (grau 1)");
}
else if (imc >= 35 && imc <= 39.99) {
    System.out.println("Você está com obesidade (grau 2)");
}
else if (imc>=40) {
    System.out.println("Você está com obesidade (grau 3)");
    
}
       System.out.println("Quer calcular de novo? (1 para NÃO / 2 para SIM) ");
       int resposta = scanner.nextInt();
       if (resposta == 1) {
        System.err.println("Tchau");
        break;
        
       }
       else {
        continue;}
    }
}} }
