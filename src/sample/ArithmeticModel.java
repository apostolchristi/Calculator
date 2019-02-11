package sample;

import java.text.DecimalFormat;

public class ArithmeticModel {

    public Object calculate(Float number1, Float number2, String operator) {

        switch (operator) {

            case "+":
                return new DecimalFormat("#.#").format(number1 + number2);

            case "-":
                return new DecimalFormat("#.#").format(number1 - number2);

            case "x":
                return new DecimalFormat("#.#").format(number1 * number2);

            case "÷":
                if (number1 == 0) {
                    return "always = 0";
                } else if (number2 == 0) {
                    return "Error ;)";
                } else {
                    return new DecimalFormat("#.#").format(number1 / number2);
                }

            default:
                return 0;
        }
    }
}