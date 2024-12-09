package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day2/input.txt");
        Scanner scanner = new Scanner(file);

        int safeCount = 0;
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (String str : line) {
                list.add(Integer.parseInt(str));
            }

            if (levelSafe(list)) safeCount++;
        }
        scanner.close();
        System.out.println(safeCount);
    }

    public static boolean levelSafe(List<Integer> list) {
        boolean increasing = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1) || list.get(i + 1) - list.get(i) > 3) {
                increasing = false;
                break;
            }
        }

        boolean decreasing = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= list.get(i + 1) || list.get(i) - list.get(i + 1) > 3) {
                decreasing = false;
                break;
            }
        }

        return increasing || decreasing;
    }
}
