package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day3/input.txt");
        Scanner scanner = new Scanner(file);

        String input = "";
        while (scanner.hasNextLine()) {
            input += scanner.nextLine();
        }
        scanner.close();

        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'm') {
                answer += multiply(input.substring(i));
            }
        }

        System.out.println(answer);
    }

    public static int multiply(String s) {
        if (!s.startsWith("mul(") || !s.contains(")")) {
            return 0;
        }
        s = s.substring(4, s.indexOf(")"));
        if (!s.contains(",")) {
            return 0;
        }
        String first = s.substring(0, s.indexOf(","));
        String second = s.substring(s.indexOf(",") + 1);

        for (char c : first.toCharArray()) {
            if (!Character.isDigit(c)) {
                return 0;
            }
        }
        for (char c : second.toCharArray()) {
            if (!Character.isDigit(c)) {
                return 0;
            }
        }

        return Integer.parseInt(first) * Integer.parseInt(second);
    }
}
