package offer;

public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char chaz :chars){
            if(chaz == ' '){
                sb.append("%20");
            }else{
                sb.append(chaz);
            }
        }
        return sb.toString();
    }
}
