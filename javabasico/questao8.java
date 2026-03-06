import java.util.Scanner;

//A jornada de trabalho semanal de um funcionário é de 40 horas. O funcionário que
//trabalhar mais de 40 horas receberá hora extra, cujo cálculo é o valor da hora regular
//com um acréscimo de 50%. Desenvolva um algoritmo que leia o número de horas
//trabalhadas em um mês, o salário por hora e escreva o salário total do funcionário,
//que deverá ser acrescido das horas extras, caso tenham sido trabalhadas (considere
//que o mês possua 4 semanas exatas).


class questao8
{
  public static void main(String args[])
  { 
    Scanner scanner = new Scanner (System.in);
 while (true) {
    
 
   System.out.println("Informe a quandidade de horas que você trabalha por mês:");
   int horasmes = scanner.nextInt();
   System.out.println ("Informe o seu salario por hora: ");
   double salarioHora = scanner.nextDouble();
   double salarionorm = salarioHora*horasmes;
   double  salariomais = ((160*horasmes)+ ((salarioHora*0.5 + salarioHora)* (horasmes-160)));
   if (horasmes>160){
     System.out.println ("Seu salario será:" + salariomais );
     
      }
      else if (horasmes<=160){
        System.out.println ("Seu salario será: " +   salarionorm ) ;}
        System.out.println("Se quiser calcular de novo digite 1");
        int resposta=scanner.nextInt();
        if (resposta==1){
            continue;
        }
        else{
            break;
        }

  }scanner.close();
}}