package graph;


import java.math.BigInteger;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int p = sc.nextInt();
//
//        int[][] map = new int[n][m];
//        int[][] visit = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                map[i][j] = sc.nextInt();
//            }
//        }
//
//        HashMap<Integer, ArrayList<Point>> paths = new HashMap<>();
//        ArrayList<Point> path = new ArrayList<>();
//
//        search(map, visit, 0, 0, p, path, paths);
//
//        if (paths.size() == 0) {
//            System.out.println("Can not escape");
//        }
//
//        for (int i : paths.keySet()) {
//            ArrayList<Point> list = paths.get(i);
//            for (int j = 0; j < list.size(); j++) {
//                System.out.print("[" + list.get(j).x + "," + list.get(j).y + "],");
//            }
//            System.out.print("[" + 0 + "," + (m -1) + "]");
//        }



                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int count = 0;

                while (n > 0) {
                    if( n % 5 == 0) count ++;
                    n --;
                }

                System.out.println(count);
            }



    private static void search(int[][] map,int[][] visit, int i, int j, int p,
                               ArrayList<Point> path, HashMap<Integer, ArrayList<Point>> paths) {
        // out of boundary
        if (i < 0 || j < 0 || i >= map.length || j >= map[0].length) return;
        // cannot reach
        if (map[i][j] == 0 || visit[i][j] == 1) return;
        //p lower than zero
        if (p < 0) return;
        // get to the dest
        if (i == 0 && j == map[0].length - 1) {
            if (paths.size() == 0) {
                paths.put(p, new ArrayList<Point>(path));
            }else {
                for (int key : paths.keySet()) {
                    if (key  < p) {
                        paths.remove(key);
                        paths.put(p, new ArrayList<>(path));
                        break;
                    }
                }

            }
            return;
        }

        visit[i][j] = 1;
        path.add(new Point(i, j));

        search(map, visit, i - 1, j, p, path, paths);
        search(map, visit, i + 1, j, p - 3, path, paths);
        search(map, visit, i, j - 1, p - 1, path, paths);
        search(map, visit, i, j + 1, p - 1, path, paths);

        visit[i][j] = 0;
        path.remove(path.size() - 1);
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
