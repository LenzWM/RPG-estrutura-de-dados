/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.entities.Entity;
import model.entities.PlayerCharacter;
import structures.LinkedList;
import structures.Node;


public class BattlePvp extends Battle{
    
    public BattlePvp(LinkedList participants) {
        super(participants);
    }
    
    @Override
    public boolean isBattleOver(){
        Node<Entity> current = getParticipants().getHead();
        int counter = 0;
        while(current != null){
            if (current.data.isAlive()){
                counter++;
            }
            
            current = current.prev;
        }
        
        return counter == 0 || counter == 1;
    }
    
}
