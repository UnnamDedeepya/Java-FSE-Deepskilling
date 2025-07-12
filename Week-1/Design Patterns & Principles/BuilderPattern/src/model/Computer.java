package model;

public class Computer {
    // Required attributes
    private String cpu;
    private String ram;

    // Optional attributes
    private String storage;
    private String graphicsCard;
    private String os;

    // Private constructor
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.os = builder.os;
    }

    // Static Builder Class
    public static class Builder {
        // Required
        private String cpu;
        private String ram;

        // Optional
        private String storage;
        private String graphicsCard;
        private String os;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder os(String os) {
            this.os = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage +
                ", Graphics Card=" + graphicsCard + ", OS=" + os + "]";
    }
}
