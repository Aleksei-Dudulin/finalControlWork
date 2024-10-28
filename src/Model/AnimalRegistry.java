package Model;

import Model.Domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalRegistry {

    // Почему final???
    private final List<Animal> animals = new ArrayList<>();
    private final AnimalCounter counter;

    public AnimalRegistry() {
        counter = new AnimalCounter();
    }

    // Заведение нового животного
    public void registerAnimal(String type, String name, Date birthDate) {
        try (counter) {
            Animal animal = switch (type.toLowerCase()) {
                case "1" -> new Dog(name, birthDate);
                case "2" -> new Cat(name, birthDate);
                case "3" -> new Hamster(name, birthDate);
                case "4" -> new Horse(name, birthDate);
                case "5" -> new Camel(name, birthDate);
                case "6" -> new Donkey(name, birthDate);
                default -> throw new IllegalArgumentException("Invalid animal type");
            };
            animals.add(animal);
            counter.add();
        } catch (Exception e) {
            System.err.println("Resource handling error: " + e.getMessage());
        }
    }

    // Список команд животного
    public List<String> getAnimalCommands(String name) {
        return animals.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .map(Animal::getCommands)
                .orElse(new ArrayList<>());
    }

    // Обучение новой команде
    public void teachCommand(String name, String command) {
        animals.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .ifPresent(a -> a.addCommand(command));
    }

    // Список животных по дате рождения
    public List<Animal> getAnimalsByBirthDate() {
        animals.sort((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()));
        return new ArrayList<>(animals);
    }

    // Общее количество животных
    public int getTotalCount() {
        return counter.getCount();
    }

}
