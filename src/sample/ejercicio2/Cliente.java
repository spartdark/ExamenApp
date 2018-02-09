package sample.ejercicio2;

/**
 * @author vladimirsaldivar
 * @project HipotenusaXXX 2018
 * ...:::vsaldivarm@gmail.com:::...
 **/
public class Cliente {
    CuentaBancaria cuenta;
    String nombre;

    public Cliente(String nombre, CuentaBancaria cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public String obtenerDatosCuenta() {
        return "Nombre: " + this.nombre + " " + this.cuenta.toString();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cuenta=" + cuenta +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
