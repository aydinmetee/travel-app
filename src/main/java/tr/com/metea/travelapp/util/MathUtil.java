package tr.com.metea.travelapp.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public final class MathUtil {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final BigDecimal ZERO = new BigDecimal("0");
    public static final BigDecimal HUNDRED = new BigDecimal("100");
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    public static final int ROUNDING_SCALE = 2;

    private MathUtil() {
    }

    public static BigDecimal sum(BigDecimal... numbers) {
        BigDecimal total = new BigDecimal("0");
        BigDecimal[] numberArray = numbers;
        int numberArrayLength = numbers.length;

        for (int index = 0; index < numberArrayLength; ++index) {
            BigDecimal number = numberArray[index];
            if (number != null) {
                total = add(total, number);
            }
        }

        return total;
    }

    public static BigDecimal avg(BigDecimal... numbers) {
        return divide(sum(numbers), BigDecimal.valueOf(numbers.length));
    }

    public static BigDecimal percent(BigDecimal value, BigDecimal ratio) {
        return percent(value, ratio, false);
    }

    public static BigDecimal percent(BigDecimal value, BigDecimal ratio, boolean scale) {
        return operate(operate(value, ratio, MULTIPLY), HUNDRED, DIVIDE, scale);
    }

    public static BigDecimal weigthtedPercent(BigDecimal value, BigDecimal ratio, BigDecimal weight) {
        return weigthtedPercent(value, ratio, weight, false);
    }

    public static BigDecimal weigthtedPercent(BigDecimal value, BigDecimal ratio, BigDecimal weight, boolean scale) {
        return operate(operate(value, ratio, DIVIDE), weight, MULTIPLY, scale);
    }

    public static boolean isPositive(BigDecimal candidate) {
        return candidate != null && candidate.compareTo(ZERO) >= 0;
    }

    public static BigDecimal scaleAndRound(BigDecimal number, int scale, RoundingMode roundingMode) {
        if (number != null) {
            return number.setScale(scale, roundingMode);
        } else {
            return createBigDecimal("0");
        }
    }

    public static BigDecimal scaleAndRound(BigDecimal number) {
        return scaleAndRound(number, ROUNDING_SCALE, ROUNDING_MODE);
    }

    public static Double scaleAndRound(Double number) {
        return scaleAndRound(BigDecimal.valueOf(number), ROUNDING_SCALE, ROUNDING_MODE).doubleValue();
    }

    public static Double scaleAndRound(Double number, int scale, RoundingMode roundingMode) {
        if (number != null) {
            return BigDecimal.valueOf(number).setScale(scale, roundingMode).doubleValue();
        } else {
            return createBigDecimal("0").doubleValue();
        }
    }

    public static BigDecimal createBigDecimal(String number) {
        return new BigDecimal(number);
    }

    public static BigDecimal createBigDecimalAndScaleAndRound(String number) {
        return scaleAndRound(new BigDecimal(number));
    }

    public static BigDecimal operate(BigDecimal first, BigDecimal second, String type) {
        return operate(first, second, type, false);
    }

    public static BigDecimal operate(BigDecimal first, BigDecimal second, String type, boolean scaleAndRound) {

        BigDecimal result;

        if (first == null) {
            first = new BigDecimal("0");
        }

        //For java.lang.ArithmeticException: Division undefined
        if (DIVIDE.equals(type) && first.compareTo(BigDecimal.ZERO) == 0) {
            return first;
        }

        if (second == null) {
            return first;
        }

        switch (type) {
            case PLUS:
                result = first.add(second);
                break;
            case MINUS:
                result = first.subtract(second);
                break;
            case MULTIPLY:
                result = first.multiply(second);
                break;
            case DIVIDE:
                result = first.divide(second, MathContext.DECIMAL128);
                break;
            default:
                result = first;
        }

        if (scaleAndRound) {
            result = scaleAndRound(result);
        }

        return result;
    }

    public static BigDecimal add(BigDecimal first, BigDecimal second) {
        return operate(first, second, PLUS);
    }

    public static BigDecimal subtract(BigDecimal first, BigDecimal second) {
        return operate(first, second, MINUS);
    }

    public static BigDecimal multiply(BigDecimal first, BigDecimal second) {
        return operate(first, second, MULTIPLY);
    }

    public static BigDecimal divide(BigDecimal first, BigDecimal second) {
        return operate(first, second, DIVIDE);
    }

    public static String format(BigDecimal bd, int fractionDigits) {
        if (bd != null) {
            bd = scaleAndRound(bd, fractionDigits, ROUNDING_MODE);

            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(fractionDigits);
            df.setMinimumFractionDigits(0);
            df.setGroupingUsed(false);
            return df.format(bd);
        } else {
            return null;
        }
    }
}
