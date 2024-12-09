package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Second {
    static List<List<Character>> matrix;
    static int n, m;
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/day4/input.txt");
        Scanner scanner = new Scanner(file);
        matrix = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<Character> row = new ArrayList<>();
            for (char c : line.toCharArray()) {
                row.add(c);
            }
            matrix.add(row);
        }
        scanner.close();

        int answer = 0;
        n = matrix.size();
        m = matrix.get(0).size();
        for (int i=1; i<n-1; i++) {
            for (int j=1; j<m-1; j++) {
                if (matrix.get(i).get(j).equals('A')) {
                    if (checkWord(i, j)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean checkWord(int x, int y) {
        String firstWord = "";
        String secondWord = "";

        for (int i=-1; i<=1; i++) {
            firstWord += matrix.get(x+i).get(y+i);
        }
        for (int i=-1; i<=1; i++) {
            secondWord += matrix.get(x+i).get(y-i);
        }

        return (firstWord.equals("MAS") || firstWord.equals("SAM")) && (secondWord.equals("MAS") || secondWord.equals("SAM"));
    }

//    public static boolean valid(int x, int y) {
//        return x >= 0 && x < n && y >= 0 && y < m;
//    }
}
