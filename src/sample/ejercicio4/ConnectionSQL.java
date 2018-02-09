package sample.ejercicio4;


import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;


/**
 * @author vladimirsaldivar
 * @project HipotenusaXXX 2018
 * ...:::vsaldivarm@gmail.com:::...
 **/
public class ConnectionSQL {

    private Connection conn = null;

    public ConnectionSQL() throws IOException {

        String query = "SELECT E.ID_ESTADO,ISNULL (SUM(NUMERO_EMPLEADOS),0) AS NUMERO_EMPLEADOS, E.NOMBRE FROM ESTADOS E\n" +
                "LEFT JOIN PLANTAS P ON P.ID_ESTADO = E.ID_ESTADO\n" +
                "GROUP BY E.ID_ESTADO ,E.NOMBRE\n" +
                "ORDER BY NUMERO_EMPLEADOS DESC;";

        Statement st;
        try {
            File reporte = new File("reporte.txt");
            FileWriter writeReporte = new FileWriter(reporte, true);

            String urlConn = "jdbc:sqlserver://45.40.139.98; databaseName=test; user=AdminBD_des; password=Desa#0216;";
            conn = DriverManager.getConnection(urlConn);

            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            String ln = System.getProperty("line.separator");
            StringBuffer strReporte = new StringBuffer();
            strReporte.append(StringUtils.rightPad("ID_ESTADO", 10));
            strReporte.append(StringUtils.rightPad("NUMERO_EMPLEADOS", 20));
            strReporte.append(StringUtils.rightPad("NOMBRE", 100));
            strReporte.append(ln);

            while (rs.next()) {
                String ID_ESTADO = rs.getString("ID_ESTADO");
                String NUMERO_EMPLEADOS = rs.getString("NUMERO_EMPLEADOS");
                String NOMBRE = rs.getString("NOMBRE");

                strReporte.append(StringUtils.rightPad(ID_ESTADO + ",", 10));
                strReporte.append(StringUtils.rightPad(NUMERO_EMPLEADOS + ",", 20));
                strReporte.append(StringUtils.rightPad(NOMBRE, 100));
                strReporte.append(ln);
            }
            System.out.println(strReporte);
            writeReporte.write(strReporte.toString());
            writeReporte.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
