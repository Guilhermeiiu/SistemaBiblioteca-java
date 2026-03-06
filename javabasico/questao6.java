//Faça um programa que calcule a média final do semestre da faculdade
import java.util.Scanner;
public class questao6 {
    public static void main(String[] args)  { Scanner scanner = new Scanner (System.in);
        while (true){
       
        System.out.println("Digite sua nota 1 :");
        float nota1 = scanner.nextFloat();
        System.out.println("Digite sua nota 2 :");
        float nota2 = scanner.nextFloat();
        double media = (((nota1*2)+(nota2*3))/5);
        System.out.println("Sua média é : " + media);

        if(media>=6){
            System.out.println("APROVADO!!");
        }
        else
        {
            System.out.println("REPROVADO!!");
        }
        System.out.println("Digite 1 para calcular outro valor :");
        int resposta = scanner.nextInt();
        if(resposta==1){
        continue;
        }
        else{
            
        System.out.println("Tchau");
        break;
    }
}
scanner.close();
}
}