package entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        //changeCasing(entityManager);
        //isContains(entityManager);
        //salaryOver(entityManager);
        employeesFromDepartment(entityManager);
        //addNewAddress(entityManager);
        //findEmployeesOnAddress(entityManager);


        entityManager.getTransaction().commit();
    }

    private static void findEmployeesOnAddress(EntityManager entityManager) {
        // TODO
        // Find all addresses, ordered by the number of employees who live there (descending).
        // Take only the first 10 addresses and print their address text, town name and employee count.

        List<Address> addresses = entityManager
                .createQuery("FROM Address ORDER BY SIZE(employees) ASC", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.printf("%s, %s - %d employees %n",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size());
        }
    }

    private static void addNewAddress(EntityManager entityManager) {
        // TODO
        // Create a new address with the text "Vitoshka 15".
        // Set that address to an employee with a last name, given as input.

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);

        Employee employee = entityManager.createQuery("FROM Employee WHERE lastName = :lastName", Employee.class).setParameter("lastName", input).getSingleResult();

        employee.setAddress(address);
        entityManager.persist(employee);

    }

    private static void employeesFromDepartment(EntityManager entityManager) {
        // TODO
        // Extract all employees from the Research and Development department.
        // Order them by salary (in ascending order), then by id (in ascending order).
        // Print only their first name, last name, department name and salary.

        List<Employee> query = entityManager.createQuery("FROM Employee WHERE department.name = 'Research and Development' " +
                "ORDER BY salary ASC, id ASC", Employee.class).getResultList();

        query.forEach(employee -> {
            System.out.printf("%s %s from %s - $%.2f", employee.getFirstName(), employee.getLastName(),employee.getJobTitle(), employee.getSalary()).append(System.lineSeparator());
        });

    }

    private static void salaryOver(EntityManager entityManager) {
        // TODO
        // Write a program that gets the first name of all employees who have a salary over 50 000.

        List<Employee> resultList = entityManager.createQuery("FROM Employee WHERE salary > 50000", Employee.class).getResultList();
        for (Employee employee : resultList) {
            System.out.printf("%s", employee.getFirstName()).append(System.lineSeparator());
        }

    }

    private static void isContains(EntityManager entityManager) {
        // TODO
        // Use the soft_uni database.
        // Write a program that checks if a given employee's name is contained in the database.

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Query query = entityManager.createQuery("FROM Employee WHERE firstName = :firstName AND lastName = :lastName", Employee.class);
        query.setParameter("firstName", input[0]);
        query.setParameter("lastName", input[1]);

        List<Employee> result = query.getResultList();

        if (result.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }

    private static void changeCasing(EntityManager entityManager) {
        // TODO
        // Use the soft_uni database. Persist all towns from the database.
        // Detach those whose name length is more than 5 symbols.
        // Then transform the names of all attached towns to uppercase and save them to the database.

        List<Town> towns = entityManager
                .createQuery("FROM Town WHERE LENGTH(name) <= 5", Town.class).getResultList();

        towns.forEach(town -> {
            town.setName(town.getName().toUpperCase());
            entityManager.persist(town);
        });
    }
}
