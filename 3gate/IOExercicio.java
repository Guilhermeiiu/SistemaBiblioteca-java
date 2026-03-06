import java.io.*;

public class IOExercicio {
    public static void main(String[] args) {
        String nomeArquivo = "mensagem.txt";
        String mensagem = "Olá! Isso é um exemplo de I/O em Java.";

        // Escrevendo no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(mensagem);
            System.out.println("Mensagem escrita com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        // Lendo do arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = reader.readLine();
            System.out.println("Conteúdo lido do arquivo: " + linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
