import java.util.Iterator;

/**
 * @authors IkerAb JorgePu JuanM
 * Se define la clase EE (Estructura Enlazada). Tiene un único atributo que es la
 * dirección o referencia al primer nodo.
 */

public class EE_Doble <T extends Comparable<T>>  implements Iterable<T>{
    private NodoD <T> primero;
    private NodoD <T> ultimo;

    // Se construye un objeto tipo EE, indicando que la estructura está vacía inicialmente.
    public EE_Doble () {
        primero = null;
        ultimo = null;
    }

    // Regresa true si la estructura está vacía (no tiene ningún nodo).
    public boolean estáVacía() {
        return primero == null;
    }

    // Regresa un iterador sobre la estructura enlazada, partiendo del primer nodo.
    public Iterator<T> iterator() {
        return new IteradorEE_D<T> (primero);
    }

    // Agrega un dato al final de la estructura enlazada. 
    public void agregaFinal(T dato) {
        NodoD <T> nuevo = new NodoD <T> (dato);
        if (estáVacía()){
            primero = nuevo;
            ultimo = nuevo;
        }
        
        else{
            NodoD <T> auxiliar = primero;
            while (auxiliar.getSig() != null)
                auxiliar = auxiliar.getSig();
            auxiliar.setSig(nuevo);
            ultimo = nuevo;
            ultimo.setAnt(auxiliar);
        }
    }

    //Agrega un elemento al principio de la estructura enlazada.
   public void agregaPrincipio(T dato) {
        NodoD<T> nuevo = new NodoD<>(dato);
        if (estáVacía())
            primero = ultimo = nuevo;
         else{
            nuevo.setSig(primero);
            primero.setAnt(nuevo);
            primero = nuevo;
        }
    }
    
    public T getPrimero() {
        return primero.getDato();
    }

    public T getUltimo() {
        return ultimo.getDato();
    }

    /* Elimina el primer nodo de la estructura, regresando el dato que almacena.
     * Si la estructura está vacía lanza una excepción.
     */
    public T quitaPrimero() {
        if (estáVacía())
            throw new ExcepciónColecciónVacía("No hay elementos");
        else {
            T eliminado;
            NodoD <T> auxiliar = primero;
            eliminado = primero.getDato();
            primero = primero.getSig();
            auxiliar.setSig(null);
            return eliminado;
        }
    }

    /* Si el dato está en la estructura de datos, se elimina el nodo que almacena 
     * al dato y regresa true. En caso contrario, regresa false.
     * Si la estructura está vacía lanza una excepción.
     */
    public boolean quita(T dato){
        boolean resp = false;

        if (estáVacía())
            throw new ExcepciónColecciónVacía("No hay elementos");
        else
            if (dato.equals(primero.getDato()))
                quitaPrimero();
            else {
                NodoD<T> actual = primero;
                NodoD<T> anterior = primero;
                while (actual != null && !actual.getDato().equals(dato)){
                    anterior = actual;
                    actual = actual.getSig();
                }
                if (actual != null){ // El dato está en la estructura enlazada.
                    resp = true;
                    anterior.setSig(actual.getSig());
                    actual.setAnt(null);
                    actual.setSig(null);
                }
            }
        return resp;
    }

    /* Elimina el último nodo de la estructura y regresa el dato que almacena.
     * Si la estructura está vacía lanza una excepción.
     */
    public T quitaUltimo(){
        if (estáVacía())
            throw new ExcepciónColecciónVacía("No hay elementos");
        else{
            NodoD <T> actual = primero;
            NodoD <T> anterior = primero;
            while (actual.getSig() != null){
                anterior = actual;
                actual = actual.getSig();
            }
            T dato = actual.getDato();
            if (primero == actual) // Hay un solo nodo 
                primero = null; // La estructura queda vacía
            else {
                anterior.setSig(null);
                actual = null;
            }
            return dato;
        }
    }
    
