package leetcode_120_140;

import java.util.*;
import java.util.stream.Collectors;

public class _127 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        _127 demo = new _127();
        String beginWord = "cet";
        String endWord = "ism";

        String[] words = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};

        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList(words));
        System.out.println(demo.ladderLength1(beginWord, endWord, wordList));
        System.out.println(demo.ladderLengthBack(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || !wordList.contains(endWord)) return 0;
        int length = 0;
        List<char[]> wordCharList = wordList.stream().map(String::toCharArray).collect(Collectors.toList());
        length = ladderLengthSub(beginWord.toCharArray(), endWord.toCharArray(), wordCharList);
        return length;
    }

    public int ladderLengthBak(String beginWord, String endWord, List<String> wordList) {
        List<String> reached = new ArrayList<>();
        reached.add(beginWord);
        int distance = 1;

        while (!reached.contains(endWord)) {
            List<String> neighbors = new ArrayList<>();
            for (String s : reached) {
                for (int i = 0; i < s.length(); i++) {
                    char[] word = s.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[i] = c;
                        String neighborWord = new String(word);
                        if (wordList.contains(neighborWord)) {
                            neighbors.add(neighborWord);
                            wordList.remove(neighborWord);
                        }
                    }
                }
            }

            if (neighbors.isEmpty()) {
                return 0;
            }

            reached = neighbors;
            distance++;
        }

        return distance;
    }

    public int ladderLengthBack(String beginWord, String endWord, List<String> wordList) {
        Set<String> startReached = new HashSet<>(), endReached = new HashSet<>(), vis = new HashSet<>(), dict = new HashSet<>(wordList);
        startReached.add(beginWord);
        if (dict.contains(endWord)) endReached.add(endWord);

        for (int length = 2; !startReached.isEmpty(); length++) {
            Set<String> toAdd = new HashSet<>();
            for (String word : startReached) {
                for (int i = 0; i < word.length(); i++) {
                    char[] wordArray = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i)) continue;

                        wordArray[i] = c;
                        String neighborWord = String.valueOf(wordArray);
                        if (endReached.contains(neighborWord)) return length;
                        if (dict.contains(neighborWord) && vis.add(neighborWord)) {
                            toAdd.add(neighborWord);
                        }
                    }
                }
            }
            if (toAdd.size() > endReached.size()) {
                startReached = endReached;
                endReached = toAdd;
            } else {
                startReached = toAdd;
            }
        }

        return 0;
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);
        if (dict.contains(endWord)) qe.add(endWord); // all transformed words must be in dict (including endWord)
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb)) return len; // meet from two ends
                        if (dict.contains(nb) && vis.add(nb)) nq.add(nb); // not meet yet, vis is safe to use
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }

    private int ladderLengthSub(char[] beginWord, char[] endWord, List<char[]> wordList) {
        if (wordList.size() == 0) return 0;
        if (different(beginWord, endWord) == 0) return 1;

        int length = Integer.MAX_VALUE;

        for (int i = 0; i < wordList.size(); i++) {
            char[] word = wordList.get(i);

            if (different(beginWord, word) == 1) {
                wordList.remove(i);
                int subLength = ladderLengthSub(word, endWord, wordList);
                if (subLength != 0) {
                    length = subLength < length ? subLength : length;
                }
                wordList.add(i, word);
            }

        }

        return length == Integer.MAX_VALUE ? 0 : length + 1;
    }


    private int different(char[] word1, char[] word2) {
        int different = 0;
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) {
                different++;
            }
        }

        return different;
    }

}
