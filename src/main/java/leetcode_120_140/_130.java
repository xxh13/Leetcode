package leetcode_120_140;

import java.util.*;

public class _130 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        char[][] board = {
                {'X', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'O'},
        };
        _130 demo = new _130();
        demo.solve(board);
    }

    public static void test2() {
        _130 demo = new _130();
        Set<Point> set1 = Set.of(new Point(3,2), new Point(1,2), new Point(2,2), new Point(1,1), new Point(3,3));
        Set<Point> set2 = Set.of(new Point(3, 1));
        System.out.println(demo.union(set1, set2));
    }

    public void solve(char[][] board) {
        List<Set<Point>> regions = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'X') {
                    Set<Point> region = new HashSet<>();
                    region.add(new Point(i, j));
                    regions.add(region);
                }
            }
        }

        //make the point partition
        List<Set<Point>> partition = new LinkedList<>();
        while (!regions.isEmpty()) {
            Set<Point> set1 = regions.remove(0);
            for (int i = 0; i < regions.size();) {
                if (union(set1, regions.get(i))) {
                    set1.addAll(regions.remove(i));
                    i = 0;
                } else {
                    i++;
                }
            }
            partition.add(set1);
        }

        //replace inner 'X' with 'O'
        for (int i = 0; i < partition.size(); i++) {
            boolean inner = true;
            for (Point p: partition.get(i)) {
                if (!(p.x < board.length - 1 && p.x > 0 && p.y < board[0].length - 1 && p.y > 0)) {
                    inner = false;
                    break;
                }
            }
            if (inner) {
                for (Point p : partition.get(i)) {
                    board[p.x][p.y] = 'X';
                }
            }
        }

    }

    private boolean union(Set<Point> set1, Set<Point> set2) {
        for (Point point1 : set1) {
            for (Point point2 : set2) {
                if (adjacent(point1, point2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean adjacent(Point p1, Point p2) {
        return (p1.x == p2.x && Math.abs(p1.y - p2.y) == 1) || (p1.y == p2.y && Math.abs(p1.x - p2.x) == 1);
    }

    private void printRegion(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
