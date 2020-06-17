
package appdesktop;

import java.util.EventListener;
/**
 *
 * @author Rita Calabrese
 * @author Luisa Esposito
 * 
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
