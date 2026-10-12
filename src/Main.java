import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        //Objetos
        Persona p1 = new Persona("Romario", "Salas Cerdas");
        Persona p2 = new Persona("Laura", "Vargas Mora");
        Mascota mascota = new Mascota("Rocky", "perro", 4);
        MaquinaSoldar maquina = new MaquinaSoldar("Miller Electric", "ME123X", 3500,
                new String[]{"hierro", "acero", "aluminio"});

        //Pasaportes: uno vigente y uno vencido
        p1.sacarPasaporte("A1234567", "Costarricense");
        p2.sacarPasaporte("B7654321", "Costarricense",
                LocalDate.now().minusYears(12), LocalDate.now().minusYears(2));

        //Vuelos con resultado distinto
        System.out.println("\n--- Vuelos ---");
        p1.tomarVuelo("España");
        p2.tomarVuelo("México");

        //Ambas personas comparten la misma mascota
        System.out.println("\n--- Mascota compartida ---");
        p1.adoptarMascota(mascota);
        p2.adoptarMascota(mascota);
        p1.jugar();
        p2.jugar();
        System.out.println("¿Comparten la misma mascota? " + (p1.getMascota() == p2.getMascota()));

        //Una persona suelda dos veces, con resultado distinto
        System.out.println("\n--- Soldadura ---");
        p1.soldar(maquina, "hierro");
        p1.soldar(maquina, "titanio");

        //toString
        System.out.println("\n--- toString ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(maquina);
    }
}