import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {
        int numberOne;
        int numberTwo;
        String meaningOne;
        String meaningTwo;
        String arithmeticExpression;
        String result;
        String[] aValues = input.split("[+\\-*/]");
        if (aValues.length != 2) throw new Exception("Должно быть два операнда");
        arithmeticExpression = detectOperation(input);
        meaningOne = aValues[0];
        meaningTwo = aValues[1];

        if (arithmeticExpression == null) throw new Exception("Неподдерживаемая математическая операция");

        if (isNumeric(meaningOne) && isNumeric(meaningTwo)) {
            numberOne = Integer.parseInt(aValues[0]);
            numberTwo = Integer.parseInt(aValues[1]);
        } else {
            throw new Exception("Числа должны быть в одном формате");
        }

        if (numberOne > 10 || numberTwo > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }

        int raschet = calcR(numberOne, numberTwo, arithmeticExpression);
        result = String.valueOf(raschet);
        return result;
    }

    static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static String detectOperation(String inputValue) {
        if (inputValue.contains("+")) {
            return "+";
        } else if (inputValue.contains("-")) {
            return "-";
        } else if (inputValue.contains("*")) {
            return "*";
        } else if (inputValue.contains("/")) {
            return "/";
        } else {
            return null;
        }
    }

    static int calcR(int valueOne, int valueTwo, String arithmeticExpression) {

        if (arithmeticExpression.equals("+")) {
            return valueOne + valueTwo;
        } else if (arithmeticExpression.equals("-")) {
            return valueOne - valueTwo;
        } else if (arithmeticExpression.equals("*")) {
            return valueOne * valueTwo;
        } else {
            return valueOne / valueTwo;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Введите операцию : ");
        String inputValue = new Scanner(System.in).nextLine();
        System.out.println(calc(inputValue));
    }

}