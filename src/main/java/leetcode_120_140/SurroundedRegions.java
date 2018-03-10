package leetcode_120_140;

public class SurroundedRegions {

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
        SurroundedRegions demo = new SurroundedRegions();
        demo.solve(board);
    }

    int[] unionSet; // union find set
    boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of the matrix

    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;

        // init, every char itself is an union
        int height = board.length, width = board[0].length;
        unionSet = new int[height * width];
        hasEdgeO = new boolean[unionSet.length];
        for(int i = 0;i<unionSet.length; i++) unionSet[i] = i;
        for(int i = 0;i<hasEdgeO.length; i++){
            int x = i / width, y = i % width;
            hasEdgeO[i] = (board[x][y] == 'O' && (x==0 || x==height-1 || y==0 || y==width-1));
        }

        // iterate the matrix, for each char, union it + its upper char + its right char if they equals to each other
        for(int i = 0;i < unionSet.length; i++){
            int x = i / width, y = i % width, up = x - 1, right = y + 1;
            if(up >= 0 && board[x][y] == board[up][y]) union(i,i-width);
            if(right < width && board[x][y] == board[x][right]) union(i,i+1);
        }

        for(int i = 0;i < unionSet.length; i++){
            int x = i / width, y = i % width;
            if(board[x][y] == 'O' && !hasEdgeO[findSet(i)])
                board[x][y] = 'X';
        }

        System.out.println();
    }

    private void union(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);

        boolean hasEdge0 = hasEdgeO[rootX] || hasEdgeO[rootY];

        unionSet[rootX] = rootY;
        hasEdgeO[rootY] = hasEdge0;
    }

    //find parent group recursively
    private int findSet(int x) {
        if (unionSet[x] == x) return x;
        unionSet[x] = findSet(unionSet[x]);
        return unionSet[x];
    }
}
