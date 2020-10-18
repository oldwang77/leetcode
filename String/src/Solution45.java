import java.util.ArrayList;
import java.util.List;

public class Solution45 {
    public String minNumber(int[] nums) {
        List<String> lst = new ArrayList<>();
        for(int x:nums){
            lst.add(String.valueOf(x));
        }
        // 排序
        lst.sort((a,b)->(a+b).compareTo(b+a));
        StringBuilder s = new StringBuilder();
        for(String x:lst){
            s.append(x);
        }
        return s.toString();
    }
}
