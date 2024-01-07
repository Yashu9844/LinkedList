public class SearchLL {
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


//    public void addMid(int idx,int data){
//        if(idx == 0){
//            addFist(data);
//            return;
//        }
//
//        Node newNode = new Node(data);
//        size++;
//        Node temp = head;
//        int i=0;
//        while(i < idx-1){
//            temp = temp.next;
//            i++;
//        }
//
//        newNode.next = temp.next; // 9 - > 3
//        temp.next = newNode;  // 2-> 9
//    }

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


    public static void main(String[] args) {
        SearchLL ll = new SearchLL();

        ll.addFist(2);

        ll.addFist(1);

        ll.addFist(9);

        ll.addlast(3);

        ll.addlast(4);

//        ll.addMid(2,9);

        ll.print();
        ll.reverse();

        ll.print();
//        System.out.println(ll.search(2));
//        System.out.println(recSearch(3));
        System.out.println(ll.size);

    }


}



