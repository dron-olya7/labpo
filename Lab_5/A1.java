import java.lang.Math;

public class A1 {

    public static void main(String[] args)
    {
        double minx=0.7;
        double maxx=1.2-minx;
        int interval = 100;
        double sum=0;
        double x;
        double[] mas = new double[interval];

        for (int i = 0; i<interval;i++)
        {
            x = Math.random()*maxx+0.7;
            mas[i] = x;
            sum+=x;
        }

        for (int i = 0; i<interval;i++)
        {
            System.out.print(mas[i]+" + ");
        }
        System.out.println(sum/100);    }

};


