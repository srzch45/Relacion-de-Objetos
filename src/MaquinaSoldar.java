import java.util.Arrays;
import java.util.Objects;

public class MaquinaSoldar {

    //Atributos
    private String marca;
    private String modelo;
    private double potencia;
    private String[] metalesSoldables;

    //Métodos
    //Constructor
    public MaquinaSoldar(String marca, String modelo, double potencia, String[] metalesSoldables) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.metalesSoldables = metalesSoldables.clone();
    }

    //Getters
    public String getMarca() { return marca; }

    public String getModelo() { return modelo; }

    public double getPotencia() { return potencia; }

    public String[] getMetalesSoldables() { return metalesSoldables.clone(); }

    //Setters
    public void setMarca(String marca) { this.marca = marca; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public void setPotencia(double potencia) { this.potencia = potencia; }

    public void setMetalesSoldables(String[] metalesSoldables) { this.metalesSoldables = metalesSoldables.clone(); }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MaquinaSoldar otra = (MaquinaSoldar) obj;
        return marca.equals(otra.marca) && modelo.equals(otra.modelo);
    }

    @Override
    public int hashCode() { return Objects.hash(marca, modelo); }

    //toString()
    @Override
    public String toString() {
        return "MaquinaSoldar{marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia
                + ", metalesSoldables=" + Arrays.toString(metalesSoldables) + "}";
    }

    //Revisa si el metal está entre los que la máquina puede soldar
    private boolean puedeSoldar(String metal) {
        for (String m : metalesSoldables) {
            if (m.equalsIgnoreCase(metal)) return true;
        }
        return false;
    }

    public boolean soldar(String metal) {
        if (puedeSoldar(metal)) {
            System.out.println("La máquina de soldar " + marca + " " + modelo + " solda el " + metal + ".");
            return true;
        }
        System.out.println("La máquina de soldar " + marca + " " + modelo + " no puede soldar " + metal + ".");
        return false;
    }
}