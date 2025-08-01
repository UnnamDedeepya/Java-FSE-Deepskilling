package app;

import model.Computer;

public class ComputerBuilderTestApp {
    public static void main(String[] args) {
        // Build a basic computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();

        // Build a gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .graphicsCard("NVIDIA RTX 4080")
                .storage("1TB SSD")
                .os("Windows 11 Pro")
                .build();

        // Build a developer workstation
        Computer devComputer = new Computer.Builder("AMD Ryzen 9", "64GB")
                .storage("2TB SSD")
                .graphicsCard("Integrated")
                .os("Ubuntu 24.04 LTS")
                .build();

        System.out.println("\n🖥️ Basic Configuration:");
        System.out.println(basicComputer);

        System.out.println("\n🎮 Gaming Configuration:");
        System.out.println(gamingComputer);

        System.out.println("\n💻 Developer Workstation:");
        System.out.println(devComputer);
    }
}
