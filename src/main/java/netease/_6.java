package netease;

import java.util.Arrays;
import java.util.Scanner;

public class _6 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arrayX = new int[n];
        int[] arrayY = new int[n];

        for (int i = 0; i < arrayX.length; i++) {
            arrayX[i] = scanner.nextInt();
        }

        for (int i = 0; i < arrayY.length; i++) {
            arrayY[i] = scanner.nextInt();
        }

        int[] result = solve(arrayX, arrayY);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int[] solve(int[] arrayX, int[] arrayY) {
        int[] result = new int[arrayX.length];
        int[][] dist = new int[arrayX.length][arrayX.length];

        //init the react array
         for (int i = 0; i < dist.length; i++) {
             for (int j = 0; j < dist.length; j++) {
                 dist[i][j] = -1;
             }
         }

         //calculate the distance array
        for (int i = 0; i < arrayX.length; i++) {
            for (int j = 0; j < arrayX.length; j++) {
                if (i == j) {
                    dist[i][j] = Integer.MAX_VALUE;
                } else {
                    dist[i][j] = Math.abs(arrayX[i] - arrayX[j]) + Math.abs(arrayY[i] - arrayY[j]);
                }
            }
        }
        for (int i = 0; i < arrayX.length; i++) {
             Arrays.sort(dist[i]);
        }

        int[][] steps = new int[arrayX.length][arrayX.length];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                steps[i][j] = sumN(dist[i], j);
            }
        }

        for (int i = 0; i < result.length - 1; i++) {
            int min = steps[0][i];
            for (int j = 0; j < steps.length; j++) {
                if (min >  steps[j][i]) {
                    min = steps[j][i];
                }
            }

            result[i + 1] = min;
        }
        return result;
    }

    //get the sum
    private static int sumN(int[] array, int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += array[i];
        }

        return sum;
    }
}
