public class NodoD <T>{
    private T dato;
    private NodoD<T> sig;
    private NodoD<T> ant;

    // Al construir un objeto tipo Nodo, éste no referencia a ningún otro nodo.
    public NodoD() {
        sig = null;
        ant=null;
    }

    // Se construye un objeto, asignándole valor al dato.
    public NodoD(T dato) {
        this.dato = dato;
        sig = null;
        ant=null;
    }

    // Regresa el dato almacenado.
    public T getDato() {
        return dato;
    }

    // Regresa la dirección del nodo a quien referencia.
    public NodoD<T> getSig() {
        return sig;
    }

    // Asigna un nuevo valor al dato.
    public void setDato(T dato) {
        this.dato = dato;
    }

    /* Asigna la dirección de un nodo, de tal manera que ahora el nodo que invoca
     * al método referencia a otro nodo.
     */
    public void setSig(NodoD<T> sig) {
        this.sig = sig;
    }

    public NodoD<T> getAnt() {
        return ant;
    }

    public void setAnt(NodoD<T> ant) {
        this.ant = ant;
    }

    // Regresa en forma de cadena el dato almacenado.
    public String toString() {
        return "Dato: " + dato;
    }
}