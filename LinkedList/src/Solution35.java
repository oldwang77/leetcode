import java.util.HashMap;

public class Solution35 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        // hashMap来实现
        HashMap<Node,Node> hashMap = new HashMap<>();
        Node node = head;
        while(node!=null){
            hashMap.put(node,new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node!=null){
            hashMap.get(node).next = hashMap.get(node.next);
            hashMap.get(node).random =hashMap.get(node.random);
            node = node.next;
        }
        return hashMap.get(head);
    }
}
