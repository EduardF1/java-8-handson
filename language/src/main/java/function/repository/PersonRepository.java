package function.repository;

import function.dto.Address;
import function.dto.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class PersonRepository {
    private static final String[] HOBBIES = new String[]{
            "Tennis", "Swimming", "Football", "Driving", "Writing", "Cooking", "Cycling", "Reading", "Volley"
    };

    private PersonRepository() {
        // Required Empty constructor
    }

    public static List<Person> getAllPersons() {
        Person p1 = new Person("John", 177, 2000, "Male", 2, Arrays.asList(HOBBIES[1], HOBBIES[2], HOBBIES[0]));
        Person p2 = new Person("Karl", 165, 2500, "Male", 1, Arrays.asList(HOBBIES[3], HOBBIES[7], HOBBIES[6]));
        Person p3 = new Person("Scarlet", 190, 1800, "Female", 0, Arrays.asList(HOBBIES[5], HOBBIES[8], HOBBIES[4]));
        Person p4 = new Person("Jimmy", 180, 3200, "Male", 2, Arrays.asList(HOBBIES[1], HOBBIES[3], HOBBIES[0]));
        Person p5 = new Person("Dwayne", 183, 6000, "Male", 4, Arrays.asList(HOBBIES[8], HOBBIES[2], HOBBIES[0]));
        Person p6 = new Person("Darell", 167, 5000, "Male", 0, Arrays.asList(HOBBIES[5], HOBBIES[4], HOBBIES[0]));
        Person p7 = new Person("Luigi", 165, 2500, "Male", 3, Arrays.asList(HOBBIES[3], HOBBIES[5], HOBBIES[6]));
        Person p8 = new Person("Giovanni", 190, 2500, "Male", 3, Arrays.asList(HOBBIES[3], HOBBIES[5], HOBBIES[6]));

        return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public static Person getPersonByName(String name) {
        return getAllPersons().stream()
                .filter(person -> name.equals(person.getName()))
                .findAny()
                .orElse(null);
    }

    public static Person getPerson() {
        return getAllPersons().get(new Random().nextInt(8));
    }

    public static Optional<Person> getPersonOptional() {
        Person person = getPerson();
        person.setAddress(Optional.of(new Address(
                getAddressValues().get("Block"),
                getAddressValues().get("City"),
                getAddressValues().get("State"),
                getAddressValues().get("Country"),
                parseInt(getAddressValues().get("zipCode"))
        )));
        return Optional.of(person);
    }

    public static Map<String, String> getAddressValues() {
        return Stream.of(new String[][]{
                {"Block", "P-25"},
                {"City", "Lausanne"},
                {"State", "Vaud"},
                {"Country", "C.H."},
                {"zipCode", "1000"}
        }).collect(Collectors.toMap(
                data -> data[0],
                data -> data[1])
        );
    }
}