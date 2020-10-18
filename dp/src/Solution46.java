public class Solution46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;

        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i-2, i);
            // 判断xixi-1能否构成一个新的数
            // 类似青蛙跳台阶
            int c = tmp.compareTo("10") >=0 && tmp.compareTo("25")<=0 ? a+b:a;
            b = a;
            a = c;
        }
        return a;
    }
}
