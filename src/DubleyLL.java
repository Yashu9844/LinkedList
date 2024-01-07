public class DubleyLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next=null;
            this.prev= null;
        }
    }
     public static Node head;
    public static Node tail;
    public static int size;

    public   void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }

      else {
            newNode.next = head;
            head.prev = newNode;
            head= newNode;
        }
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public int remove(){
        if(head == null){
            System.out.println("DLL is Empty");
            size--;
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            head = tail = null;
        }
        int val = head.data;
        head=head.next;
        head.prev = null;
        size--;
        return val;


    }

    public static void main(String[] args) {
           DubleyLL dll =new DubleyLL();
           dll.addFirst(3);
           dll.addFirst(2);
           dll.addFirst(1);

           dll.print();

           dll.remove();

           dll.print();
        System.out.println(dll.size);


    }
}
