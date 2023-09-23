import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main
{
    static double Step = 0.0001; //шаг поиска B

    static long IT_MAX = 100000; //Максимальное количество итераций

    static double Sum = 0;     // Сумма интервалов между ошибками.
    static double SumI = 0;    // Сумма произведений интервалов между ошибками на их порядковый номер.

    static double CalcB(ArrayList<Integer> data)
    {

        double r;                   //переменные результата разности: r (result)
        double d = data.size();     //в качестве начального значени В берем размер массива

        Sum = 0;    //обнуляем данные для подсчета новой суммы
        SumI = 0;   //обнуляем данные для подсчета новой суммы

        //Подсчет сумма интервалов между ошибками
        for (Integer x : data) {
            Sum += x;
        }

        //Подсчет суммы произведений интервалов между ошибками на их порядковый номер.
        for (int i = 0, j = 1; i < data.size(); i++, j++) {
            SumI += j * data.get(i);
        }

        //поиск B
        for (int it = 1; it < IT_MAX; it++)
        {
            double left = 0;    //переменная для вычесления левой части уровнения.
            double right = 0;   //переменная для вычсления правой части уровнения.

            //вычисления левой части уровнения.
            for (int i = 0, j = 1; i < data.size(); i++, j++)
            {
                left += ((double) 1 / (d - j + 1));
            }

            //вычесления правой части уровнения
            right = (data.size() * Sum) / ((d + 1) * Sum - SumI);

            //вычесления абсолютного значения между частами уровнения(модуль числа)
            r = Math.abs(left - right);

            // Если текущая разница меньше точности, выходим
            if (r < Step)
            {
                break;
            }

            //добавляем шаг и начинаем новый цикл
            d = d + Step;


        }

        return d;
    }

    static double CalcK(ArrayList<Integer> data)
    {
        double resultK = 0;
        double B = CalcB(data);

        resultK = Math.abs(data.size() / (((B + 1) * Sum) - SumI));

        return resultK;
    }

    static double CalcXinc(ArrayList<Integer> data)
    {
        double result = 0;
        double B = CalcB(data);
        double K = CalcK(data);

        result = 1 / (K * (B - data.size()));

        return result;
    }

    static double CalcTime(ArrayList<Integer> data)
    {
        double result = 0;
        double B = CalcB(data);
        double K = CalcK(data);

        double sum_buff = 0;

        for(int i = 0; i < B - data.size(); i++)
        {
            sum_buff += (double) 1 / (1 + i);
        }

        result = sum_buff / K;

        return result;
    }


    public static void main(String[] args)
    {
        //массив входных данных
        ArrayList<Integer> data = new ArrayList<Integer>();

        //чтение данных из файла
        try
        {
            Scanner scanner = new Scanner(new FileReader("data.txt"));

            while (scanner.hasNextBigInteger())
            {
                data.add(scanner.nextInt());
            }

            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }


        System.out.println("Общее число ошибок в программе (B): " + CalcB(data));
        System.out.println("Коэффициент пропорциональности (K): " + CalcK(data));
        System.out.println("Cреднее время Xn+1 до появления (n+1)-й ошибки как величину: " + CalcXinc(data) + " ч.");
        System.out.println("Время до окончания тестирования tk: " + CalcTime(data) + " ч.");

    }

}