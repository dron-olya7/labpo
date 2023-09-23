import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        System.out.println("Задание № 3");
        List<Integer> programVolume = new ArrayList<>() {{
            add(5);
            add(7);
            add(9);
            add(11);
        }};
        List<Integer> programErrors = new ArrayList<>() {{
            add(0);
            add(2);
            add(5);
            add(4);
        }};
        double lambda = 1.53;
        // Вычисляем для трех вариантов коэффициентов
        for (int i = 1; i <= 3; ++i) {
            double rating = calcRating(programVolume, programErrors, lambda, i);
            System.out.println("Рейтинг для коэффициента " + i + ":");
            System.out.printf("%.4f %n", rating);
            // Вычисляем ожидаемое число ошибок
            int expectedErrors = (int)(getCoef(lambda, rating, i) * 15);
            System.out.println("Ожидаемое число ошибок в следующей программе объемом 15 Кб: ");
            System.out.printf("%d шт. %n", expectedErrors);
        }
    }
    public static Double calcRating(List<Integer> programVolume, List<Integer> programErrors, double lambda, int var) {}

}
