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
public class Stack {
    NodeStack head;
    
    //public void push(); pop(); 
    
    public Entity peek() {
        return head.data;
    }
}
