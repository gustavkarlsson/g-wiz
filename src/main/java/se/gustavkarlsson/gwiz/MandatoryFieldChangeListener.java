/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.gustavkarlsson.gwiz;

import java.util.EventListener;

/**
 *
 * @author Adriano Henrique Rossette Leite (contact@adrianohrl.tech)
 */
public interface MandatoryFieldChangeListener extends EventListener {
    
    /**
     * This method notifies when a mandatory field of the wizard page has changed.
     * It is used to update the wizard buttons.
     * 
     * @param evt the component that has changed.
     */
    public abstract void mandatoryFieldChanged(MandatoryFieldChangeEvent evt);
    
}
