import java.util.*;

/**
 * Головний клас програми.
 */
public class Main {

    /**
     * Основний метод, що є точкою входу в програму.
     *
     * @param args Массив рядків, що містить аргументи командного рядка.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Введіть к-сть чисел Фібоначчі: ");
        n = scanner.nextInt();

        FNumbers fNumbers = new FNumbers(n);

        System.out.print("Числа Фібоначчі: ");
        System.out.println(fNumbers.GetNumbers());

        System.out.print("Числа куби в даній послідовності: ");
        System.out.println(FCubeNumbers.getNumbers(fNumbers));
    }
}

/**
 * Клас для обчислення чисел, що є кубами в послідовності Фібоначчі.
 */
class FCubeNumbers {

    /**
     * Метод для отримання чисел, що є кубами в заданій послідовності Фібоначчі.
     *
     * @param FNumbers Об'єкт класу FNumbers, що містить послідовність Фібоначчі.
     * @return Список чисел, що є кубами.
     */
    public static List<Integer> getNumbers(FNumbers FNumbers) {
        List<Integer> cubeNumbers = new ArrayList<>();

        for (int number : FNumbers.GetNumbers()) {
            int cubeRoot = (int) Math.round(Math.cbrt(number));

            if (cubeRoot * cubeRoot * cubeRoot == number) {
                cubeNumbers.add(number);
            }
        }
        return cubeNumbers;
    }
}

/**
 * Клас для генерації послідовності чисел Фібоначчі.
 */
class FNumbers {
    private List<Integer> _numbers = new ArrayList<Integer>(0);

    /**
     * Конструктор класу, що ініціалізує послідовність чисел Фібоначчі.
     *
     * @param numbersCount Кількість чисел Фібоначчі, які потрібно згенерувати.
     */
    public FNumbers(int numbersCount) {
        initialize(numbersCount);
    }

    /**
     * Метод для отримання згенерованої послідовності чисел Фібоначчі.
     *
     * @return Список чисел Фібоначчі.
     */
    public List<Integer> GetNumbers() {
        return _numbers;
    }

    /**
     * Метод для ініціалізації послідовності чисел Фібоначчі.
     *
     * @param numberCount Кількість чисел Фібоначчі, які потрібно згенерувати.
     */
    private void initialize(int numberCount) {
        int firstNumber = 1, secondNumber = 1, thirdNumber = 0;
        if (numberCount > 0) {
            _numbers.add(firstNumber);
        }
        if (numberCount > 1) {
            _numbers.add(secondNumber);
        }
        if (numberCount > 2) {
            for (int i = 2; i < numberCount; i++) {
                thirdNumber = firstNumber + secondNumber;
                _numbers.add(thirdNumber);
                firstNumber = secondNumber;
                secondNumber = thirdNumber;
            }
        }
    }
}
