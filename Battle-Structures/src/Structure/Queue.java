/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structure;

import model.entities.Entity;

/**
 *
 * @author leona
 */
public class Queue {
    NodeQueue head;
    
    public Queue() {
        this.head = null;
    }
    
    public void enqueue(Entity data){
        //
    }
    public Entity dequeue(){
        Entity temp = head.data;
        return temp;
    }
    
}
