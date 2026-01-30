public class ExcepciónColecciónVacía extends RuntimeException{

    public ExcepciónColecciónVacía(){
        super("Colección vacía");
    }

    public ExcepciónColecciónVacía(String mensaje){
        super(mensaje);
    }
}