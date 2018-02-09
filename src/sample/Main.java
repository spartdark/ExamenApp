package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.ejercicio2.Cliente;
import sample.ejercicio2.CuentaBancaria;
import sample.ejercicio4.ConnectionSQL;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        //launch(args);
        HipotenusaXXX hipotenusaXXX = new HipotenusaXXX();
        System.out.println(hipotenusaXXX.hipotenusa(4, 8));
        //Ejercicio 2
        CuentaBancaria cuenta = new CuentaBancaria("123456-7", (float) 10500.75);
        Cliente cliente = new Cliente("Juan Perez", cuenta);
        System.out.println(cliente.obtenerDatosCuenta());
        try {
            new ConnectionSQL();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
