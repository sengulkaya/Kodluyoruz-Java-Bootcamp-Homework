package kaya.sengul.thirdweek.sat.flying.passenger;

public abstract class Passenger {
    protected final String name;
    protected final String surname;
    protected Passenger(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
