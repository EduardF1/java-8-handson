package function.repository;

import function.dto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PersonRepository {

    public static List<Person> getAllPersons() {
        Person p1 = new Person("John", 177, 2000, "Male", 2, Arrays.asList("Swimming", "Football", "Tennis"));
        Person p2 = new Person("Karl", 165, 2500, "Male", 1, Arrays.asList("Driving", "Reading", "Cycling"));
        Person p3 = new Person("Scarlet", 190, 1800, "Female", 0, Arrays.asList("Cooking", "Volley", "Writing"));
        Person p4 = new Person("Jimmy", 180, 3200, "Male", 2, Arrays.asList("Swimming", "Driving", "Tennis"));
        Person p5 = new Person("Dwayne", 183, 6000, "Male", 4, Arrays.asList("Volley", "Football", "Tennis"));
        Person p6 = new Person("Darell", 167, 5000, "Male", 0, Arrays.asList("Cooking", "Writing", "Tennis"));
        Person p7 = new Person("Luigi", 165, 2500, "Male", 3, Arrays.asList("Driving", "Cooking", "Cycling"));
        Person p8 = new Person("Giovanni", 190, 2500, "Male", 3, Arrays.asList("Driving", "Cooking", "Cycling"));


        return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public static Person getPersonByName(String name) {
        return getAllPersons().stream()
                .filter(person -> name.equals(person.getName()))
                .findAny()
                .orElse(null);
    }

    public static Person getPerson() {
        return getAllPersons().get(new Random().nextInt(6));
    }
}
