import java.util.Scanner;

 //Faça um programa que falo o peso ideal para a pessoa

 class questao7
 {
   public static void main(String args[])
   { 
     Scanner scanner = new Scanner(System.in);
     while (true)
    {
     System.out.println (" Digite sua altura (Metros.cm):");
     float altura = scanner.nextFloat();
     System.out.println("Informe seu sexo (1 para masculino e 2 para feminino)");
     int sexo = scanner.nextInt();
    if(sexo ==1){
    System.out.println("Seu peso ideal é: " + ((72.7*altura) - 58));
 }  
 
    else if (sexo==2){
      System.out.println ("Seu peso ideal é :" + ((62.1*altura) - 44.7));
    }
     System.out.println ("Quer calcular de novo ? Digite 0");
  int resposta= scanner.nextInt();
  if(resposta == 0){
    continue;
  }
  else{
System.out.println ("Tchau");
    break;}
 }
 scanner.close();
 }
 }