/*Escreva uma classe Dado que tenha um método estático arremesso() que ao ser 
chamado imprima um valor entre 1 e 6.  */
import java.util.Random;
public class AnexoAExercicio08 {
    public static void main(String args[]){

arremesso();
    }
    public static void arremesso(){
        Random random = new Random();
        int resultado = random.nextInt(6) + 1;
        System.out.println("O dado caiu no número: " + resultado);
    }
    
}
