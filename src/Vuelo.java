public class Vuelo {
    private String destino;
    private int asientosdisponibles;

    public Vuelo(String destino, int asientosdisponibles) {
        this.destino = destino;
        this.asientosdisponibles = asientosdisponibles;
    }

    public String getdestino() {
        return destino;
    }

    public int getasientosdisponibles() {
        return asientosdisponibles;
    }
    public void reservarasiento() throws faltadeasientosexcepcion {
        if (asientosdisponibles > 0) {
            asientosdisponibles--;
            System.out.println("Reserva exitosa para el vuelo a " + destino );
        } else {
            throw new faltadeasientosexcepcion("Lo sentimos, ya no hay asientos disponibles para el vuelo a " + destino);
        

}}}
