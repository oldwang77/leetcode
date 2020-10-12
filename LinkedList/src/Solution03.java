import java.util.HashMap;

public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        int tmp = 0;
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                tmp = nums[i];
                break;
            }else{
                hashMap.put(nums[i],1);
            }
        }
        return tmp;
    }
}
