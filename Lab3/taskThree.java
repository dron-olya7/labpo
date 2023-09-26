import java.util.ArrayList;
import java.util.List;

public class taskThree {
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

    // Вычисление варианта коэффициента c(lambda_k, Rk)
    public static double getCoef(double lambda, double Rk, int var) {
        switch (var) {
            case 1 -> {
                return (1.0 / (lambda + Rk));
            }
            case 2 -> {
                return (1.0 / (lambda * Rk));
            }
            case 3 -> {
                return ((1.0 / lambda) + (1.0 / Rk));
            }
            default -> {
                return 0;
            }
        }
    }

    // Рейтинг в i-й момент времени
    // i = programVolume.size(), т.к. для n написанных программ можно вычислить рейтинг в n-ый момент времени
    // размер programErrors предполагается таким же, т.е. по каждой программе есть данные о количестве ошибок в ней
    public static Double calcRating(List<Integer> programVolume, List<Integer> programErrors, double lambda, int var) {
        int i = programVolume == null ? 0 : programVolume.size();

        // Базовый случай при i = 0: R0 = 1000
        if (i == 0) return 1000.0;

        // Рекурсивный вызов: вычисляем предыдущий рейтинг
        // списки программ и ошибок в них сокращаются на 1 элемент
        double prevRate = calcRating(programVolume.subList(0, i - 1), programErrors.subList(0, i - 1), lambda, var);

        // Сумма объемов программ
        Integer programVolumeSum = programVolume.stream().reduce(0, Integer::sum);

        // Сумма ошибок с коэффициентом c
        double programErrorSum = 0;
        for (int k = 0; k < i; k++) {
            double Bk = programErrors.get(k); // количество ошибок
            // Получаем коэффициент c, для его вычисления используем вычисленный по рекурсивной формуле рейтинг
            // в момент времени k - 1
            double c = getCoef(
                    lambda,
                    calcRating(programVolume.subList(0, k), programErrors.subList(0, k), lambda, var),
                    var
            );
            programErrorSum += Bk / c;
        }

        // Окончательно вычисляем рейтинг по формуле
        return prevRate * (1.0 + 1E-3 * (programVolumeSum - programErrorSum));
    }
}
