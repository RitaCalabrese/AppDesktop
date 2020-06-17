/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop;

import java.util.EventListener;

/**
 *
 * @author luisa
 */
public interface EventHandler {
    
    public void addButtonApprovedListener(EventListener el);
    public void addButtonDeleteListener(EventListener el);
    public void addMouseClickListener(EventListener el);
    public void addAnotherMouseClickListener(EventListener el);
    public void addActionOneListener(EventListener el);
    public void addRefreshListener(EventListener el);
    public void addAscendingOrderListener(EventListener el);
    public void addDescendingOrderListener(EventListener el);
    public void addCheckOrderListener(EventListener el);
    public void addCheckOrderTwoListener(EventListener el);
    public void addCheckOrderThreeListener(EventListener el);
}