    /* Busca el dato en la estructura enlazada. Regresa true en caso de éxito y 
     * false si no lo encuentra.
     */
    public boolean busca(T dato){
        boolean resp = false;
        NodoD<T> auxiliar = primero;
        while (auxiliar != null && !auxiliar.getDato().equals(dato))
            auxiliar = auxiliar.getSig();
        if (auxiliar != null)
            resp = true;
        return resp;
    }
    
    /* Regresa el dato del nodo que ocupa la posición num dentro de la estructura
     * enlazada. Si la estuctura está vacía o tiene un número de nodos menor a num
     * entonces regresa null.
     */    
    public T getElemento(int num){
        NodoD <T> auxiliar = primero;
        int cont = 1;
        T elemento;
        
        while (auxiliar != null && cont < num){
            auxiliar = auxiliar.getSig();
            cont++;
        }
        if (cont < num || auxiliar == null)
            elemento = null;
        else 
            elemento = auxiliar.getDato();
        return elemento;
    }

    public boolean  eliminaAnteriorA(T info){
        if (estáVacía())
            return false;
        else
            if (!busca(info))
                return false;
            else{
                NodoD <T> actual = primero;
                NodoD <T> anterior = primero;
                NodoD <T> aborrar = primero;
                
                while(!actual.getDato().equals(info)){
                    actual = actual.getSig();
                if (actual == primero)
                    return false;
                else{
                    anterior = actual.getAnt();
                    if (anterior == primero){
                        primero.setSig(null);
                        primero = actual;
                        actual.setAnt(null);
                    }
                    else{
                        
                    
                        anterior = anterior.getAnt();
                        aborrar = anterior.getSig();
                        anterior.setSig(actual);
                        actual.setAnt(anterior);
                        aborrar.setAnt(null);
                        aborrar.setSig(null);
                    }
                }
                
            }
        }
            return true;    
    }

   public void insertaOrdenado(T dato) {
        NodoD<T> nuevo = new NodoD<>(dato);

        if (estáVacía()) { 
            agregaPrincipio(dato);
            return;
        }

        if (dato.compareTo(primero.getDato()) < 0) {
            nuevo.setSig(primero);
            primero.setAnt(nuevo);
            primero = nuevo;
            return;
        }

        if (dato.compareTo(ultimo.getDato()) > 0) {
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            ultimo = nuevo;
            return;
        }

        NodoD<T> actual = primero.getSig();
        while (actual != null && actual.getDato().compareTo(dato) < 0) {
            actual = actual.getSig();
        }

         if (actual == null) {
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            ultimo = nuevo;
            return;
        }
        
        // insertar antes de 'actual'
        NodoD<T> anterior = actual.getAnt();
        nuevo.setAnt(anterior);
        nuevo.setSig(actual);
        anterior.setSig(nuevo);
        actual.setAnt(nuevo);
    }

    public boolean reordenar(T elemento, T elementoActualizado) {
        boolean bandera = quita(elemento);
        if (!bandera) return false;
        insertaOrdenado(elementoActualizado);
        return true;
    }
 
    public int eliminaTodosRepetidosOrdenado(){
        int tot_eliminados = 0;
        if (primero == null || primero.getSig() == null)
            return 0;
        else{
            NodoD <T> actual = primero;
            NodoD <T> anterior = primero;
            T elemento = primero.getDato();
            actual = primero.getSig();
            while (actual != null){
                if (elemento == actual.getDato()){
                    tot_eliminados++;
                    anterior.setSig(actual.getSig());
                    actual.setSig(null);
                    actual = anterior.getSig();
                }
                else{
                    elemento = actual.getDato();
                    anterior = actual;
                    actual = actual.getSig();
                }
            }
            return tot_eliminados;  
            }
            
    }
    
    // Regresa en forma de cadena la información almacenada en los nodos.
    public String toString(){
        Iterator <T> it = iterator();
        StringBuilder cad = new StringBuilder();
        
        while (it.hasNext())
            cad.append(it.next() + " ");
        return cad.toString();
    }
}

