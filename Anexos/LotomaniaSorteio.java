/* Escreva um programa em Java que sorteie 50 números entre 0 e 99 para jogar na 
Lotomania. O programa não deverá sortear duas vezes o mesmo número. Dica: use um 
array para armazenar os números sorteados. */
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LotomaniaSorteio {
    public static void main(String[] args) {
        Set<Integer> numerosSorteados = new HashSet<>();
        Random random = new Random();
        
        while (numerosSorteados.size() < 50) {
            int numero = random.nextInt(100); // Gera um número entre 0 e 99
            numerosSorteados.add(numero); 
        }
        
        System.out.println("Números sorteados:");
        System.out.println(numerosSorteados);
    }
}
