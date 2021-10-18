package interfaces;

import function.dto.Person;

import java.util.List;

public class PersonDetailsImpl implements PersonDetails {

    @Override
    public double calculateTotalSalary(List<Person> personList) {
        return personList.stream()
                .map(Person::getSalary)
                .reduce(0d, Double::sum);
    }

    @Override
    public int totalKids(List<Person> personList){
        return 20;
    }
}
