package Tabla;

import DAO.CategoriaDAO;
import DAO.CorredorDAO;
import VO.CategoriaVO;
import VO.CorredorVO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Tabla_CorredorVO{

   CorredorDAO dao = null;
   CategoriaDAO daoc = null;
  

    public void visualizar_CorredorVO(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        
        dt.addColumn("Dorsal");
        dt.addColumn("DNI");
        dt.addColumn("Nombre");
        dt.addColumn("Apellido");
        
        //dt.addColumn("Categoria");

        dao = new CorredorDAO();
        CorredorVO vo = new CorredorVO();
        ArrayList<CorredorVO> list = dao.Listar_CorredorVO();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[9];
                vo = list.get(i);
                fila[0] = vo.getNumero();
                fila[1] = vo.getDNI();
                fila[2] = vo.getNombre();
                fila[3] = vo.getApellido();
                //fila[3] = vo.getTelefono();
               
                //fila[5] = vo.getId_categoria();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
    
    public void visualizar_CorredorCategoriaVO(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        
        dt.addColumn("Dorsal");
        dt.addColumn("DNI");
        dt.addColumn("Nombre");
        dt.addColumn("Apellido");
        dt.addColumn("Categoria");
        
        //dt.addColumn("Categoria");

        dao = new CorredorDAO();
        CorredorVO vo = new CorredorVO();
        ArrayList<CorredorVO> list = dao.Listar_CorredorVO();
        daoc = new CategoriaDAO();
        CategoriaVO voc = new CategoriaVO();
        ArrayList<CategoriaVO> listc = daoc.Listar_CategoriaVO();
        
        
        if(list.size() > 0){
            if(listc.size() > 0){
                for(int i=0; i<list.size(); i++){
                    Object fila[] = new Object[9];
                    vo = list.get(i);
                    
                    fila[0] = vo.getNumero();
                    fila[1] = vo.getDNI();
                    fila[2] = vo.getNombre();
                    fila[3] = vo.getApellido();
                    for(int j=0; j<listc.size(); j++){
                        voc = listc.get(j);
                        if(vo.getId_categoria() == voc.getId_categoria()){
                            fila[4] = voc.getNombreCategoria();
                        }
                    }
                    dt.addRow(fila);
                    
                }//for
            }//listc.sixw
            tabla.setModel(dt);
        }//list.sze
        
    }
    
    public void visualizarTodosCrredorVO(JTable tabla){
        DefaultTableModel dt = new DefaultTableModel();
        
        dt.addColumn("Dorsal");
        dt.addColumn("DNI");
        dt.addColumn("Nombre");
        dt.addColumn("Apellido");
        dt.addColumn("Tiempo");
        dt.addColumn("Estado");
        
        //dt.addColumn("Categoria");

        dao = new CorredorDAO();
        CorredorVO vo = new CorredorVO();
        //int a = dao.limpiarDatosTYNVO(vo);
        ArrayList<CorredorVO> list = dao.Listar_CorredorVO();

        if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[9];
                vo = list.get(i);
                fila[0] = vo.getNumero();
                fila[1] = vo.getDNI();
                fila[2] = vo.getNombre();
                fila[3] = vo.getApellido();
                fila[4] = vo.getTiempo();
                fila[5] = vo.isEstado();
                //fila[3] = vo.getTelefono();
               
                //fila[5] = vo.getId_categoria();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
    
        public int visualizarUnCorredorVO(JTable tabla, String numero, DefaultTableModel dt){
        //DefaultTableModel dt = new DefaultTableModel();
        
//        dt.addColumn("Dorsal");
//        dt.addColumn("Nombre");
//        dt.addColumn("Apellido");
//        dt.addColumn("Tiempo");

        
        //dt.addColumn("Categoria");
    int num = 0;
        dao = new CorredorDAO();
        CorredorVO vo = new CorredorVO();
        ArrayList<CorredorVO> list = dao.listarUnCorredorxNumero(numero);
         if(list.isEmpty()){
             System.out.println("La lista esta vacia");
             
             num = 0;
         }else{
             num = 1;
         }
             
        if(list.size() > 0){

            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getNumero();
                fila[1] = vo.getDNI();
                fila[2] = vo.getNombre();
                fila[3] = vo.getApellido();
                fila[4] = vo.getTiempo();
                //fila[3] = vo.getTelefono();
               
                //fila[5] = vo.getId_categoria();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
        return num;
        
    }
}


