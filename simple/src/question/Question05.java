package question;

/**
 * @author leapord
 * @since 2022/8/15
 */
public class Question05 {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
