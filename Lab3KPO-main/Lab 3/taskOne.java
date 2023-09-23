public class taskOne {
    public static void main(String[] args) {
        System.out.println("Задание № 1");
        double constAlfa = 1.53;
        int n2 = (20 * 30 * 10) + (20 * 3);
        Double programVolume = calcProgramVolume(n2);
        Double programErrors = calcNumberErrors(programVolume, constAlfa);

        System.out.println("а)  Минимальное число независимых входных и выходных операндов(n): " + n2);
        System.out.println("    Потенциальный объем программы (V): " +programVolume.intValue());
        System.out.println("б)  Уровень языка программирования (a): " + constAlfa);
        System.out.println("в)  Потенциальное число ошибок (B): " + programErrors.intValue());
    }
    //Потенциальный объем программы (V)
    public static Double calcProgramVolume(int n){
        return (n + 2) * (Math.log(n + 2) / Math.log(2));
    }
    //Потенциальное число ошибок (B)
    public static Double calcNumberErrors(double v, double a){
        return Math.pow(v, 2) / (3000 * a);
    }
}
