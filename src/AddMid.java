public class AddMid {
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

    public  void addFist(int data){

        //Create new Node

        Node newNode = new Node(data);

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

        if(head == null){
            head = tail = newNode;
            return;
        }


        //Point tail next null  to newNode ka next

        tail.next=newNode;

        //now move tail to to created last tail;

        tail=newNode;


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
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next; // 9 - > 3
        temp.next = newNode;  // 2-> 9
    }
    public static void main(String[] args) {
        AddMid ll = new AddMid();

        ll.addFist(2);

        ll.addFist(1);

        ll.addlast(3);

        ll.addlast(4);

        ll.addMid(2,9);
        ll.print();
    }


}

