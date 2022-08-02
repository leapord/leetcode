package offer;

public class Offer64 {
    int res = 0;

    public int sumNums1(int n) {
        boolean flag = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }
}
