package template;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Template {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day1/input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");

        }

        scanner.close();

    }
}
