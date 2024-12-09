package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {
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
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix.get(i).get(j).equals('X')) {
                    answer += countWord(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static int countWord(int x, int y) {
        Character[] word = {'X', 'M', 'A', 'S'};
        int count = 0;
        int[][] directions = {
                {0, 1},  // Right
                {0, -1}, // Left
                {1, 0},  // Down
                {-1, 0}, // Up
                {1, 1},  // Diagonal down-right
                {-1, -1},// Diagonal up-left
                {1, -1}, // Diagonal down-left
                {-1, 1}  // Diagonal up-right
        };

        for (int[] dir : directions) {
            int dx = dir[0], dy = dir[1];
            boolean match = true;

            for (int i=0; i<word.length; i++) {
                int nx = x + i*dx;
                int ny = y + i*dy;

                if (!valid(nx, ny) || !matrix.get(nx).get(ny).equals(word[i])) {
                    match = false;
                    break;
                }
            }

            if (match) count++;
        }

        return count;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
