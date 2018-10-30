import java.text.DecimalFormat;

public class DecimalFormatter {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat(".#");

        double val = 0.99253659;
        System.out.println(decimalFormat.format(val * 100));
        System.out.println((float) (Math.round(val * 1000) / 10.0));
    }
}
