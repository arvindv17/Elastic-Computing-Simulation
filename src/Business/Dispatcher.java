/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Business.UserRequestQueue;
/**
 *
 * @author arvind
 */
public class Dispatcher{
   
   private UserRequestQueue reqQueue;
   private ActiveServerPool activeServiceQueue;
   private RequestGenerator requestGenerator;

   
   public Dispatcher( RequestGenerator requestGenerator){
       
       reqQueue = requestGenerator.getReqQueue();
       activeServiceQueue = new ActiveServerPool();
   }
   
    public RequestGenerator getRequestGenerator() {
        return requestGenerator;
    }

    public void setRequestGenerator(RequestGenerator requestGenerator) {
        this.requestGenerator = requestGenerator;
    }


    public UserRequestQueue getReqQueue() {
        return reqQueue;
    }


    public ActiveServerPool getActiveServiceQueue() {
        return activeServiceQueue;
    }

    public void setActiveServiceQueue(ActiveServerPool activeServiceQueue) {
        this.activeServiceQueue = activeServiceQueue;
    }
 

}

