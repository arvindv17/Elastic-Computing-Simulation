/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author aasth
 */
public class UserRequestQueue {
    
    private static Node front = null;
    private static Node rear = null;
    private static int size;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public class Node {
    
    public int data;
    public Node next;
    
    public Node(int data)
    {
        this.data = data;
       
    }
    
}
    
    
    
    public void enqueue(int element)
    {
        Node newNode = new Node(element);
        newNode.next = null;
        
        if (front==null)
        {
            front = rear = newNode;
        }
        
        else
        {
            rear.next = newNode;
            rear = newNode;
        }
        rear.next = front;    // next of rear is front in circular queue
       size++;
    }
    
    public Node dequeue()
    {
        Node element;
        if (front == null)
        {
            return null;   // For empty queue
        }
        else if (front == rear)    // only one node in circular queue
        {
            element = front ;
            front = rear = null;
            size--;
        }
        else
        {
            Node temp = front;
            element = temp;
            front = front.next;
            rear.next = front;
           size--;
        }
        return element;
    }
    
    public void display()
    {
        
        Node temp = front;
        if (front != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != front);
        }
    }
    
    
    public boolean isEmpty()
    {
        boolean flag = true;
        
        if (front != null) {
           flag = false; 
        }
        return flag;
    }
    
}
