import java.util.*;

public class SelfDesignSort {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("20141208000000");
        list.add("2222");
        list.add(null);
        Collections.sort(list,new Comparator<Object>(){
            @Override
            public int compare(Object o1,Object o2){
                if(o1==null||"".equals(o1)) {
                    return 1;
                }
                if(o2==null||"".equals(o2)){
                    return 1;
                }
                return new Double((String)o2).compareTo(new Double((String)o1));
            }
        });
        for(String item:list){
            System.out.println(item);
        }
    }
}
