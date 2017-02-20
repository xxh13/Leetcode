package DP;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 效率太差，转为trie实现
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * Created by XXH on 2016/7/23.
 */

/*
 * how to optimize th process
 */
public class WordSearch {

    public static void main(String[] args) {
        String words[] = {"oath","pea","eat","rain", "aae"};
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','t'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

//        List<String> result = new WordSearch().findWords(board, words);
//        result.stream().forEach(System.out::println);
        System.out.println(new WordSearch().exist(board, "aath"));

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        for (String word : words){
            if (!result.contains(word) && exist(board, word))
                result.add(word);
        }
        return result;
    }


    public boolean exist(char[][] board, String word){
        if (word.length() == 0) return false;

        int trace[][] = new int[board.length][board[0].length];
        char[] word_array = word.toCharArray();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(board[i][j] == word_array[0]){
                    if (search(board, trace, i, j, word_array, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int[][] trace, int i, int j, char word[], int index){
        if (index == word.length) return true;
        if ( i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
        if (trace[i][j] == 1 || board[i][j] != word[index]) return false;

        trace[i][j] = 1;

        boolean exist =  search(board, trace, i-1, j, word, index+1)
                        || search(board, trace, i, j+1, word, index+1)
                        || search(board, trace, i+1, j, word, index+1)
                        || search(board, trace, i, j-1, word, index+1);

        if (exist) return true;

        trace[i][j] = 0;

        return false;

    }

}
