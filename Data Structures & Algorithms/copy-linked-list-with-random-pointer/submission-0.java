/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;

        while(temp!=null) {
            Node node = new Node(temp.val);
            map.put(temp, node);
            temp = temp.next;
        }

        Node t = head;

        while(t!=null) {
            Node node = map.get(t);
            node.next = (t.next!=null)?map.get(t.next):null;
            node.random = (t.random!=null)?map.get(t.random):null;
            t = t.next;


        }
        return map.get(head);
    }
}
