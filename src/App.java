import View.AnimalConsoleApp;
import Controller.Controller;

public class App {
    public static void run() {
        Controller controller = new Controller();
        AnimalConsoleApp consoleApp = new AnimalConsoleApp(controller);
        consoleApp.run();
    }
}
