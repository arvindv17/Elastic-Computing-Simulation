/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.ReqQueue;

/**
 *
 * @author rajan
 */
public class ReqServiceDispatcher {

    private ReqQueue reqQueue;
    private ActiveServiceQueue activeServiceQueue;
    private RequestGenerator requestGenerator;

    public ReqServiceDispatcher(RequestGenerator requestGenerator) {

        reqQueue = requestGenerator.getReqQueue();
        activeServiceQueue = new ActiveServiceQueue();
    }

    public RequestGenerator getRequestGenerator() {
        return requestGenerator;
    }

    public void setRequestGenerator(RequestGenerator requestGenerator) {
        this.requestGenerator = requestGenerator;
    }

    public ReqQueue getReqQueue() {
        return reqQueue;
    }

    /*
    public void setReqQueue(ReqQueue reqQueue) {
        this.reqQueue = requestGenerator.getReqQueue();
    }
     */
    public ActiveServiceQueue getActiveServiceQueue() {
        return activeServiceQueue;
    }

    public void setActiveServiceQueue(ActiveServiceQueue activeServiceQueue) {
        this.activeServiceQueue = activeServiceQueue;
    }

    public void checkReqQueueEmpty() {
        int counter = 0;
        while (!reqQueue.isEmpty()) {
            if (reqQueue.isEmpty()) {
                System.out.println("No requests present");
            } else {
                int request;
                request = reqQueue.dequeue().data;
                
                if (activeServiceQueue.getServiceQueueList().size() == 0) {
                    
                    ServiceQueue serviceQueue = new ServiceQueue();
                    activeServiceQueue.getServiceQueueList().add(serviceQueue);
                    serviceQueue.enqueue(request);
                    System.out.println("Queue " + activeServiceQueue.getServiceQueueList().size() + serviceQueue);
//                System.out.println("in dispatcher - if part");

                }
               
            else {
                    ServiceQueue serviceQueue = new ServiceQueue();
                    counter++;
                    activeServiceQueue.getServiceQueueList().add(serviceQueue);
                    serviceQueue.enqueue(request);
                    System.out.println("Queue " + activeServiceQueue.getServiceQueueList().size() + serviceQueue);

                }

            for (int i = 0; i < activeServiceQueue.getServiceQueueList().size(); i++) {
                

                while (!activeServiceQueue.getServiceQueueList().get(counter).isFull()) {

                    if (!reqQueue.isEmpty()) {
                        request = reqQueue.dequeue().data;
                        System.out.println(request);
                        activeServiceQueue.getServiceQueueList().get(counter).enqueue(request);
                        System.out.println(activeServiceQueue.getServiceQueueList().get(counter));
                    } else {
                        System.out.println("No More requests to process");
                        break;
                    }

                }
                break;
            }

        }

//                   
    }
}

}
