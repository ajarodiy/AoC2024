package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day1/input.txt");
        Scanner scanner = new Scanner(file);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("   ");
            int first = Integer.parseInt(line[0]);
            int second = Integer.parseInt(line[1]);
            list1.add(first);
            list2.add(second);
        }

        scanner.close();

        Collections.sort(list1);
        Collections.sort(list2);

        int sum = 0;
        for (int i = 0; i < list1.size(); i++) {
            sum += Math.abs(list1.get(i) - list2.get(i));
        }

        System.out.println(sum);

    }
}
