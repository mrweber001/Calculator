import java.util.*;


public class CalcKata {

    public static void main(String[] args) {


        startCalc();
        Converter Converter = new Converter();
        String a;
        String b;
        String c;
        int num1 = 0;
        int num2 = 0;
        int arabic = 0;
        int roman = 0;


        String[] arab = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };
        String[] rom = {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
        };



        while (true) {
            Scanner vvod = new Scanner(System.in);

            a = vvod.next();

            if (a.equals("exit")) {
                System.out.println("До скорых встреч");
                break;
            }

            for (int i = 0; i < 10; i++) {
                if (a.equals(arab[i])) {
                    num1 = Converter.toArab(a);
                    arabic++;

                } else if (a.equals(rom[i])) {
                    num1 = Converter.toRom(a);
                    roman++;

                }

            }
            c = vvod.next();

            b = vvod.next();
            for (int i = 0; i < 10; i++) {
                if (b.equals(arab[i])) {
                    num2 = Converter.toArab(b);
                    arabic++;

                } else if (b.equals(rom[i])) {
                    num2 = Converter.toRom(b);
                    roman++;

                }

            }

            if (c.equals("+") && arabic == 2) {
                System.out.println(num1 + num2);
            } else if (c.equals("+") && roman == 2) {
                System.out.println(Converter.arabicToRoman(num1 + num2));
            } else if (c.equals("-") && arabic == 2) {
                System.out.println(num1 - num2);
            } else if (c.equals("-") && roman == 2) {
                System.out.println(Converter.arabicToRoman(num1 - num2));
            } else if (c.equals("*") && arabic == 2) {
                System.out.println(num1 * num2);
            } else if (c.equals("*") && roman == 2) {
                System.out.println(Converter.arabicToRoman(num1 * num2));
            } else if (c.equals("/") && arabic == 2) {
                System.out.println(num1 / num2);
            } else if (c.equals("/") && roman == 2) {
                System.out.println(Converter.arabicToRoman(num1 / num2));
            } else {
                throw new IllegalArgumentException("Ты что-то делаешь не верно");

            }
            arabic = 0;
            roman = 0;
            System.out.println("Попробуй решить еще, либо выйди из программы набрав exit");
        }
    }

    private static void startCalc() {
        System.out.println("Добро пожаловать в программу Калькулятор");
        System.out.println("Калькулятор работает с Арабскими и Римскими цифрами");
        System.out.println("Для ввода данных используйте формат: I + X либо 1 + 10");
        System.out.println("Для выхода из программы наберите exit");
    }


}

class Converter {

    public static int toRom(String v) {
        int n1 = 0;
        if (v.equals("I")) {
            n1 = 1;
        }
        if (v.equals("II")) {
            n1 = 2;
        }
        if (v.equals("III")) {
            n1 = 3;
        }
        if (v.equals("IV")) {
            n1 = 4;
        }
        if (v.equals("V")) {
            n1 = 5;
        }
        if (v.equals("VI")) {
            n1 = 6;
        }
        if (v.equals("VII")) {
            n1 = 7;
        }
        if (v.equals("VIII")) {
            n1 = 8;
        }
        if (v.equals("IX")) {
            n1 = 9;
        }
        if (v.equals("X")) {
            n1 = 10;
        }
        return n1;

    }

    public static int toArab(String v) {
        int n2 = 0;
        if (v.equals("1")) {
            n2 = 1;
        }
        if (v.equals("2")) {
            n2 = 2;
        }
        if (v.equals("3")) {
            n2 = 3;
        }
        if (v.equals("4")) {
            n2 = 4;
        }
        if (v.equals("5")) {
            n2 = 5;
        }
        if (v.equals("6")) {
            n2 = 6;
        }
        if (v.equals("7")) {
            n2 = 7;
        }
        if (v.equals("8")) {
            n2 = 8;
        }
        if (v.equals("9")) {
            n2 = 9;
        }
        if (v.equals("10")) {
            n2 = 10;
        }
        return n2;

    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<NUMERAL> romanNumerals = NUMERAL.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            NUMERAL currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}




