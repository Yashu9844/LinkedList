public class Remove {


    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data =data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public  void addFist(int data){

        //Create new Node

        Node newNode = new Node(data);
  size++;
        if(head == null){
            head = tail = newNode;
            return;
        }


        //new   Node next = head here next of newNode is pointing to next of Head

        newNode.next = head;

        //Final step head is pointing to new node

        head=newNode;


    }

    public void addlast(int data){

        //create new -Node

        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }


        //Point tail next null  to newNode ka next

        tail.next=newNode;

        //now move tail to to created last tail;

        tail=newNode;





    }
    public static int remove(){
        int val = head.data;
        head=head.next;
        return val;
    }

    static int printHead(){
        int val = head.data;
        return val;
    }
    public  void print(){
        Node temp=head;
        while(temp!=null){                                         //O(n)
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }


    public void addMid(int idx,int data){
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next; // 9 - > 3
        temp.next = newNode;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL have no elements");
            return Integer.MIN_VALUE;

        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;

        }
        //For size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev =prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail=prev;
        size--;
        return val;

    }
    public static void main(String[] args) {
        Remove ll = new Remove();

        ll.addFist(2);

        ll.addFist(1);

        ll.addlast(3);
        ll.addlast(4);

        ll.remove();

        ll.print();
        ll.removeLast();
        ll.print();
        System.out.println( ll.printHead());

    }


}
