 import java.util.Objects;
 import java.util.Scanner;



public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    public static double convertC2F(double celsius) {

        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {

        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }
    public static double convertK2C(double kelvin) {{ return convertC2F(convertK2C((kelvin))); }



}public static double getTemp(String unit) {
        System.out.printf("%-40s : ", String.format("Please enter °%s temperature to convert", unit));
        return Double.parseDouble(input.nextLine());
    }

    public static String getUnitChoice() {
        System.out.printf("%-4s : %40s%n", "C).", "To convert a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        return input.nextLine();
    }

    public static void main(String[] args) {
        while (true) {
            String sourceUnit = getUnitChoice(true);
            if (sourceUnit.equals("Q")) {
                break;
            }
            String outputUnit = getUnitChoice(false);
            if (outputUnit.equals("Q")) {
                break;
            }
            double temp = getTemp(sourceUnit);
            double convertedTemp = switch (sourceUnit + outputUnit) {
                case "CF":
                    yield convertC2F(temp);
                case "CK":
                    yield convertC2K(temp);
                case "FC":
                    yield convertF2C(temp);
                case "FK":
                    yield convertF2K(temp);
                case "KC":
                    yield convertK2C(temp);
                case "KF":
                    yield convertK2F(temp);
                default:
                    yield 0; // switch statement should never default
            };

            System.out.printf("Result %.6f°%s is %.6f°%s%n%n", temp, sourceUnit, convertedTemp, outputUnit);

        }
    }