import java.time.LocalDate;

public class Pasaporte {

    //Atributos
    private String numero;
    private String nacionalidad;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private boolean estaVigente;

    //Métodos
    //Constructor
    public Pasaporte(String numero, String nacionalidad, LocalDate fechaEmision, LocalDate fechaVencimiento) {
        if (fechaVencimiento.isBefore(fechaEmision)) {
            throw new IllegalArgumentException("La fecha de vencimiento no puede ser anterior a la de emisión.");
        }
        this.numero = numero;
        this.nacionalidad = nacionalidad;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        actualizarVigencia();
    }

    //Getters
    public String getNumero() { return numero; }

    public String getNacionalidad() { return nacionalidad; }

    public LocalDate getFechaEmision() { return fechaEmision; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }

    public boolean isEstaVigente() {
        actualizarVigencia();
        return estaVigente;
    }

    //Setters
    public void setNumero(String numero) { this.numero = numero; }

    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
        actualizarVigencia();
    }

    //equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return numero.equals(((Pasaporte) obj).numero);
    }

    @Override
    public int hashCode() { return numero.hashCode(); }

    //toString()
    @Override
    public String toString() {
        return "Pasaporte{numero=" + numero + ", nacionalidad=" + nacionalidad
                + ", fechaEmisión=" + fechaEmision + ", fechaVencimiento=" + fechaVencimiento
                + ", estaVigente=" + isEstaVigente() + "}";
    }

    //Recalcula si el pasaporte sigue vigente según la fecha actual
    public void actualizarVigencia() {
        this.estaVigente = fechaVencimiento.isAfter(LocalDate.now());
    }
}