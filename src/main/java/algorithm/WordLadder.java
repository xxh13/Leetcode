package algorithm;


import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Created by XXH on 2016/8/6.
 */
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "qa";
        String endWord   = "sq";
        String[] list = {"qa","sq","si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av",
                "sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma",
                "re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm",
                "rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo",
                "na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa",
                "he","lr","sq","ye"};
        Set<String> wordList = new HashSet<>(Arrays.asList(list));
        long t1 = System.nanoTime()/1_000_000;
        List<List<String>> ladders = new WordLadder().findLadders(beginWord, endWord, wordList);
        long t2 = System.nanoTime()/1_000_100;
        ladders.stream().forEach(System.out::println);
        System.out.println(t2 - t1);
    }


    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new LinkedList<>();
        List<String> ladder = new LinkedList<>();
        ladder.add(beginWord);
        ladder.add(endWord);
        if (isSimilar(beginWord.toCharArray(), endWord.toCharArray())){
            ladders.add(ladder);
            return ladders;
        }
        wordList = wordList.stream()
                .filter(e->!e.equals(beginWord))
                .filter(e->!e.equals(endWord))
                .collect(Collectors.toSet());
        subFindLadders(beginWord, endWord, wordList, ladder, ladders);
        return ladders;
    }

    public void subFindLadders(String beginWord, String endWord, Set<String> wordList,
                                  List<String> ladder, List<List<String>> ladders){
        if (ladders.size()!=0 && ladder.size() > ladders.get(0).size()) return;
        if (wordList.size() == 0) return;
        if (isSimilar(beginWord.toCharArray(), endWord.toCharArray())) {
            if (ladders.size() == 0 || ladder.size() == ladders.get(0).size()) {
                ladders.add(new LinkedList<>(ladder));
            } else {
                 if (ladder.size() < ladders.get(0).size()){
                     ladders.clear();
                     ladders.add(new LinkedList<>(ladder));
                 }
            }
            return;
        }

        Set<String> similarWords = getSimilarWords(beginWord, wordList);

        for (String word : similarWords){
            wordList.remove(word);
            ladder.add(ladder.size() - 1, word);
            subFindLadders(word, endWord, wordList, ladder, ladders);
            ladder.remove(ladder.size() - 2);
            wordList.add(word);
        }

    }

    public Set<String> getSimilarWords(String beginWord, Set<String> wordsList) {
        return
                wordsList.stream().filter(e-> !e.equals(beginWord))
                        .filter(e->isSimilar(e.toCharArray(), beginWord.toCharArray()))
                        .collect(Collectors.toSet());

    }

    public static boolean isSimilar(char word1[], char word2[]) {
        int count = 0;
        if (word1.length != word2.length) return false;

        for (int i = 0; i < word1.length; i++){
            if (word1[i] != word2[i]) count++;
        }


        return count == 1;

    }
}
