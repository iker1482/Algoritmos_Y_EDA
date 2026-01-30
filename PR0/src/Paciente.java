public class Paciente implements Comparable<Paciente> {
    private String nombre = null;
    private int prioridad = -1;

    public Paciente() {
    }

    public Paciente(String nom, int prio) {
        nombre = nom;
        prioridad = prio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public void setPrioridad(int prio) {
        this.prioridad = prio;
    }

    @Override
    public int compareTo(Paciente otro) {
        // Menor prioridad = mayor urgencia
        return Integer.compare(this.prioridad, otro.prioridad);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Paciente paciente = (Paciente) obj;
        return prioridad == paciente.prioridad &&
               (nombre != null ? nombre.equals(paciente.nombre) : paciente.nombre == null);
    }

    @Override
    public String toString() {
        return   "nombre='" + nombre + '\'' +  ", prioridad=" + prioridad;
    }
}