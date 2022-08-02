package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer50 {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(Character chaz :chars){
           map.put(chaz,map.getOrDefault(chaz,0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            Character chaz = s.charAt(i);
            if(map.get(chaz) == 1) return chaz;
        }
        return ' ';
    }
}
