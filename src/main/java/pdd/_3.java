package pdd;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] number = line.split(" ");
        List<Integer> weights = Stream.of(number).map(Integer::parseInt).sorted().collect(Collectors.toList());

        solution(weights);
    }

    private static void solution(List<Integer> weights) {
        int count = 0;
        int i = 0, j = weights.size() - 1;

        int m = 0;
        for (int k = 0; k < weights.size(); k++) {
            if (weights.get(k) == 100) {
                m++;
            }
        }

        if (m > 3) {
            count += (m / 3);
            for (int k = 0; k < (m / 3) * 3; k++) {
                weights.remove(0);
            }
        }

        while (!weights.isEmpty()) {
            j = weights.size() - 1;
            int weight = weights.remove(j);
            count++;

            if (!weights.isEmpty()) {
                int remain = 300 - weight;
                int index = getIndex(weights, remain);
                if (index >= 0) {
                    weights.remove(index);
                }
            }

        }

        System.out.println(count);
    }

    private static int getIndex(List<Integer> weights, int remain) {
        int i = 0;
        for (; i < weights.size(); i++) {
            if (weights.get(i) > remain) {
                return i - 1;
            }
        }

        return i == weights.size() ? weights.size() - 1 : -2;
    }
}
