class Node{
    int freq;
    Node next;
    Node prev;
    HashSet<String> keys;

    Node(int f){
        freq=f;
        next=null;
        prev=null;
        keys=new HashSet<>();
    }
}
class AllOne {

    HashMap<String,Node> map;
    Node head;
    Node tail;
    public AllOne() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }
    public void inc(String key) {
        Node curr = head;
        int newf = 1;
        if(map.containsKey(key)){
            curr = map.get(key);
            newf = curr.freq + 1;
            curr.keys.remove(key);
        }
        if(curr.next.freq == newf){
            curr.next.keys.add(key);
        }else{
            Node nn = new Node(newf);
            nn.keys.add(key);
            nn.next = curr.next;
            curr.next.prev = nn;
            curr.next=nn;
            nn.prev=curr;
        }
        map.put(key,curr.next);
        if(curr.keys.size()== 0 && curr != head){
            removenode(curr);
        }
    }
    
    public void dec(String key) {
        int newf = map.get(key).freq - 1;
        Node curr = map.get(key);
        if(newf == 0){
            curr.keys.remove(key);
            map.remove(key);
            if(curr.keys.size()== 0 && curr != head){
                removenode(curr);
            }
            return ;
        }
        if(curr.prev.freq == newf){
            curr.prev.keys.add(key);
        }else{
            Node nn = new Node(newf);
            nn.keys.add(key);
            nn.prev=curr.prev;
            curr.prev.next=nn;
            nn.next=curr;
            curr.prev=nn;
        }
        curr.keys.remove(key);
        map.put(key,curr.prev);
        if(curr.keys.size()== 0 && curr != head){
                removenode(curr);
        }
        
    }
    
    public String getMinKey() {
        if(head.next == tail){
            return "";
        }
    return head.next.keys.iterator().next();
    }
    
    public String getMaxKey() {
        if(tail.prev == head){
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    private void removenode(Node n){
        n.next.prev=n.prev;
        n.prev.next=n.next;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */