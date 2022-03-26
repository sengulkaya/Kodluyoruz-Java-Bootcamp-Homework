package kaya.sengul.secondweek.sat;

class Person {
    public final String name;
    public final Gender gender;
    public final int number;

    public Person(String name, Gender gender, int number) {
        this.name = name;
        this.gender = gender;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
