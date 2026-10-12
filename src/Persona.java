import java.time.LocalDate;
import java.util.Objects;

public class Persona {

    //Atributos
    private String nombre;
    private String apellidos;
    private Pasaporte pasaporte; //Composición: el pasaporte nace y vive dentro de la persona
    private Mascota mascota;     //Agregación: la mascota existe por su cuenta y se puede compartir

    //Métodos
    //Constructor
    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    //Getters
    public String getNombre() { return nombre; }

    public String getApellidos() { return apellidos; }

    public String getNombreCompleto() { return nombre + " " + apellidos; }

    public Pasaporte getPasaporte() { return pasaporte; }

    public Mascota getMascota() { return mascota; }

    //Setters
    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona otra = (Persona) obj;
        return nombre.equals(otra.nombre) && apellidos.equals(otra.apellidos);
    }

    @Override
    public int hashCode() { return Objects.hash(nombre, apellidos); }

    //toString()
    @Override
    public String toString() {
        return "Persona{nombre=" + nombre + ", apellidos=" + apellidos
                + ", pasaporte=" + pasaporte + ", mascota=" + mascota + "}";
    }

    //Pasaporte nuevo con vigencia de 10 años a partir de hoy
    public void sacarPasaporte(String numero, String nacionalidad) {
        LocalDate hoy = LocalDate.now();
        sacarPasaporte(numero, nacionalidad, hoy, hoy.plusYears(10));
    }

    public void sacarPasaporte(String numero, String nacionalidad, LocalDate fechaEmision, LocalDate fechaVencimiento) {
        this.pasaporte = new Pasaporte(numero, nacionalidad, fechaEmision, fechaVencimiento);
        System.out.println(getNombreCompleto() + " sacó su pasaporte.");
    }

    public boolean tomarVuelo(String pais) {
        if (pasaporte != null && pasaporte.isEstaVigente()) {
            System.out.println(getNombreCompleto() + " toma un vuelo a " + pais + ".");
            return true;
        }
        System.out.println(getNombreCompleto() + " no puede tomar el vuelo, ya que su pasaporte no está vigente.");
        return false;
    }

    //Funciona como setter de la mascota
    public void adoptarMascota(Mascota mascota) {
        this.mascota = mascota;
        System.out.println(getNombreCompleto() + " adoptó a " + mascota.getNombre() + ".");
    }

    public void jugar() {
        if (mascota == null) {
            System.out.println(getNombreCompleto() + " no tiene mascota con quien jugar.");
            return;
        }
        System.out.println(getNombreCompleto() + " juega con " + mascota.getNombre()
                + ", su " + mascota.getEspecie() + ".");
    }

    //Dependencia: la máquina llega como parámetro, no es atributo de Persona
    public boolean soldar(MaquinaSoldar maquina, String metal) {
        if (maquina == null) {
            System.out.println(getNombreCompleto() + " no puede soldar sin una máquina.");
            return false;
        }
        System.out.println(getNombreCompleto() + " intenta soldar " + metal + ".");
        return maquina.soldar(metal);
    }
}