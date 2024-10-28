package Model.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Абстрактный класс Anima
public abstract class Animal {
    private String name;
    private Date birthDate;
    private List<String> commands;

    // Конструктор класса
    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<String> getCommands() {
        return new ArrayList<>(commands);
    }

    // Метод для добавления команды
    public void addCommand(String command) {
        commands.add(command);
    }
}
