package Tabla;

import DAO.CategoriaDAO;
import VO.CategoriaVO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class Tabla_CategoriaVO{

   CategoriaDAO dao = null;


    public void visualizar_CategoriaVO(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Nombre");
        dt.addColumn("Edad desde");
        dt.addColumn("Edad hasta");
//        dt.addColumn("Sexo");

        
        dao = new CategoriaDAO();
        CategoriaVO vo = new CategoriaVO();
        ArrayList<CategoriaVO> list = dao.Listar_CategoriaVO();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[3];
                vo = list.get(i);
                fila[0] = vo.getNombreCategoria();
                fila[1] = vo.getDesdeAnio();
                fila[2] = vo.getHastaAnio();
//                fila[3] = vo.getSexocategoria();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
    
    public void visualizar_CategoriaVOCorredot(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Nombre");
        dt.addColumn("Edad desde");
        dt.addColumn("Edad hasta");
//        dt.addColumn("Sexo");

        dao = new CategoriaDAO();
        CategoriaVO vo = new CategoriaVO();
        ArrayList<CategoriaVO> list = dao.Listar_CategoriaVO();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getNombreCategoria();
                fila[1] = vo.getDesdeAnio();
                fila[2] = vo.getHastaAnio();
//                fila[3] = vo.getSexocategoria();
                dt.addRow(fila);
            }
            //tabla.setModel(dt);
        }

    }
}


