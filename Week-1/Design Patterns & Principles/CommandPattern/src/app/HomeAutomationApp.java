package app;

import command.LightOffCommand;
import command.LightOnCommand;
import invoker.RemoteControl;
import receiver.Light;

import java.util.Scanner;

public class HomeAutomationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light livingRoomLight = new Light("Living Room");
        RemoteControl remote = new RemoteControl();

        System.out.println("Choose an option:");
        System.out.println("1. Turn ON light");
        System.out.println("2. Turn OFF light");
        int choice = scanner.nextInt();

        if (choice == 1) {
            remote.setCommand(new LightOnCommand(livingRoomLight));
        } else if (choice == 2) {
            remote.setCommand(new LightOffCommand(livingRoomLight));
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        remote.pressButton();
        scanner.close();
    }
}
