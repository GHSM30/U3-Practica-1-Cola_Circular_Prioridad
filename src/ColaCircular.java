/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MEMO0464
 */
public class ColaCircular extends Cola {
    public ColaCircular(int tamano){
        super(tamano);
    }
    @Override
    public boolean insertar(char dato, int nivel){
        //MODO CIRCULAR
        if(modoCircular()){
            if(circularllena())return false;
                fin++;
                obja[fin]= new Prioridad(dato , nivel);
                analizarcp();
                return true;    
                
        }
        //MODO NORMAL
        boolean res = super.insertar(dato, nivel); 
        if(res) return true;
        if(ini==0)return false; 
        fin = 0;
        obja[fin] = new Prioridad (dato,nivel);
        return true;
        
    }
    @Override
    public boolean eliminar(){
        boolean resp = super.eliminar();
        if(ini == obja.length) ini = 0;
        return resp;
        
    }
    public String mostrarC(){
        if(ini == -1){
            return "COLA VACIA";
        }
        String cad = "";
        if(modoCircular()){
            for (int i= ini; i<obja.length; i++){
                cad+= "["+i+"] = "+ obja[i]+"\n";
            }
            for (int i=0; i<=fin; i++){
                cad+= "["+i+"] = "+obja[i]+"\n";
            }
        }else{
            for(int i= ini; i<=fin; i++){
                cad+= "["+i+"] = "+obja[i]+"\n";
            }
        }
        return cad;
    }
    protected boolean circularllena(){
        return (fin+1)==ini;
    }
    protected boolean modoCircular(){
        return fin<ini;
    }
    
   protected void analizarcp(){
        int t2, t1;
        Prioridad o[] = new Prioridad[1];
        for(t2 = fin-1, t1 = fin; t2 < fin; t2--, t1--){ 
            if(t1==0){t2=obja.length-1;}
            if(t1==-1){t1=obja.length-1; t2= t1-1;}
            if(obja[t1].nivel>obja[t2].nivel){
                   o[0]=obja[t1];
                   obja[t1]=obja[t2];
                   obja[t2]=o[0];
                }
        }
   }
}
