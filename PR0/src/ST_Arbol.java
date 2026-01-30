/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @authors IkerAb JorgePu JuanM
 * Esta Clase modela un arbol binario de nodos que guardan como informacion a pacientes. Siguiendo una lógica de que los pacientes 
 * con mayor prioridad se van a la izquierda y los pacientes de menor prioridad se van a la derecha. Tiene como único atributo la
 * raíz que es el nodo que enlaza a los demas.
 */

public class ST_Arbol {
    private NodoArbol raiz;
    
    public ST_Arbol(){
       raiz=null; 
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    /*
    El método recorre el arbol comparando el nuevo dato para ver donde insertar ese nuevo dato según la lógica del 
    arbol. Una vez que encuentra la rama que le corresponde apuntando a null se agrega.
    */
    public void alta(Paciente dato){
        NodoArbol nuevo= new NodoArbol(dato);
        //Si el arbol está vacío
        if(raiz==null){
            setRaiz(nuevo);
            return;
        }
        NodoArbol actual= raiz;
        NodoArbol padre=null;
        //SI el arbol no está vacío recorre las ramas comparando el valor de prioridad
        while(actual!=null){
            padre= actual;
            if(dato.getPrioridad()<padre.getPaciente().getPrioridad())
                actual=actual.getIzq();
            else
                actual=actual.getDer();
            }
        if(dato.getPrioridad()>=padre.getPaciente().getPrioridad())
            padre.setDer(nuevo);
        else 
            padre.setIzq(nuevo);      
    }
    
    /*
    El método de quitar, busca el dato que se le meta para quitarlo del árbol 
    y devolverlo como parte del método.
    */
    public Paciente quitar(Paciente dato){
        if(raiz==null) return null;
        NodoArbol actual=raiz;
        NodoArbol padre=null;
        //Busca al paciente comprandolo desde la raíz 
        while(actual!=null && !dato.equals(actual.getPaciente())){
            padre=actual;
            if(actual.getPaciente().getPrioridad()>dato.getPrioridad())
                actual=actual.getIzq();
             else
                actual= actual.getDer();                        
        }
       // En caso que no se encuentre el dato a eliminar regresa nulo 
        if(actual==null) return null;
         Paciente paciente= actual.getPaciente();
        
        //Caso que el dato está en la raíz 
            if(padre==null){
                if(actual.getIzq()==null && actual.getDer()==null){
                    raiz=null;
                } else 
                    if(actual.getIzq()==null){
                        raiz=actual.getDer();
                    }else
                        if(actual.getDer()==null){
                            raiz=actual.getIzq();
                        return paciente;
            }else{
            
            //Caso que tiene 2 hijos
            NodoArbol aux1=actual.getDer();
            NodoArbol aux2=null;
            
                while(aux1.getIzq()!=null){
                    aux2=aux1;
                    aux1=aux1.getIzq();
                }
                     if(aux2!=null){
                         aux2.setIzq(aux1.getDer()); 
                         aux1.setDer(actual.getDer());        
                     }
                         aux1.setIzq(actual.getIzq()); 
                         raiz= aux1;
                        
                  
            }
            return paciente;
            } 
            boolean ladoD=padre.getDer()==actual;
                    
       if (actual.getDer() != null && actual.getIzq() != null) {
            NodoArbol aux1=actual.getDer();
            NodoArbol aux2=null;
        while (aux1.getIzq() != null) {
            aux2 = aux1;
            aux1 = aux1.getIzq();
        }

        if (aux2 != null) {
            aux2.setIzq(aux1.getDer());
            aux1.setDer(actual.getDer());
        }
        aux1.setIzq(actual.getIzq());
        if (ladoD) padre.setDer(aux1);
        else padre.setIzq(aux1);
        
        return paciente;
                      
            //caso que solo tiene 1 hijo  
        }else 
           if(actual.getDer()!=null || actual.getIzq()!=null){
                    if(actual.getDer()!=null){
                        if(ladoD)
                            padre.setDer(actual.getDer());
                        else
                            padre.setIzq(actual.getDer());
                    }else{
                        if(ladoD)
                            padre.setDer(actual.getIzq());
                        else
                            padre.setIzq(actual.getIzq());
                    }
                    return paciente;
                }
            //caso que es una hoja
            else{
                if(ladoD)
                   padre.setDer(null);
                else
                    padre.setIzq(null);
                
                return paciente;
                } 
    }

    public String baja(){
        if(raiz==null)
            return "el árbol está vacío";
        
        NodoArbol actual=raiz;
        if(actual.getIzq()!=null){
            while(actual.getIzq()!=null)
                actual=actual.getIzq();
                        
        }    
        Paciente dato=quitar(actual.getPaciente());
        return "el paciente atendido fue "+dato.toString();
    }

    public String buscarPaciente(String nombre) {
        Paciente p = buscarPorNombreRec(raiz, nombre);
        if (p != null) {
            return "Paciente encontrado: " + p.getNombre() + ", prioridad=" + p.getPrioridad();
        } else {
            return "No se encontró al paciente con nombre: " + nombre;
        }
    }

    private Paciente buscarPorNombreRec(NodoArbol nodo, String nombre) {
        if (nodo == null) return null;
        if (nodo.getPaciente().getNombre().equalsIgnoreCase(nombre)) {
            return nodo.getPaciente();
        }
        Paciente izq = buscarPorNombreRec(nodo.getIzq(), nombre);
        if (izq != null) return izq;
        return buscarPorNombreRec(nodo.getDer(), nombre);
    }
    
    /*
    El método cambiar Prioridad busca al paciente que se le va a cambiar la prioridad para usarlo como parametro 
    para el método quitar y lo vuelve a meter al arbol con el método alta.
    */
    public void cambiarPrioridad(String nombre, int nuevaPrioridad){
        Paciente p = buscarPorNombreRec(raiz, nombre);
        if (p != null){
            p = quitar(p);
            p.setPrioridad(nuevaPrioridad);
            alta(p);
        }
    }
    
}