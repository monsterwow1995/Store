package util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

    private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static String formatAmountLabel(double amount) {
        if (amount == (int) amount)
            return String.format("%d", (int) amount);
        else
            return String.format("%.2f", amount);
    }

    public static double formatDouble(double amount) {
        return Double.parseDouble(decimalFormat.format(amount));
    }

    public static String formatDate(Date date) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
