import java.lang.Math;
public class A2
{
    public static void main(String[] args)
    {
        double minx=9;
        double maxx=14-minx;
        int interval = 200;
        double sum=0;
        double p;
        double x;
        double[] mas = new double[interval];
        for (int i = 0; i<interval;i++)
        {
            x = Math.random()*maxx+minx;
            mas[i] = x;
        }

        for (int i = 0; i<interval;i++)
        {
            System.out.println(mas[i]);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i =0;i<interval;i++)
        {
            if ((mas[i] / 12) < 1)
            {
                System.out.println(mas[i]/12);
                sum+=mas[i]/12;
            }
            else
            {
            System.out.println(1);
            sum+=1;
            }
        }

        System.out.println();
        System.out.println(sum+" "+sum/200);
    }

}
