package algorithm.algorithem;

import java.util.Comparator;
import java.util.List;


class MyDictComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

public class App_20240407 {
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.sort(new MyDictComparator());
        return backTrack(new StringBuilder(), s, wordDict)[0];
    }

    boolean[] backTrack(StringBuilder s, String target, List<String> list) {
        if (s.length() > target.length()) return new boolean[]{false, false};
        if (s.length() == target.length()) {
            if (s.toString().equals(target)) {
                return new boolean[]{true, true};
            } else {
                return new boolean[]{false, true};
            }
        }

        for (String word : list) {
            s.append(word);
            boolean[] res = backTrack(s, target, list);
            if (!res[0]) {
                s.delete(s.length() - word.length(), s.length());
                if (!res[1]) {
                    break;
                }
            }
            if (res[0]) return new boolean[]{true, true};

        }

        return new boolean[]{false, true};
    }
}
