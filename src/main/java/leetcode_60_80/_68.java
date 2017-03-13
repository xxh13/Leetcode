package leetcode_60_80;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by john on 2017/3/13.
 */
public class _68 {

    public static void main(String[] args) {
        _68 demo = new _68();
        String[] words = {"What","must","be","shall","be."};
        demo.fullJustify(words, 100).forEach(System.out::println);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        List<String> list = new LinkedList<>();


        //the count is for calculating the number of words in a line
        int count = 0, width = 0;
        for (int i = 0; i < words.length - 1; i++) {
            list.add(words[i]);
            count++;
            width += words[i].length();
            //下一个单词无法加入这一行
            if (width + count + words[i + 1].length() > maxWidth) {
                int gap = maxWidth - width;
                if (count != 1) {
                    while (gap > 0) {
                        if (count == 2) {
                            while (gap > 0) {
                                list.set(0, list.get(0) + " ");
                                gap--;
                            }
                        }else {
                            for (int j = 0; j < count - 1; j++) {
                                if (gap > 0) {
                                    list.set(j, list.get(j) + " ");
                                    gap--;
                                }
                            }
                        }
                    }
                } else {
                    while (gap > 0) {
                        list.set(0, list.get(0) + " ");
                        gap--;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < count; j++)
                    sb.append(list.get(j));
                result.add(sb.toString());
                list.clear();
                count = 0;
                width = 0;
            }
        }

        String lastWord = words[words.length - 1];
        if (count == 0) {
            StringBuilder sb = new StringBuilder(lastWord);
            int gap = maxWidth - lastWord.length();
            while (gap > 0) {
                sb.append(" ");
                gap--;
            }
            result.add(sb.toString());
        } else {
            list.add(lastWord);
            count++;
            width = width + lastWord.length();
            int gap = maxWidth - width;
            for (int j = 0; j < count - 1; j++) {
                if (gap > 0) {
                    list.set(j, list.get(j) + " ");
                    gap--;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count; j++)
                sb.append(list.get(j));
            for (int j = 0; j < gap; j++)
                sb.append(" ");
            result.add(sb.toString());
        }

        return result;
    }
}
