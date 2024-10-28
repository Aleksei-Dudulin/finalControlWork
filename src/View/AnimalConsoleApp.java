package View;

import Model.Domain.Animal;
import Controller.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AnimalConsoleApp {

    private static final Scanner scanner = new Scanner(System.in);
    private final Controller controller;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public AnimalConsoleApp(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("Welcome to AnimalNurseryApp");
            System.out.println("--------------------------------");
            System.out.println("1. Register new animal");
            System.out.println("2. List animal commands");
            System.out.println("3. Teach new command");
            System.out.println("4. List animals by birth date");
            System.out.println("5. Show total number of animals");
            System.out.println("6. Exit");
            System.out.println("--------------------------------");
            System.out.println();
            System.out.print("Select a menu item: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerAnimal();
                case 2 -> listAnimalCommands();
                case 3 -> teachNewCommand();
                case 4 -> listAnimalsByBirthDate();
                case 5 -> showTotalCount();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void registerAnimal() {
        // Выводим запрос пользователю с цифрами, соответствующими типам животных
        System.out.println("------------------------------");
        System.out.println("Select animal type:");
        System.out.println("1 - Dog \n2 - Cat \n3 - Hamster \n4 - Horse \n5 - Camel \n6 - Donkey");
        System.out.println("------------------------------");
        System.out.print("Input the type: ");
        String type = scanner.nextLine();
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birth date (dd-mm-yyyy): ");
        String birthDateStr = scanner.nextLine();

        try {
            Date birthDate = dateFormat.parse(birthDateStr);
            controller.registerAnimal(type, name, birthDate);
            System.out.println("Animal registered successfully.");
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }

    private void listAnimalCommands() {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.println("Commands: " + controller.getAnimalCommands(name));
    }

    private void teachNewCommand() {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new command: ");
        String command = scanner.nextLine();
        controller.teachCommand(name, command);
        System.out.println("Command added successfully.");
    }

    private void listAnimalsByBirthDate() {
        for (Animal animal : controller.getAnimalsByBirthDate()) {
            System.out.println(animal.getName() + " - " + dateFormat.format(animal.getBirthDate()));
        }
    }

    private void showTotalCount() {
        System.out.println("Total animals registered: " + controller.getTotalCount());
    }
}
