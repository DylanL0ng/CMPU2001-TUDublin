package LabTest;
// Sorted linked list with a sentinel node for lab test 2023
// Skeleton code

import java.util.Scanner;

class SortedLL
{
    // internal data structure and
    // constructor code to be added here
    class Node {
        public int data;
        public Node next; 
        public Node prev;     
    }
    private Node head, z;
    
    public SortedLL ()
    {
        z = new Node();
        z.next = z;        
        head = z;
    }
    
    
    // this is the original inser() method
    public void insert(int x)
    {
        Node prev, curr, t;
        t = new Node();
        t.data = x;
        
        z.data = x; prev = null; curr = head;
        while(curr.data < x) {
            prev = curr;
            curr = curr.next;
        }
        t.next = curr;
        
        if(prev == null) 
        {
            head = t;
        }
        else
        {
            t.prev = prev;
            prev.next = t;           
        }
             
    }    
    
    // 30%
  	public int countSame(){
  	    int c = 0;
        Node curr = head;
        while(curr != z) {
            if (curr.data == curr.next.data)
                c++;
            curr = curr.next;
        }

     	return c;
  	}

    // 30%
    public void insertAvg() {
        Node curr = head;

        while(curr != z) {
            if (curr.data != curr.next.data)
            {
                int avg = (curr.data + curr.next.data) / 2;
                
                Node avgNode = new Node();
                avgNode.data = avg;

                Node next = curr.next;
                curr.next = avgNode;
                avgNode.next = next;

                // Skip to the next two since we are iterating in twos
                curr = avgNode.next;
            } else {
                curr = curr.next;
            }
        }
    }


    // 30 %
    public void insertDLL(int x){
        Node curr, t;
        t = new Node();
        t.data = x;
        
        z.data = x; curr = head;

        while(curr.data < x) {
            curr = curr.next;
        }

        t.next = curr;
        if(curr.prev == null) 
        {
            head = t;
        }
        else
        {
            t.prev = curr.prev;
            curr.prev.next = t;  
        }
    }
    
    public void display()
    {
        Node t = head;
        System.out.print("\nHead -> ");
        while( t != z) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("Z\n");
    }
    

    public static void main(String args[])   
    {
        System.out.println("My name is Dylan Hussain and my student ID is C21331063");

        SortedLL list = new SortedLL();
        list.display();
        
        double x;
        int r, i;
                
        for(i = 1; i <= 13; ++i)  {
           x =  (Math.random()*20.0);
           r = (int) x;
           System.out.println("Inserting " + r);
           list.insert(r);              
        }
        list.display();         
        
        
        r = list.countSame();
        System.out.println("\nNumber of same neighbours is " + r);

        list.insertAvg();
        System.out.println("\nList with mid value inserted is:\n");
        list.display();

        list.insertDLL(3);
        list.insertDLL(134);
        list.insertDLL(35);

        list.display();

    }
}