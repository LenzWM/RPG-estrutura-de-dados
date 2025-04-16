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
public class NodeStack {
    NodeStack prev;
    Entity data;
    
    public NodeStack(Entity data) {
        this.data = data;
        this.prev = null;
    }
}
