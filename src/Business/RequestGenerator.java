/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingWorker;




/**
 *
 * @author jyoti
 */
public class RequestGenerator{
    
    private int reqRate;
    private UserRequestQueue reqQueue;
    private Dispatcher reqServiceDispatcher;

    public Dispatcher getReqServiceDispatcher() {
        return reqServiceDispatcher;
    }

    public void setReqServiceDispatcher(Dispatcher reqServiceDispatcher) {
        this.reqServiceDispatcher = reqServiceDispatcher;
    }

    public RequestGenerator(){
        reqQueue = new UserRequestQueue();
        
    }
    public int getReqRate() {
        return reqRate;
    }

    public void setReqRate(Dispatcher reqServiceDispatcher, int reqRate) {
        this.reqRate = reqRate;
       	

        
        /*Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i< reqRate; i++){
            reqQueue.enqueue((int) (Math.random() * 50 + 1));
            System.out.println("in timer");
            }
            reqQueue.display();
            reqServiceDispatcher.checkReqQueueEmpty();
        }

});
        timer.setRepeats(true);
        timer.start();
        */
        
        

    }

    
    public void setReqQueue(UserRequestQueue reqQueue) {
        this.reqQueue = reqQueue;
        
    }

    public UserRequestQueue getReqQueue() {
        return reqQueue;
    }
    

 
}
