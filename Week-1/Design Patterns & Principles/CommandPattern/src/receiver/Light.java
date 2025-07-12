package receiver;

public class Light {
    private String room;

    public Light(String room) {
        this.room = room;
    }

    public void turnOn() {
        System.out.println(room + " light turned ON.");
    }

    public void turnOff() {
        System.out.println(room + " light turned OFF.");
    }
}
