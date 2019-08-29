/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.gustavkarlsson.gwiz;

import java.awt.Component;
import java.util.EventObject;

/**
 *
 * @author Adriano Henrique Rossette Leite (contact@adrianohrl.tech)
 */
public class MandatoryFieldChangeEvent extends EventObject {

    public MandatoryFieldChangeEvent(Component component) {
        super(component);
    }
    
    /**
     * Get the component that has changed.
     * 
     * @return the component that represents the mandatory field changed.
     */
    public Component getComponent() {
        return (Component) super.getSource();
    }
    
}
