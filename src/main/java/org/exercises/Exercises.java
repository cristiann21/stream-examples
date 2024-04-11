package org.exercises;

import org.example.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercises {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob", "Peppa");

        names
                .stream()
                .forEach(System.out::println);

        System.out.println("El primero es " + first(names));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        System.out.println("El primero es " + first(numbers));
    }

    public static <T> T first(List<T> names) {
        Optional<T> firstNameOpt = names
                .stream()
                .findFirst();

        return firstNameOpt.orElse(null);
    }


    public static List<String> mapToEmails(List<Student> students) {
        return students
                .stream()
                .map(student -> student.getEmail())
                .collect(Collectors.toList());
    }

    public static List<Student> filterByZipCode(List<Student> students, int zipCode) {
        return students
                .stream()
                .filter(student -> student.getZipCode() == zipCode)
                .collect(Collectors.toList());
    }

    public static double sum(List<Double> numbers) {
        return numbers
                .stream()
                .reduce(0d, (a, b) -> a + b);
    }

    public static Optional<Double> average(List<Double> numbers) {
        return numbers
                .stream()
                .reduce((a, b) -> a + b)
                .map(sum -> sum / numbers.size());
    }

}
