public class Palindrome {
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

    public  static int size;

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
    public  void print(){
        Node temp=head;
        while(temp!=null){                                         //O(n)
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }



    public static  int search(int Key){
        Node temp =head;
        int i = 0;
        while(temp != null){
            if(temp.data == Key){
                return  i;
            }
            else{
                temp =temp.next;
                i++;
            }
        }
        return -1;
    }
    public  static int helper(Node head,int Key){
        if(head == null){
            return -1;
        }
        if(head.data == Key){
            return 0;                                           //Here
        }                                                       //First helper return 0
        int idx = helper(head.next,Key);                        //Second helper return 1
        if(idx == -1){                                          //third Helper return 2
            return -1;
        }
        return idx +1;
    }

    public static int recSearch(int Key){

        return helper(head,Key);
    }

    public  static void reverse(){
        Node prev = null;
        Node curr=head;
        Node next;

        while( curr != null){

            next =curr.next;
            curr.next =prev;
            prev = curr;
            curr =next;
        }
        head =prev;

    }
    //Slow - Fast Approach

    public Node findMid(Node head){
        Node slow = head;
        Node fast =head;

        while( fast != null && fast.next != null ){
            slow = slow.next; //+1
            fast =fast.next.next; // +2
        }
        return slow;
    }

    public boolean checkPalin(){
        if( head == null || head.next == null){
            return true;
        }

        //Step-1 Find Mid
        Node midnode = findMid(head);


        //Step -2 reverse 2nd half

        Node prev = null;
        Node curr = midnode;
        Node next;

        while( curr != null){
            next =curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
        }

        Node right = prev;

        Node left =head;


        //step-3
        while ( right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    public static void main(String[] args) {
        Palindrome ll = new Palindrome();

        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(2);
        ll.addlast(2);




        ll.print();
        System.out.println(ll.checkPalin());

//
    }


}




