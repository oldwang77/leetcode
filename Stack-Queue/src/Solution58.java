import java.util.LinkedList;

class Solution58 {
    public String reverseWords(String s) {
        String t = "";
        // 消除字符串两端多余的空格
        s = s.trim();
        String[] ss = s.split(" ");

        // for(int i=0;i<ss.length;i++){
        //     System.out.println(ss[i]+"|");
        // }

        for (int i = ss.length - 1; i >= 0; i--) {
            // 如果遇到空的单词跳过
            // 注意：这里要用equals，因为ss是引用数据类型
            if(ss[i].equals("")) continue;
            t+=ss[i].toString();
            t+=" ";
        }
        return t.trim();
    }

    public static void main(String[] args) {
        Solution58 s = new Solution58();
        System.out.println(s.reverseWords("  hello world!  "));
    }
}