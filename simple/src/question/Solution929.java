package question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] mails = email.split("@");
            String[] seg = mails[0].split("\\+");
            String head = seg[0].replace(".", "");
            set.add(head + "@" + mails[1]);
        }
        return set.size();
    }
}
