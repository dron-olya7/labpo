import java.util.Scanner;

public class taskTwo {
    public static void main(String[] args) {
        System.out.println("Задание № 2");
        //double constAlfa = 1.53;
        int n2 = (20 * 30 * 10) + (20 * 3);

        Scanner in = new Scanner(System.in);
        System.out.print("Укажите количество программистов в бригаде разработчиков: ");
        int programmerAmount = in.nextInt();
        System.out.print("Укажите производительность (число отлаженных команд в день): ");
        int programmerProductivity = in.nextInt();

        System.out.println("а)  Расчёт структурных параметров: ");
        double modulesAmount = calcModulesAmount((double) n2);
        System.out.println("    1) число модулей программного средства (k): " + modulesAmount);
        double programLength = calcProgramLength(modulesAmount);
        System.out.println("б)  Длина программы (N): " + programLength);
        double programVolume = calcProgramVolume(modulesAmount);
        System.out.println("в)  Объем программного обеспечения (V): " + programVolume);
        double assemblerCommands = calcAssemblerCommands(programLength);
        System.out.println("г)  Количество комманд ассемблера (P): " + assemblerCommands);
        double programmingTime = calcProgrammingTime(programLength, programmerAmount, programmerProductivity);
        System.out.println("д)  Календарное время программирования (T): " + programmingTime);
        double programErrors = calcNumberErrors(programVolume);
        System.out.println("е)  Потенциальное количество ошибок (B): " + programErrors);
        double programReliability = calcProgramReliability(programmingTime, programErrors);
        System.out.println("ж)  Начальная надежность ПО (время наработки на отказ): " + programReliability);

    }

    //расчёт числа модулей программного средства (k)
    public static Double calcModulesAmount(Double n) {
        if ((n / 8) > 8)
            return (n / 8) + (n / (Math.pow(8, 2)));
        else
            return n / 8;
    }

    //расчёт длины программы (N)
    public static Double calcProgramLength(Double k) {
        return (220 * k) + k * (Math.log(k) / Math.log(2));
    }

    //Расчет объема программного обеспечения (V)
    public static Double calcProgramVolume(Double k) {
        return k * 220 * (Math.log(48) / Math.log(2));
    }

    //Расчет количества команд ассемблера (P)
    public static Double calcAssemblerCommands(Double n) {
        return (3 * n) / 8;
    }

    //Расчет календарного времени программирования(T)
    public static Double calcProgrammingTime(Double n, Integer m, Integer v) {
        return (3 * n) / (8 * m * v);
    }

    //Расчет потенциального количества ошибок(B)
    public static Double calcNumberErrors(Double v) {
        return v / 3000;
    }


    //Расчет начальной надёжности ПО (tH)
    public static Double calcProgramReliability(Double t, Double b) {
        return (t * 8) / (2 * Math.log(b));
    }
}