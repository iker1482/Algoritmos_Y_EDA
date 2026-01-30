/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @authors IkerAb JorgePu JuanM
 * Esta clase crea los nodos de la estructura del arbol. Tiene 3 atributos 2 son apuntadores y los el tercero guarda el 
 * dato que guarda el nodo. 
 */
    
public class NodoArbol {
    NodoArbol izq;
    NodoArbol der; 
    Paciente paciente;
   
    public NodoArbol(Paciente paciente){
        this.paciente=paciente;
        izq=null;
        der=null;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public boolean hasNext(NodoArbol nodo){
       return nodo.getDer()!=null || nodo.getIzq()!=null;   
    }
    
}