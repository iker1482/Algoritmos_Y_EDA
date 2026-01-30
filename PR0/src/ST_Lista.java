import java.util.Iterator;

public class ST_Lista{
    private EE_Doble<Paciente> lista;

    public ST_Lista() {
        lista=new EE_Doble<Paciente>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lista == null) ? 0 : lista.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ST_Lista other = (ST_Lista) obj;
        if (lista == null) {
            if (other.lista != null)
                return false;
        } else if (!lista.equals(other.lista))
            return false;
        return true;
    }

   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("****** Sistema de Triaje ********\n");
        int i = 1;
        for (Paciente p : lista) {
            sb.append(i++).append(". ").append(p.getNombre()).append(" (prioridad ").append(p.getPrioridad()).append(")\n");
        }
        return sb.toString();
    }

    public void alta(Paciente pa){
        if(lista.estáVacía()){
            lista.agregaPrincipio(pa);
        }
        else{
            lista.insertaOrdenado(pa);
        }
    }

    public String baja(){
        if (lista.estáVacía()){
            return "Lista vacía";
        }
        else{
            Paciente tmp=new Paciente();
            tmp=lista.quitaPrimero();
            return "El paciente atendido fue"+tmp.toString();
        }
    }

    public String buscarPaciente(String nom){
        boolean bandera = false;
        String res=" No encontramos la persona busca de nuevo";
        Iterator<Paciente> it = lista.iterator();
        while (it.hasNext() && !bandera) {
            Paciente tmp=new Paciente();
            tmp=it.next();
            if(nom==tmp.getNombre()){
                bandera=true;
                res="tu paciente es "+tmp.getNombre()+" y su prioridad es "+tmp.getPrioridad();
            }
        }
        return res;
    }

    public void cambiarPrioridad(Paciente pa, int nuevaPrio) {
        if (!lista.estáVacía()){
            lista.quita(pa);                
            pa.setPrioridad(nuevaPrio);       
            lista.insertaOrdenado(pa); 
        }     
    }
    
}