
    // Classe base
class Animal {
    void fazerSom() {
        System.out.println("O animal faz um som.");
    }
}

// subClasseCachorro
class Cachorro extends Animal {
    @Override
    void fazerSom() {
        System.out.println("O cachorro late.");
    }
}

// SubclasseGato
class Gato extends Animal {
    @Override
    void fazerSom() {
        System.out.println("O gato mia.");
    }
}

public class ExercicioPolimorfismo {
    public static void main(String[] args) {
        // aqui o polimorfismo age
        Animal meuAnimal = new Animal();  
        Animal meuCachorro = new Cachorro(); 
        Animal meuGato = new Gato();  

        meuAnimal.fazerSom();  // Método da classe Animal
        meuCachorro.fazerSom();  // Método sobrescrito na classe Cachorro
        meuGato.fazerSom();  // Método sobrescrito na classe Gato
    }
}

