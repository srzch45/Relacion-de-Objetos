import java.util.Objects;

public class Mascota {

    //Atributos
    private String nombre;
    private String especie;
    private int edad;

    //Métodos
    //Constructor
    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    //Getters
    public String getNombre() { return nombre; }

    public String getEspecie() { return especie; }

    public int getEdad() { return edad; }

    //Setters
    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setEspecie(String especie) { this.especie = especie; }

    public void setEdad(int edad) { this.edad = edad; }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mascota otra = (Mascota) obj;
        return edad == otra.edad && nombre.equals(otra.nombre) && especie.equals(otra.especie);
    }

    @Override
    public int hashCode() { return Objects.hash(nombre, especie, edad); }

    //toString()
    @Override
    public String toString() {
        return "Mascota{nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + "}";
    }
}