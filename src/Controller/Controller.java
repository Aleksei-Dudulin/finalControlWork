package Controller;

import Model.AnimalRegistry;
import Model.Domain.Animal;

import java.util.Date;
import java.util.List;

public class Controller {

    private final AnimalRegistry registry;

    public Controller() {
        this.registry = new AnimalRegistry();
    }

    // Заведение нового животного
    public void registerAnimal(String type, String name, Date birthDate) {
        registry.registerAnimal(type, name, birthDate);
    }

    // Получение списка команд
    public List<String> getAnimalCommands(String name) {
        return registry.getAnimalCommands(name);
    }

    // Обучение команды
    public void teachCommand(String name, String command) {
        registry.teachCommand(name, command);
    }

    // Получение списка животных по дате рождения
    public List<Animal> getAnimalsByBirthDate() {
        return registry.getAnimalsByBirthDate();
    }

    // Получение общего количества животных
    public int getTotalCount() {
        return registry.getTotalCount();
    }
}
