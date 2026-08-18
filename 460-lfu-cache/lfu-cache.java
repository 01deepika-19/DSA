class Node{
    int key;
    int value;
    int freq;
    Node next;
    Node prev;
    Node(int k,int v){
        this.key = k;
        this.value = v;
        this.freq=1;
    }
}
class DLL{
    int listSize;
    Node head;
    Node tail;
    public DLL(){
        this.listSize = 0;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev=head;
    }
    public void addNode(Node n){
        n.next = head.next;
        head.next.prev=n;
        n.prev=head;
        head.next=n;
        listSize++;
    }
    public void removeNode(Node n){
        n.next.prev = n.prev;
        n.prev.next = n.next;
        listSize--;
    }
}
class LFUCache {
    final int capacity;
    int minF;
    int currSize;
    Map<Integer,Node> cache;
    Map<Integer,DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize=0;
        this.minF=0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node curr = cache.get(key);
        if(curr == null){return -1;}
        updateNode(curr);
        return curr.value;
    }

    public void updateNode(Node n){
        int curfreq = n.freq;
        DLL curList = freqMap.get(curfreq);
        curList.removeNode(n);

        if(curfreq == minF && curList.listSize == 0){
            minF++;
        }

        n.freq++;
        DLL newList = freqMap.getOrDefault(n.freq,new DLL());
        newList.addNode(n);
        freqMap.put(n.freq,newList);
    }
    
    public void put(int key, int value) {

        if(capacity == 0){return;}
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            curr.value = value;
            updateNode(curr);
        }else{
            currSize++;
            if(currSize > capacity){
                DLL minFreqList = freqMap.get(minF);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            minF=1;
            Node nn = new Node(key,value);
            DLL curList = freqMap.getOrDefault(1,new DLL());
            curList.addNode(nn);
            freqMap.put(1,curList);
            cache.put(key,nn);
        }
    }
  
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */