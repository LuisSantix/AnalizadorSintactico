
package asp;

import java.util.ArrayList;

/**
 *
 * @author LuisSantix
 */
public class TblaASP {       
    ArrayList<Derivacion> listaDerivacion = new ArrayList<>();
    boolean vacio = false;
    /*Los numeros con los que se llena el array index son modificados a conveniencia de mi tabla, el -1 significa que en esa celda esta vacia*/
    int[][] index = {{0,-1,-1,0,-1,-1},{-1,1,-1,-1,2,2},{3,-1,-1,3,-1,-1},{-1,4,5,-1,4,4},{6,-1,-1,7,-1,-1}};
    
    public TblaASP(){
        /*Las derivaciones de la lista seran modificadas segun sea el caso de mi tabla*/
        listaDerivacion.add(new Derivacion("E","TE'"));     //0 E
        listaDerivacion.add(new Derivacion("E'","+TE'"));   //1 E'
        listaDerivacion.add(new Derivacion("E'","0"));      //2 E'
        listaDerivacion.add(new Derivacion("T","FT'"));     //3 T
        listaDerivacion.add(new Derivacion("T'","0"));      //4 T'
        listaDerivacion.add(new Derivacion("T'","*FT'"));   //5 T'
        listaDerivacion.add(new Derivacion("F","id"));      //6 F
        listaDerivacion.add(new Derivacion("F","(E)"));     //7 F
    }
    
    public Derivacion obtener(String a, String b){
        int[] f = {-1,-1};
        f = transformar(a, b);
        
        if(index[f[0]][f[1]]!=-1){
            vacio = false;
        }else{
            System.out.println("El elemento dentro de la tabla es: [VACIO]");
            vacio = true;
        }
        return listaDerivacion.get(index[f[0]][f[1]]);
    }
    
    public int[] transformar(String a, String b){
        int[] coord = {-1,-1};
        String aux;
        for(int i=0; i<2;i++){
            if(i==0){ aux = a;
            }else { aux = b;}
            
            switch(aux){
                case "E":  coord[0]=0; break;
                case "E'": coord[0]=1; break;
                case "T":  coord[0]=2; break;
                case "T'": coord[0]=3; break;
                case "F":  coord[0]=4; break;
                case "id": coord[1]=0; break;
                case "+":  coord[1]=1; break;
                case "*":  coord[1]=2; break;
                case "(":  coord[1]=3; break;
                case ")":  coord[1]=4; break;
                case "$":  coord[1]=5; break; /* El signo de $ es el delimitador para este ejemplo, cambiarlo en dado caso sea diferente.*/
            }
        }
        return coord;
    }
    
    public String[] espejo(String deriv){
        int cant = deriv.length();
        int contadas=0;
        String[] addPila;
        String temp = "";
        for(int i=cant;0<i;i--){
            temp = ""+deriv.charAt(i-1);
            if(temp.equals("'") || temp.equals("d")){
                temp ="";
                i--;
            }
            contadas++;
        }
        addPila = new String[contadas];
        contadas =0;
        for(int i=cant;0<i;i--){
            temp = ""+deriv.charAt(i-1);
            if(temp.equals("'") || temp.equals("d")){
                temp ="";
                i--;
                temp = ""+deriv.charAt(i-1);
                temp += ""+deriv.charAt(i);
            }
            addPila[contadas] = temp;
            contadas++;
        }
        return addPila;
    }
}
