
package asp;

/**
 *
 * @author LuisSantix
 */
public class Derivacion {
    private String noTerminal="", instruccion="";
    
    public Derivacion(String noTerminal, String instruccion){
        this.noTerminal = noTerminal;
        this.instruccion = instruccion;
    }
    
    public String obtNoTerminal(){
        return noTerminal;
    }
    
    public String obtInstruccion(){
        return instruccion;
    }
    
    public String obtDerivacion(){
        return noTerminal+">"+instruccion;
    }
    
    @Override
    public String toString(){
        return "El simbolo no terminal es: "+noTerminal+"\nLa produccion es: "+instruccion;
    }
}
