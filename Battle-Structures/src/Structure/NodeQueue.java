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
public class NodeQueue {
    NodeQueue next;
    Entity data;
    public NodeQueue(Entity data) {
        this.next = null;
        this.data = data;
    }
}
