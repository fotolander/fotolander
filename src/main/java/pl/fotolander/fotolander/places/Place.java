package pl.fotolander.fotolander.places;

import pl.fotolander.fotolander.MapOfPlaces.Pin;

public class Place {

    private Long id;
    private String name;
    private Pin pin;

    public Place(Long id, String name, Pin pin) {
        this.id = id;
        this.name = name;
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place(String name, Pin pin) {
        this.name = name;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pin=" + pin +
                '}';
    }
}
