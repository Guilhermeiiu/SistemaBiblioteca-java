//Desenvolva um Algoritmo para ler as faltas que um aluno teve nos
//meses de fevereiro, março, abril, maio e junho. O Algoritmo deve calcular o percentual
//de faltas, considerando que em um semestre o total de aulas ministrada é 66. Depois
//deve ser impresso o nome do aluno e o percentual de faltas e uma mensagem que
//dependerá do percentual de faltas considerando as seguintes situações:
//Se percentual de faltas > 25 escrever VOCÊ ESTÁ REPROVADO POR FALTA
//Se percentual de faltas = 25 escrever VOCÊ ESTÁ NO LIMITE DE FALTAS
//Se percentual de faltas = 0 escrever VOCÊ NÃO TEM FALTA
//Se percentual de faltas <25 escrever VOCÊ TEM FALTAS MAS AINDA NÃO ESTÁ NO
//


import java.util.Scanner;

public class questao9 {
    public static void main(String[] args)  {
       Scanner scanner= new Scanner(System.in);
       while (true) {
        System.out.println("Digite o seu número de faltas :");
        int falta = scanner.nextInt();
        
        double porcentage = ((falta*100)/66);
        if(porcentage>25){
            System.out.println("VOCÊ ESTÁ REPROVADO POR FALTA");
            System.out.println("Você faltou : " + porcentage + " por cento das aulas.E o limite é 25");
        }
        else if (porcentage==25){
            System.out.println("VOCÊ ESTÁ NO LIMITE DE FALTAS");
            System.out.println("Você faltou : " + porcentage + " por cento das aulas.E o limite é 25");
        
        }
        else if (porcentage==0){
            System.out.println("VOCÊ NÃO TEM FALTAS");
        }
        else if(porcentage<25){
            System.out.println("VOCÊ TEM FALTAS MAS AINDA NÃO ESTÁ NO LIMITE");
            System.out.println("Você faltou : " + porcentage + " por cento das aulas. E o limite é 25");
        }
      
        System.out.println("Se quiser calcular de novo, digite 1 ");
        int resposta = scanner.nextInt();
        if (resposta == 1){
            continue;

        }
        else{
            System.out.println("TCHAU");
            break;
        }
    }scanner.close();}
}
