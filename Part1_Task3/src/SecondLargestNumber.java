import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargestNumber {
    public static Integer GetSecondLargest(List<Integer> numbers) {
        Collections.sort(numbers, (a, b) -> b.compareTo(a)); // Використовуємо лямбда-вираз для сортування чисел у зворотньому порядку
        return numbers.get(1); // повертаємо 2ге за величиною значення
    }
    public static Integer GetSecondLargestAndPrint(List<Integer> numbers) {
        Collections.sort(numbers, (a, b) -> b.compareTo(a));
        int secondLargest = numbers.get(1);

        System.out.println("2ге за величиною значення в списку це '" + secondLargest + "'.");
        return secondLargest;
    }
}