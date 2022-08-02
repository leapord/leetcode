package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Offer58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }


    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        List<String> list = Arrays.asList(strs);
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
