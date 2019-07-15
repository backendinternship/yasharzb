package Controller;

import Models.Initializer;
import Models.News;
import Models.RSS;

import java.util.Scanner;

public class Controller {
    private static final Controller CONTROLLER = new Controller();
    private Initializer initializer = Initializer.getInstance();

    private Controller() {

    }

    public static Controller getInstance() {
        return CONTROLLER;
    }

    public void main() {
        System.out.println("Initializing started!");
        initializer.main();
        System.out.println("Initializing done!");
        Scanner scanner = new Scanner(System.in);
        String command;
        while (!(command = scanner.nextLine()).equals("exit")) {
            if (command.matches("get\\s[0-9]*"))
                System.out.println(findNews(command));
            else
                System.out.println("Invalid command");
        }
    }

    private String findNews(String input) {
        int id = Integer.parseInt(input.split(" ")[1]);
        try {
            return RSS.findNewsById(id, initializer.getRss()).toString();
        } catch (Exception e) {
            return "News not found!";
        }
    }
}