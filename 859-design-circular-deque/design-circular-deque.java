class Node{
    int data;
    Node next;
    Node prev;
    Node(int d){
        data=d;
        next=null;
        prev=null;
    }
}
class MyCircularDeque {
    Node front;
    Node rear;
    final int capacity;
    int size;
    public MyCircularDeque(int k) {
        this.capacity=k;
        size=0;
        front=null;
        rear=null;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){return false;}
        Node nn = new Node(value);
        if(front == null){
            front =rear= nn;
            front.next=front;
            front.prev=front;
        }else{
            nn.next=front;
            nn.prev=rear;
            rear.next=nn;
            front.prev=nn;
            front=nn;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){return false;}
        Node nn = new Node(value);
        if(rear==null){
            rear=front=nn;
            rear.next=rear;
            rear.prev=rear;
        }else{
            nn.next=front;
            nn.prev=rear;
            rear.next=nn;
            front.prev=nn;
            rear=nn;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){return false;}
        if(size==1){
            front=rear=null;
        }else{
            front=front.next;
            rear.next=front;  
            front.prev=rear;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){return false;}
        if(size==1){
            rear=front=null;
        }else{
            rear=rear.prev;
            rear.next=front;
            front.prev=rear;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return front.data;
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.data;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */