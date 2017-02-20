package DP;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Created by xuxh-fnst on 2016/8/22.
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        String beginWord = "hit";
        String endWord   = "cot";
        String[] lists = {"hot","dot","dog","lot","log"};

        Set<String> wordList = new HashSet<>(Arrays.asList(lists));
        long t1 = System.nanoTime()/1_000_000;
        System.out.println(ladder.findLadders(beginWord, endWord, wordList));
        long t2 = System.nanoTime()/1_000_100;
        System.out.println(t2 - t1);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new LinkedList<>();
        List<String> ladder = new LinkedList<>();
        ladder.add(endWord);

        wordList.add(beginWord);
        wordList.add(endWord);
        Map<String, List<String>> map = createAdjacentMap(wordList);

        Map<String, Graph> previousWord = bfs(map, beginWord, endWord);
        System.out.println(previousWord.get("sq"));
        getChain(previousWord, ladders, ladder, beginWord, endWord);

        ladders.stream().forEach(Collections::reverse);

        return ladders;
    }

    private Map<String, Graph> bfs(Map<String, List<String>> adjacentMap, String begin, String end){
        Map<String, Graph> previousWord = new HashMap<>();
        List<String> q = new LinkedList<>();
        q.add(begin);

        previousWord.put(begin, new Graph(0, null));

        while (!q.isEmpty()) {
            String current = q.remove(0);
            int dis = previousWord.get(current).dis;
            List<String> adj = adjacentMap.get(current);

            if (adj != null) {
                for (String adjWord : adj) {
                    Graph graph = new Graph(dis + 1, null);
                    List<String> pre = new LinkedList<>();
                    if (previousWord.get(adjWord) == null) {
                        pre.add(current);
                        graph.setPre(pre);
                        previousWord.put(adjWord, graph);
                        q.add(adjWord);
                    }else {
                        if (previousWord.keySet().contains(current)){
                            if (previousWord.get(adjWord).dis > graph.dis) {
                                pre.add(current);
                                graph = previousWord.get(adjWord);
                                graph.setPre(pre);
                            } else if (previousWord.get(adjWord).dis == graph.dis) {
                                pre = previousWord.get(adjWord).pre;
                                pre.add(current);
                                graph.setPre(pre);
                            }
                            previousWord.put(adjWord, graph);
                        }
                    }
                }
            }

        }



        return previousWord;
    }

    private void getChain(Map<String, Graph> prev, List<List<String>> ladders,
                          List<String> result , String begin, String end) {
        if (ladders.size() != 0 && ladders.get(0).size() < result.size()) return;

        if (!prev.keySet().contains(end)) return;

        if (prev.get(end) == null) {
            ladders.add(new LinkedList<>(result));
            return;
        }

        for (String word : prev.get(end).pre) {
            result.add(0,word);
            getChain(prev, ladders, result, begin, word);
            result.remove(0);
        }

    }

    private HashMap<String, List<String>> createAdjacentMap(Set<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            map.put(word, getSimilarWords(word, wordList));
        }

        return map;
    }


    private List<String> getSimilarWords(String beginWord, Set<String> wordsList) {
        return
                wordsList.stream().filter(e-> !e.equals(beginWord))
                        .filter(e->isSimilar(e.toCharArray(), beginWord.toCharArray()))
                        .collect(Collectors.toList());

    }

    private boolean isSimilar(char word1[], char word2[]) {
        int count = 0;
        if (word1.length != word2.length) return false;

        for (int i = 0; i < word1.length; i++){
            if (word1[i] != word2[i]) count++;
        }

        return count == 1;
    }

    static class Graph {
        public int dis;
        public List<String> pre;

        public Graph(int dis, List<String> pre) {
            this.dis = dis;
            this.pre = pre;
        }

        public void setPre(List pre) {
            this.pre = pre;
        }
    }
}
