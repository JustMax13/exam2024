import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(38);
        numbers.add(20);
        numbers.add(43);
        numbers.add(52);

        SecondLargestNumber.GetSecondLargestAndPrint(numbers);
        // SecondLargestNumber.GetSecondLargest(numbers); - варіант методу без принту в консоль
    }
}