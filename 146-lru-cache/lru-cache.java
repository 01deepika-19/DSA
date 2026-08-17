class LRUCache {

    class Node{
        int key,value;
        Node next=null;
        Node prev=null;

        Node(int key,int value){
            this.key = key;
            this.value=value;
        }
    }

    private HashMap<Integer,Node> map = new HashMap<>();
    private int capacity;
    private Node dhead;
    private Node dtail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        dhead = new Node(-1,-1);
        dtail = new Node(-1,-1);
        dhead.next = dtail;
        dtail.prev=dhead;

    }

    private void insertAfterHead(Node n){
        n.next = dhead.next;
        dhead.next.prev=n;
        dhead.next=n;
        n.prev=dhead;
    }

    private void deletenode(Node n){
        n.prev.next = n.next;
        n.next.prev=n.prev;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){return -1;}
        Node n = map.get(key);
        deletenode(n);
        insertAfterHead(n);
        return n.value;    
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.value=value;
            deletenode(n);
            insertAfterHead(n);
        }else{
            if(map.size() == capacity){
                Node n = dtail.prev;
                map.remove(n.key);
                deletenode(n);
            }
            Node nn = new Node(key,value);
            map.put(key,nn);
            insertAfterHead(nn);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */