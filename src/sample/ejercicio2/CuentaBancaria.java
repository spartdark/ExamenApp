package sample.ejercicio2;

/**
 * @author vladimirsaldivar
 * @project HipotenusaXXX 2018
 * ...:::vsaldivarm@gmail.com:::...
 **/
public class CuentaBancaria {

    private String numero;
    private float saldo;

    public CuentaBancaria(String numero, float saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta: " +
                "numero = '" + numero + '\'' +
                ", saldo = " + saldo;
    }
}
