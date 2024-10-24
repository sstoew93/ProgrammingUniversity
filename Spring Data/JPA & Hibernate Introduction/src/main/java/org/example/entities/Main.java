package org.example.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("school");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Student student = new Student(input);

        em.persist(student);
        em.getTransaction().commit();
    }
}