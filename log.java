import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.util.Date;
 public class log {
    private static String nameFile = null;
    File file;
    FileWriter fw ;
    Date fecha;
    public log() {
        fecha = new Date();
    }
    public static void logFile(String linea) throws IOException {
        String fecha = new SimpleDateFormat("[dd MM yyyy HH mm ss]").format(new Date());
        if (nameFile == null) {
        	nameFile = fecha;

        }
        try {
            File file = new File(nameFile+ "-log" + ".txt");

        FileWriter fw = new FileWriter(file, true);
        fw.write(fecha + " " + linea + "\n");
        fw.flush();
        fw.close();
        } catch (IOException ex) {
            System.out.println(ex + "Directorio no encontrado");
        }
    }
}
