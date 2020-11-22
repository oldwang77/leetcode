import java.util.*;


public class Solution1 {
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     *
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */
    public String changeFormatNumber(String number) {
        // write code here
        int max_value = (int) (Math.pow(2, 15) - 1);
        int min_value = (int) (0 - Math.pow(2, 15));
        String input_error = "INPUTERROR";
        String no_data = "NODATA";
        // 这个数的十进制大小
        int ans = 0;

        int len = number.length();
        if (len == 0) return input_error;
        if (number.charAt(0) == '0' && len != 0) return input_error;

        for (int i = 0; i < len; i++) {
            char ch = number.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            } else if (i == 0 && number.charAt(0) == '-') {
                continue;
            } else {
                return input_error;
            }
        }

        // 这个数是十进制的
        ans = solve(number);
        String ans1 = "", ans2 = "";
        if (ans >= 0) {
            ans1 = change(ans);
        } else {
            String res = change(-1 * ans);
            // 取反+1

            if (res.charAt(15) == '1') {
                ans1 = "1";
                for (int i = 1; i < 15; i++) {
                    ans1 += swap(res.charAt(i));
                }
                ans1 += '1';
            } else {
                ans1 = "0";
                int add_one = 1;
                for (int i = 14; i >= 1; i--) {
                    char ch = swap(res.charAt(i));
                    int tmp = ch - '0' + add_one;
                    if (tmp <= 1) {
                        add_one = 0;
                    } else {
                        add_one = 1;
                        ch = '0';
                    }
                    ans1 = ch + ans1;
                }
                ans1 = '1' + ans1;
            }
        }

        // 根据二进制求解十进制
        ans2 = trans(ans1);

        return ans1+","+ans2;
    }

    public String trans(String ans){
        String res = "";
        for(int i=0;i<4;i++){
            String tmp = ans.substring(4*i,4*i+4);
            if(tmp.equals("0000")) res = res+"0";
            if(tmp.equals("0001")) res = res+"1";
            if(tmp.equals("0010")) res = res+"2";
            if(tmp.equals("0011")) res = res+"3";
            if(tmp.equals("0100")) res = res+"4";
            if(tmp.equals("0101")) res = res+"5";
            if(tmp.equals("0110")) res = res+"6";
            if(tmp.equals("0111")) res = res+"7";
            if(tmp.equals("1000")) res = res+"8";
            if(tmp.equals("1001")) res = res+"9";
            if(tmp.equals("1010")) res = res+"A";
            if(tmp.equals("1011")) res = res+"B";
            if(tmp.equals("1100")) res = res+"C";
            if(tmp.equals("1101")) res = res+"D";
            if(tmp.equals("1110")) res = res+"E";
            if(tmp.equals("1111")) res = res+"F";
        }
        return res;
    }

    public char swap(char ch) {
        if (ch == '1') {
            return '0';
        } else {
            return '1';
        }
    }

    public String change(int number) {
        // 十进制转换成二进制
        String ans = "";
        int cnt = 0;
        while (number != 0) {
            int tmp = number % 2;
            number = number / 2;
            ans = tmp + ans;
            cnt++;
        }
        for (int i = 0; i < 16 - cnt; i++) {
            ans = "0" + ans;
        }
        return ans;
    }

    public int solve(String number) {
        int len = number.length();
        char ch = number.charAt(0);
        if (ch == '-') {
            return cal(number.substring(1, len), -1);
        } else {
            return cal(number, 1);
        }
    }

    public int cal(String number, int t) {
        int ans = 0;
        for (int i = 0; i < number.length(); i++) {
            ans = ans * 10 + (number.charAt(i) - '0');
        }
        return t * ans;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String ans = s.changeFormatNumber("-1");
        System.out.println(ans);
    }
}