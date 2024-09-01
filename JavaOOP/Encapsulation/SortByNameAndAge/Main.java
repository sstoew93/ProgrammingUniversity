package Encapsulation.SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        addPersons(reader, n, people);
        sortPersons(people);
        printPersons(people);
    }

    private static void addPersons(BufferedReader reader, int n, List<Person> people) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }
    }

    private static void sortPersons(List<Person> people) {
        people.sort((firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });
    }

    private static void printPersons(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }

}
