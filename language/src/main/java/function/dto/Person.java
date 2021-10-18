package function.dto;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Person {
    private String name;
    private int height;
    private double salary;
    private String gender;
    private int kids;
    private List<String> hobbies;
    private Optional<Address> address;

    public Person(String name, int height, double salary, String gender, int kids, List<String> hobbies) {
        this.name = name;
        this.height = height;
        this.salary = salary;
        this.gender = gender;
        this.kids = kids;
        this.hobbies = hobbies;
    }

    public Person() {
        // Required Empty constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return height == person.height && Double.compare(person.salary, salary) == 0 && kids == person.kids && name.equals(person.name) && gender.equals(person.gender) && hobbies.equals(person.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height, salary, gender, kids, hobbies);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", kids=" + kids +
                ", hobbies=" + hobbies +
                '}';
    }
}
