/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MEMO0464
 */
public class Cola {
    protected Prioridad obja[] = new Prioridad[5];
    protected int ini;
    protected int fin;
    
    /*
    Constructor
    */
    public Cola (int tamano){
        obja = new Prioridad[tamano];
        ini = -1;
        fin = -1;
    }
    
    public boolean insertar(char dato, int nivel){
        if(estaColallena()) return false;
        fin++;
        obja[fin] = new Prioridad (dato , nivel); 
        
        if(ini == -1){
            ini = 0;
        }
        if(ini<fin){
        analizarp();
        }
        return true;   
        
    }
    
    public boolean eliminar(){
        if(estaColavacia()){ return false;}
        
        if(hayunSoloDato()){
            ini = -1;
            fin = -1;
            return true;
        }
        ini++;
        return true;
    }
    public String mostrar(){
        String cad="";  
        if(ini == -1 && fin == -1){
            return cad="";
        }else{
        for(int i=ini; i<=fin; i++){
            cad+="["+obja[i]+"]";
        }
        return cad;
       }
    }
    
    protected boolean estaColallena(){
        return fin == obja.length-1;
    }
    protected boolean estaColavacia(){
        return ini == -1 && fin == -1;
    }
    protected boolean hayunSoloDato(){
        return ini == fin;
    }
    protected void analizarp(){
        int t2, t1;
        Prioridad o[] = new Prioridad[1];
        for(t2 = fin-1, t1 = fin; t2 >= ini; t2--, t1--){   
            if(obja[t1].nivel>obja[t2].nivel){
                   o[0]=obja[t1];
                   obja[t1]=obja[t2];
                   obja[t2]=o[0];
                }
        }
    }
    boolean insertar(Prioridad dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
