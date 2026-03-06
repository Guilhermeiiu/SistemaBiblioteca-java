/*Escreva um programa em Java que tenha um método chamado é URL que recebe uma 
String como argumento e verdadeiro se esta String começa com ”http:” ou ”ftp:” ou falso 
caso contrário. */
import java.util.Scanner;

public class AnexoAExercicio06 {
    public static void main(String args[]){ 
Scanner scanner=new Scanner(System.in);
String text=scanner.nextLine();
if(URL(text)){
    System.out.println("É uma URL");
}
else{
    System.out.print("Nao é URL");
}
}  public static boolean URL(String str) {
    return str.startsWith("http:") || str.startsWith("ftp:");
}}

