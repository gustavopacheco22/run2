
package Windows;


import Conexion.Conectar;
import java.awt.TextField;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class generarReporte {
    
    //Toma los valores del jtable seleccionado y los coloca en un TextField, en este caso para colocar el nombre 
    public static void tableInTextField(JTable table, JTextField texto){
        
        int filaseleccionada = table.getSelectedRow();
        String nombreModCat = table.getValueAt(filaseleccionada, 0).toString();
        int desdeModCat = (Integer) table.getValueAt(filaseleccionada, 1);
        int hastaModCat = (Integer) table.getValueAt(filaseleccionada, 2);
//        sexoModCat = tableModificarCat.getValueAt(filaseleccionada, 3).toString();

        System.out.println("Nombre: " + nombreModCat + " desde: " + desdeModCat + " hasta: " + hastaModCat);
        texto.setText(nombreModCat);
    }
    
    public static void generarInforme(String archivo){
         Conectar con = new Conectar();
        Connection conn = con.getConnection();
        
        JasperReport reporte = null;
        String path = "src\\reportes\\"+ archivo;
        
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(nuevaInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void generarInformeCParametros(String archivo, String var1, String var2, JTextField textvar1, JComboBox textvar2){
        Conectar con = new Conectar();
        Connection conn = con.getConnection();
        
        JasperReport reporte = null;
        String path = "src\\reportes\\reporteCategoria.jasper";
        
      
        //parametro2.put("parameter2", comboSexoReporte.getSelectedItem());
        //parametro1.putAll(parametro1);
        
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map parametro1 = new HashMap();
        
            
            parametro1.put(var1, textvar1.getText());
            parametro1.put(var2, textvar2.getSelectedItem());
           
            System.out.println(parametro1);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro1, conn);
            
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(nuevaInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
