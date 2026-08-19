class TextEditor {
    class Node{
        char ch;
        Node next;
        Node prev;
        Node(char c){
            this.ch = c;
        }
    }
    Node head;
    Node cursor;
    public TextEditor(){
        head = new Node('#');
        cursor=head;
    }
    public void addText(String text) {

        for(char c : text.toCharArray()){
            Node nn = new Node(c);
            nn.prev=cursor;
            nn.next=cursor.next;
            if(cursor.next != null){
                cursor.next.prev=nn;
            }
            cursor.next=nn;
            cursor=nn;
        }
    }
    public int deleteText(int k) {
        int count  =0;
        while(count < k && cursor != head){
            Node prevn = cursor.prev;
            prevn.next = cursor.next;
            if(cursor.next != null){
                cursor.next.prev=prevn;
            }
            cursor=prevn;
            count++;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while(k > 0&& cursor != head){
            cursor=cursor.prev;
            k--;
        }
        return getLast10();
    }
    
    public String cursorRight(int k) {
        while(k > 0 && cursor.next != null){
            cursor = cursor.next;
            k--;
        }
        return getLast10();
    }

    public String getLast10(){
        StringBuilder sb = new StringBuilder();
        Node temp = cursor;
        int count = 0;
        while(temp != head && count < 10){
            sb.append(temp.ch);
            temp=temp.prev;
            count++;
        }
        return sb.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */