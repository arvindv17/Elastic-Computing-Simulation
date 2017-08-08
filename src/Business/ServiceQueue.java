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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceQueue {

    private int processingTime;

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    private int currentSize; //Current Circular Queue Size
    private int[] circularQueueElements;
    private int maxQue; //Circular Queue maximum size

    private int rear;//rear position of Circular queue(new element enqueued at rear).
    private int front; //front position of Circular queue(element will be dequeued from front).      

    public ServiceQueue() {
        this.maxQue = 10;
        circularQueueElements = new int[maxQue];
        currentSize = 0;
        front = maxQue - 1;
        rear = maxQue - 1;
        
    }

   
    public void enqueue(int item) {
        if (isFull()) {
           
            System.out.println("Circular Queue is full. Element cannot be added");
        } else {
            circularQueueElements[rear] = item;
            rear = (rear + 1) % circularQueueElements.length;
            currentSize++;
        }
    }

  
    public int dequeue() {
        int deQueuedElement = -1;
        if (isEmpty()) {
            
           System.out.println("Empty Queue, no element to dequeue");
        } else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = 0;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    /**
     * Check if queue is full.
     */
    public boolean isFull() {
        return ((rear + 1) % maxQue == front);
    }

    /**
     * Check if Queue is empty.
     */
    public boolean isEmpty() {
        return (rear == front);
    }

    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
    }



    public void sqTimerDeque() {
        System.out.println("sqTimerDeque !");
        Timer timerSq = new Timer();
        TimerTask timertaskSq = new TimerTask() {
            @Override
            public void run() {
                System.out.println("sqTimerDeque : deque");
                dequeue();
            }
        };
        timerSq.scheduleAtFixedRate(timertaskSq, 0, 1000);

    }

}
