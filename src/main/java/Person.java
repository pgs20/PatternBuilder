import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return OptionalInt.of(this.age).getAsInt();
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setAge(int age) {
        if (!this.hasAge()) {
            if (this.age <= 0) {
                System.out.println("Возраст не может быть изменен!");
            } else {
                this.age = age;
            }
        } else {
            System.out.println("Возраст не может быть изменен с помощью данного метода!");
        }
    }

    public boolean hasAge() {
        return OptionalInt.of(this.age).isPresent();
    }

    public boolean hasAddress() {
        return Optional.of(this.address).isPresent();
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(Person.this.surname)
                .setAge(1)
                .setAddress(Person.this.address);
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                "\nФамилия: " + surname +
                "\nВозраст: " + ((age == 0) ? "Неизвестно" : age) +
                "\nГород проживания: " + ((address == null) ? "Неизвестно" : address);
    }

}
