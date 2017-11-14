package DEV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    public static Connection conexion = null;
    public static Connection conexion_online = null;
    public static String db = null;

    public static boolean isWindows(String os) {
        return (os.indexOf("win") >= 0);
    }

    public static boolean isMac(String os) {
        return (os.indexOf("mac") >= 0);
    }

    public static void conexion_online_activar() {
        try {
            conexion_online = DriverManager.getConnection("jdbc:postgresql://38.132.106.80:5432/bk_silos", "postgres", "postgres");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se puede conectar al servidor. ERROR: " + ex);
        }
    }

    public static void Iniciar_Conexion() {

        String result = "";
        String os = System.getProperty("os.name").toLowerCase();
        db = null;
        String host = null;
        String user = null;
        String pass = null;
        String mac_adress = null;
        String mac_adress2 = null;

        try {
            if (isWindows(os)) {
                
                System.out.println("This is Windows");

                String drive = "C";
                File file = File.createTempFile("realhowto", ".vbs");
                file.deleteOnExit();
                FileWriter fw = new java.io.FileWriter(file);

                String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                        + "Set colDrives = objFSO.Drives\n"
                        + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
                        + "Wscript.Echo objDrive.SerialNumber";
                fw.write(vbs);
                fw.close();
                Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = input.readLine()) != null) {
                    result += line;
                }
                input.close();
                System.err.println(result);

                if (result.equals("237070357")) { // 4k servidor
                    db = "silosystem";
                    host = "localhost";
                    user = "postgres";
                    pass = "postgres";
                    mac_adress = "237070357";
                }
                if (result.equals("-1471616258")) { // 4k 
                    db = "silosystem";
//                    host = "190.104.167.162"; //4k
                    host = "localhost";
                    user = "postgres";
                    pass = "postgres";
                    mac_adress = "-1471616258";
                }
                if (result.equals("946608692")) { // Servidor San esteban
                    db = "silosystem";
//                    host = "190.104.167.162"; //4k
//                    pass = "postgres";
                    host = "192.168.0.250";
                    user = "postgres";
                    pass = "postgres4k";
                    mac_adress = "946608692";
                }
                if (result.equals("2056550711")) { // Servidor San esteban
                    db = "silosystem";
//                    host = "190.104.167.162"; //4k
//                    pass = "postgres";
                    host = "192.168.0.250";
                    user = "postgres";
                    pass = "postgres4k";
                    mac_adress = "2056550711";
                }
                if (result.equals("407074084")) { // San Esteban PC 2
                    db = "silosystem";
                    host = "192.168.0.250";
                    user = "postgres";
                    pass = "postgres4k";
                    mac_adress = "407074084";
                }
                if (result.equals("-1878214831")) { // MUNI 
                    db = "silosystem";
//                    host = "localhost"; //4k
                    host = "172.22.24.162"; //SAN ESTEBAN
//                    host = "190.104.167.162"; //4k
//                    user = "postgres";
                    pass = "postgres4k";
//                    pass = "postgres";
                    mac_adress = "-1878214831";
                }
                if (result.equals("1992675120")) { // San rafael 
                    db = "silosystem";
                    host = "172.22.24.162"; //SAN ESTEBAN
//                    host = "190.104.167.162"; //4k
//                    user = "postgres";
                    pass = "postgres4k";
                    mac_adress = "1992675120";
                }

                if (result.equals("1748823206")) { // dell
                    db = "silosystem";
                    host = "localhost";
//                    host = "192.168.0.250"; //4k
                    user = "postgres";
//                    pass = "postgres";
                    pass = "postgres";
                    mac_adress = "1748823206";
                }

//                System.err.println();
                if ((result.equals(mac_adress)) || (result.equals(mac_adress2))) {
                    Class.forName("org.postgresql.Driver");
                    conexion = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + db, user, pass);
                } else {
                    JOptionPane.showMessageDialog(null, "PC no registrada (" + result + ")");
                    System.exit(-1);
                }

            } else if (isMac(os)) {

                Metodos.ismac = true;

                host = null;
                user = null;
                pass = null;
                db = "silosystem";
                host = "172.22.24.162"; //SAN ESTEBAN
                user = "postgres";
                pass = "postgres4k";
                Class.forName("org.postgresql.Driver");
                conexion = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + db, user, pass);
            }
//            JOptionPane.showMessageDialog(null, "Host: " + host + " - USER: " + user + " - PASS: " + pass + " PC: " + mac_adress);
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conectar al servidor. ERROR: " + ex + host + ":5432/" + db + user + pass);
        }
    }

    public static void Cerrar_Conexion() {
        try {
            conexion.close();
            System.err.println("Conexion finalizada");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void Verificar_conexion() {
        try {
            if (conexion.isClosed() == false) {
                //System.err.println("conexion OK");
            } else {
                System.err.println("conexion FAIL");
                Iniciar_Conexion();
                if (conexion.isClosed() == false) {
                    System.err.println("conexion reiniciada; Conexion OK");
                } else {
                    JOptionPane.showMessageDialog(null, "Error de conexion con la base de datos.");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

}
