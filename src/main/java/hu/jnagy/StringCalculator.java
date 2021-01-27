package hu.jnagy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringCalculator {
    public int add(String s) {
        if (s == null || s.isEmpty())
            return 0;

        List<String>   strings = getFormattedValue(s);
        return strings.stream().mapToInt(Integer::parseInt).filter(num -> num < 1000).sum();
    }

    private List<String> getFormattedValue(String s) {
        String[] strings = s.split("\n");
        String numbers= "";
        String regex = ",|\n";
        if(strings.length>1) {
            String pattern = strings[0];
             numbers = strings[1];
            regex = getRegex(pattern);
        }else {
            numbers = strings[0];
        }
        return Arrays.asList(numbers.split(regex));

      /*  String separator = s.substring(2, 3);
        int index = 3;
        Pattern pattern;
        String line;
        List<Pattern> patterns = new ArrayList<>();
        if (separator.equals("[")) {
            separator = "";
            while (s.charAt(index) != ']') {
                separator += s.substring(index, index + 1);
                index++;
            }
            pattern = Pattern.compile(separator);
            line = s.substring(index + 2);
            patterns.add(pattern);
        } else {
            pattern = Pattern.compile(separator);
            patterns.add(pattern);
            line = s.substring(4);
        }

        StringBuffer sb = new StringBuffer();
        for (Pattern p : patterns) {
            Matcher m = pattern.matcher(line);
            while (m.find()) {
                m.appendReplacement(sb, ",");
            }
            m.appendTail(sb);
        }
        return sb; */
    }

    private String getRegex(String pattern) {
        String substringNo = pattern.substring(2);
        if(substringNo.charAt(0) == '[') {
            return substringNo.substring(1,substringNo.length()-1);
        }
        return substringNo;
    }

    /*private void checkIfAnyNumberIsNegative(StringBuffer sb) {
        IntStream intstream = Arrays.stream(sb.toString().split("[,\n]"))
                .mapToInt(Integer::parseInt).filter(num -> num < 0);
        int[] array = intstream.toArray();
        if (array.length > 0) {
            String negativeString = "";
            for (int i = 0; i < array.length; i++) {
                negativeString += array[i] + " ";
            }
            throw new IllegalArgumentException("negatives not allowed " + negativeString);
        }
    }
    Egy rendszer ami kiszamolja egy list oszeget!
    a negyzet minden elemre aztan oszegzes
    lista osszes elmenek a elentes elojelenek osszeget
    osszeselemenek a szorzata !
    veletlen szamokat general es osszeasja!


    */
}
