package Dasgal1;

import java.util.ArrayList;
import java.util.List;

class Animal {
}

class Lion extends Animal {
    @Override
    public String toString() {
        return "Арслан";
    }
}

class Zoo<T extends Animal> {
    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        for (T animal : source) {
            destination.add(animal);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Lion> lions = new ArrayList<>();
        lions.add(new Lion());

        List<Animal> animals = new ArrayList<>();

        Zoo<Animal> zoo = new Zoo<>();
        
        zoo.transferAnimals(lions, animals);

        for (Animal a : animals) {
            System.out.println(a);
        }
    }
}
