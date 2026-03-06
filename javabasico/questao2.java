
//Crie um algoritmo para armazenar a temperatura em graus Celsius e
//apresentá-la convertida em graus Fahrenheit. 


import java.util.Scanner;

public class questao2 {
    public static void main(String[] args) {
        try  (Scanner scanner = new Scanner(System.in)) {
            while(true) {
                System.out.println("Bem vindo! Faça sua converção aqui:");
            System.out.println("Quantos graus celcius?");
            double c = scanner.nextDouble();

            double convercao= (9 * c + 160) / 5;

            System.out.println("Em Fahrenheit é:  " +  convercao);

            System.out.println("Se você quer calcular outro valor clique em aperte qualquer letra, senão digite 1");
            int resposta = scanner.nextInt();
            if (resposta == 1) {
                System.out.println("Tchau!!");
                break;
            }
            else {continue;}
}
        }
        }  
} 
        
    

     


