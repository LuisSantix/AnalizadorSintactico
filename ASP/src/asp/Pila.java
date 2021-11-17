
package asp;

import java.util.Stack;

/**
 *
 * @author LuisSantix
 */

public class Pila {
    Stack<String> pila = new Stack<>();
    
    public Pila(){
        pila.push("$");
        pila.push("E");
    }
    
    @Override
    public String toString(){
        return ""+pila;
    }
}
