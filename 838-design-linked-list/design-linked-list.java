class Node{
    int val;
    Node next;
    Node prev;
    
    Node(int v){
        this.val = v;
        this.next = null;
        this.prev = null;
    }
}

class MyLinkedList {
    
    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        head = null;
        tail=null;
        size=0;
    }
    
    public int get(int index) {
        if(index >= size || index < 0){return -1;}
        Node temp = head;
        for(int i = 0;i<index;i++){
            temp=temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node nn = new Node(val);
        if(head == null){
            head=tail=nn;
        }else{
            nn.next = head;
            head.prev = nn;
            head = nn;
        }
       size++;
    }
    
    public void addAtTail(int val) {
        
        Node nn = new Node(val);
        if(head == null){
            head = tail = nn;
        }else{
            tail.next = nn;
            nn.prev=tail;
            tail=nn;
        }    
        size++;
    }
    
    public void addAtIndex(int index, int val) {

        if(index == size){
            addAtTail(val); 
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index > size || index <0){ 
            return;
        }

        Node temp = head;
        for(int i = 0;i<index-1;i++){
            temp=temp.next;
        }
        Node nn = new Node(val);
        nn.next = temp.next;
        nn.prev = temp;
        temp.next.prev = nn;
        temp.next = nn;
        size++;

        
    }
    public void deleteAtIndex(int index) {

        if(index < 0 || index >=size){
            return ;
        }

        if(index == 0){
            if(head == tail){
                head=tail=null;
            }else{
                head=head.next;
                head.prev=null;
            }
        size--;
        return;
        }

        if(index == size-1){
            tail=tail.prev;
            tail.next=null;
            size--;
            return;
        }

        Node temp = head;
        for(int i = 0;i<index;i++){
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */