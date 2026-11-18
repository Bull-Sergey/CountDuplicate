import java.util.Arrays;

public class CountDuplicate {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 4, 9, 2, 4, 1};

        int result = countElement(array);
        System.out.println("Общее число повторяющихся элементов: " + result); // Выведет: 5
        System.out.println(Arrays.toString(array));
    }

    public static int countElement(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }

        // Копируем массив, чтобы сохранить исходный порядок элементов
        int[] sorted = Arrays.copyOf(array, array.length);
        // Arrays.sort(array);
        Arrays.sort(sorted);

        int totalDuplicates = 0;
        int i = 0;

        while (i < sorted.length) {
            int count = 1;
            // идем по элементам массива, начиная со следующего и сравниваем с текущим
            // передвигаем указатель count
            while (i + count < sorted.length && sorted[i] == sorted[i + count]) {
                count++;
            }

            if (count > 1) { // если есть дубликаты
                totalDuplicates += count;
            }

            i += count;
        }

        return totalDuplicates;
    }


}

