package hu.jnagy;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String s) {
        if (s == null || s.isEmpty())
            return 0;

        List<String> strings = getFormattedValue(s);
        return strings.stream().mapToInt(Integer::parseInt).filter(num -> num < 1000).sum();
    }

    private List<String> getFormattedValue(String s) {
        String[] strings = s.split("\n");
        String numbers = "";
        String regex = ",|\n";
        if (strings.length > 1) {
            String pattern = strings[0];
            numbers = strings[1];
            regex = getRegex(pattern);
        } else {
            numbers = strings[0];
        }
        return Arrays.asList(numbers.split(regex));
    }

    private String getRegex(String pattern) {
        String substringNo = pattern.substring(2);
        if (substringNo.charAt(0) == '[') {
            return substringNo.substring(1, substringNo.length() - 1);
        }
        return substringNo;
    }

}
