
package asp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LuisSantix
 */
public class ASP {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ASP n1 = new ASP();
        String a="";
        System.out.println("Ingrese las instrucciones, el delimitador ya esta contemplado: ");
        a = in.nextLine();a+="$";
        System.out.println();
        n1.entrada = n1.contarYllenar(a);
        n1.algoritmo();
    }
    
    public String[] contarYllenar(String w){
        String[] palabras;
        int cantidad =0;
        
        for(int i=0;i<w.length();i++){
            String temp = ""+w.charAt(i);
            if(temp.equals("i")){
                String temp2 = ""+w.charAt(i+1);
                if(temp2.equals("d")){
                    i++;
                }
            }
            cantidad++;
        }        
        palabras = new String[cantidad];
        cantidad =0;
        for(int i=0;i<w.length();i++){
            String temp = ""+w.charAt(i);
            if(temp.equals("i")){
                i++;
                temp+= w.charAt(i);
            }
            palabras[cantidad]=temp;
            cantidad++;
        }
        return palabras;
    }
    
    public void algoritmo(){
        int count =0;
        String ae = entrada[count];
        String x="", a="";
        boolean emitir=false;
        do{
            x = pila.pila.peek();
            a = ae;
            pilas.add(""+pila);
            String aux ="";
            for(int i=count;i<entrada.length;i++){
                aux+=entrada[i];
            }
            entradas.add(aux);
            if(emitir){
                salidas.add(ins.obtDerivacion());
                emitir = false;
            }else{
                salidas.add(" ");
            }
            String var="";
            if(x.length()==2){
                var = x+"  | ";
            }else{
                var = x+"   | ";
            }
            if(a.length()==2){
                var += a+"  |";
            }else{
                var += a+"   |";
            }
            lvariables.add(var);
            if(simbolos(x)){
                if(x.equals(a)){
                    pila.pila.pop();
                    count++;
                    if(entrada.length>count){
                        ae = entrada[count];
                    }
                }
            }else{
                ins = table.obtener(x,a);
                if(!table.vacio){
                    pila.pila.pop();
                    addPila = table.espejo(ins.obtInstruccion());
                    for(int i=0;i<addPila.length;i++){
                        if(!addPila[i].equals("0")){
                            pila.pila.push(addPila[i]);
                        }
                    }
                    emitir = true;
                }
            }
            
        }while(!x.equals("$"));
        System.out.printf("%-20s| %-10s| %-8s|","Pila","Entrada","Salida");
        System.out.print(" x   | a   |\n");
        for(int i=0;i<pilas.size();i++){
            System.out.printf("%-20s| %10s| %-8s|",pilas.get(i),entradas.get(i),salidas.get(i));
            System.out.print(" "+lvariables.get(i)+"\n");
        }
        System.out.println("Se trerminaron las instrucciones...");
    }
    
    public boolean simbolos(String a){
        boolean terminal = true;
        switch(a){
            case "E":
            case "E'":
            case "T":
            case "T'":
            case "F": terminal = false; break;
        }
        if(terminal){
            switch(a){
                case "id": 
                case "+":
                case "*":
                case "(":
                case ")": 
                case "$": terminal = true; break;
            }
        }
        return terminal;
    }
    
    TblaASP table = new TblaASP(); // Es donde se almacenan las derivaciones.
    Pila pila = new Pila(); //Son los simbolos terminales y no terminales que interactuan entre si.
    String[] entrada; //Es donde se almacenara a todas las simbolos de entrada de la cadena w
    Derivacion ins = new Derivacion("",""); //Aqui se agregara una produccion para poder hacer operaciones con ella
    String[] addPila; //Aqui se guardaran todas las intrucciones que se agregaran en la pila utilizando la funcion espejo
    
    //Los objetos ArrayList de tipo string se llenaran datos que son relevantes durante la ejecucion
    ArrayList<String> pilas = new ArrayList<>();
    ArrayList<String> entradas = new ArrayList<>();
    ArrayList<String> salidas = new ArrayList<>();
    ArrayList<String> lvariables = new ArrayList<>();
}


