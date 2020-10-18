import java.util.HashMap;

public class Solution56 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int x:nums){
            hashMap.put(x,0);
        }
        for(int x:nums){
            int value = hashMap.get(x);
            hashMap.put(x,value+1);
        }
        for(Integer key:hashMap.keySet()){
            if(hashMap.get(key)==1){
                return key;
            }
        }
        return -1;
    }
}
