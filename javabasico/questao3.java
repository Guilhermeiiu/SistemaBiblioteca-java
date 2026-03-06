//Faça um porgrama que o usuário possa saber a distância, velocidade ou tempo de uma viagem.

import java.util.Scanner;

public class questao3 {
  

    public static void main(String[] args)  {

        try (Scanner scanner = new Scanner (System.in)){

       while (true) {

        System.out.println("Bem vindo!!");
        System.out.println("O que você quer saber? (tempo (1), velocidade(2) , distância(3))");
       int escolha = scanner.nextInt();
       if (escolha == 1) {
        
        System.out.println("Qual distância você ira percorrer? (Km)");
        double distancia = scanner.nextDouble();
       System.out.println("Qual será a velocidade média(km/h)?");
       double velocidade = scanner.nextDouble();
       double tempo = distancia / velocidade;
       System.out.println("Você irá levar  " + tempo  + " horas" );
       }
       else if (escolha == 2) {
        System.out.println("Qual distância você ira percorrer? (Km)");
        double distancia = scanner.nextDouble();
       System.out.println("Quanto tempo? (em hrs)");
       double tempo = scanner.nextDouble();
       double velocidade = distancia / tempo;
       System.out.println("Você irá ''correr'' por  " + velocidade  + " km/h" );
       }
       else if (escolha ==3) {
        System.out.println("Quanto tempo? (em hrs)");
        double tempo = scanner.nextDouble();
       System.out.println("Qual será a velocidade média?(km/h)");
       double velocidade = scanner.nextDouble();
       double distancia = tempo * velocidade;
       System.out.println("Você irá percorrer  " + distancia  + " km" );
        
       }
       System.out.println("Quer ver com outros valores? (1 para SIM; 2 para NÃO)");
       int resposta = scanner.nextInt();
       if (resposta == 1) { System.out.println("OK!");
        continue;}
        else if (resposta == 2) {System.out.println("Tchau!");
            break;
        
        
       }

        }
}}}
