package sample.ejercicio3;

/**
 * @author vladimirsaldivar
 * @project HipotenusaXXX 2018
 * ...:::vsaldivarm@gmail.com:::...
 **/
public class RestaXXX {

    public static void main(String[] args) {
        Integer nD = Integer.parseInt(args[0]);
        double d1 = Double.parseDouble(args[1]);
        double d2 = Double.parseDouble(args[2]);

        double d3 = d1 - d2;
        System.out.println(d3);
        System.out.println(new RestaXXX().redondeaADecimales(d3, nD));

    }

    public double redondeaADecimales(double valorSinRedondear, Integer numeroDeDecimales) {
        double escala = Math.pow(10, numeroDeDecimales);
        return Math.round(valorSinRedondear * escala) / escala;
    }

}
