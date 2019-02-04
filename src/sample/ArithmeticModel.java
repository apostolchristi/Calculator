package sample;

public class ArithmeticModel {

    public int calculate (int number1, int number2, String operator) {


        switch (operator) {

            case "+":
                return number1 + number2;

            case "-":
                return number1 - number2;

            case "x":
                return number1 * number2;

            case "÷":
                if(number1 == 0) {
                    return 0;
                } else if (number2 == 0) {
                    return -1;
                }
                else {
                    return number1 / number2;
                }

            default:
                return 0;
        }
    }
}
