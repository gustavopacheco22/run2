package DAO;

import Conexion.Conectar;
import VO.CorredorVO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/*Metodo listar*/
public class CorredorDAO{

    public ArrayList<CorredorVO> Listar_CorredorVO(){
        ArrayList<CorredorVO> list = new ArrayList<CorredorVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM `corredor`";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                CorredorVO vo = new CorredorVO();
                vo.setId_corredor(rs.getInt(1));
                vo.setDNI(rs.getInt(2));
                vo.setNombre(rs.getString(3));
                vo.setApellido(rs.getString(4));
                vo.setEdad(rs.getInt(5));
                vo.setNumero(rs.getInt(6));
                vo.setTiempo(rs.getString(7));
                vo.setSexoCorredor(rs.getString(8));
                vo.setEstado(rs.getBoolean(9));
                vo.setId_categoria(rs.getInt(10));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }
    
    public ArrayList<CorredorVO> listarUnCorredorxNumero(String numero){
        
        //Ver si agregar el estado o no
        //
        //
        
        ArrayList<CorredorVO> list = new ArrayList<CorredorVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT nombre, apellido, tiempo, numero, DNi FROM corredor WHERE numero = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, numero);
            rs = ps.executeQuery();
            
            while(rs.next()){
                CorredorVO vo = new CorredorVO();
                vo.setNombre(rs.getString(1));
                vo.setApellido(rs.getString(2));
                vo.setTiempo(rs.getString(3));
                vo.setNumero(rs.getInt(4));
                vo.setDNI(rs.getInt(5));
//                vo.setNombre(rs.getString(3));
//                vo.setEdad(rs.getInt(5));
//                vo.setSexoCorredor(rs.getString(8));
//                vo.setId_categoria(rs.getInt(9));
                list.add(vo);
                System.out.println("indice de la lista"+list.indexOf(vo));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }
    
    


/*Metodo agregar*/
    public int Agregar_CorredorVO(CorredorVO vo){
        Conectar conec = new Conectar();
        String sql = "INSERT INTO `corredor`( `DNI`, `nombre`, `apellido`, `edad`, `numero`, `tiempo`, `sexoCorredor`, estado, `id_Categoria`) VALUES (?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        int res= 0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getDNI());
            ps.setString(2, vo.getNombre());
            ps.setString(3, vo.getApellido());
            ps.setInt(4, vo.getEdad());
            ps.setInt(5, vo.getNumero());
            ps.setString(6, vo.getTiempo());
            ps.setString(7, vo.getSexoCorredor());
            ps.setBoolean(8, vo.isEstado());
            ps.setInt(9, vo.getId_categoria());
            res = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error SQl Clase Agregar_Corredor: "+ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return res;
    }


/*Metodo Modificar*/
    public int Modificar_CorredorVO(CorredorVO vo, int dni){
        Conectar conec = new Conectar();
        String sql = "UPDATE `corredor` SET `DNI`=?,`nombre`=?,`apellido`=?,`edad`=?,`numero`=?,`tiempo`=?, sexoCorredor = ?,`id_Categoria`=? WHERE DNI = ?";
        PreparedStatement ps = null;
        int a = 0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getDNI());
            ps.setString(2, vo.getNombre());
            ps.setString(3, vo.getApellido());
            ps.setInt(4, vo.getEdad());
            ps.setInt(5, vo.getNumero());
            ps.setString(6, vo.getTiempo());
            ps.setString(7, vo.getSexoCorredor());
            ps.setInt(8, vo.getId_categoria());
            ps.setInt(9, dni);
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error SQl Clase Modificar_Corredor: "+ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return a;
    }
    
    /*Metodo Modificar*/
    public int RegistrarTiempoVO(CorredorVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE corredor SET tiempo = ?, estado = ? WHERE numero = ?";
        PreparedStatement ps = null;
        int a = 0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getTiempo());
            ps.setBoolean(2, vo.isEstado());
            ps.setInt(3, vo.getNumero());
//            ps.setString(3, vo.getApellido());
//            ps.setInt(4, vo.getEdad());
//            ps.setInt(5, vo.getNumero());
//            ps.setInt(6, vo.getTiempo());
//            ps.setString(7, vo.getSexoCorredor());
//            ps.setInt(8, vo.getId_categoria());
//            ps.setInt(9, dni);
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error SQl Clase RegistrarTiempo: "+ ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return a;
    }
    
    /*Metodo Modificar*/
    public int limpiarDatosTYNVO(CorredorVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE corredor SET tiempo = ?, estado = ? WHERE 1";
        PreparedStatement ps = null;
        int a = 0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getTiempo());
            ps.setBoolean(2, vo.isEstado());
            
//            ps.setString(3, vo.getApellido());
//            ps.setInt(4, vo.getEdad());
//            ps.setInt(5, vo.getNumero());
//            ps.setInt(6, vo.getTiempo());
//            ps.setString(7, vo.getSexoCorredor());
//            ps.setInt(8, vo.getId_categoria());
//            ps.setInt(9, dni);
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error SQl Clase RegistrarTiempo: "+ ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return a;
    }

    
     public int limpiarEstadoCorredor(CorredorVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE corredor SET  estado = ? WHERE 1";
        PreparedStatement ps = null;
        int a = 0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setBoolean(1, vo.isEstado());
            
//            ps.setString(3, vo.getApellido());
//            ps.setInt(4, vo.getEdad());
//            ps.setInt(5, vo.getNumero());
//            ps.setInt(6, vo.getTiempo());
//            ps.setString(7, vo.getSexoCorredor());
//            ps.setInt(8, vo.getId_categoria());
//            ps.setInt(9, dni);
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error SQl Clase RegistrarTiempo: "+ ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return a;
    }
     
     public int limpiarTiempoCorredor(CorredorVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE corredor SET  tiempo = ? WHERE 1";
        PreparedStatement ps = null;
        int a = 0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setString(1, vo.getTiempo());
            
//            ps.setString(3, vo.getApellido());
//            ps.setInt(4, vo.getEdad());
//            ps.setInt(5, vo.getNumero());
//            ps.setInt(6, vo.getTiempo());
//            ps.setString(7, vo.getSexoCorredor());
//            ps.setInt(8, vo.getId_categoria());
//            ps.setInt(9, dni);
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error SQl Clase RegistrarTiempo: "+ ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return a;
    }

/*Metodo Eliminar*/
    public int Eliminar_CorredorVO(CorredorVO vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM `corredor` WHERE DNI = ?";
        PreparedStatement ps = null;
        int a = 0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getDNI());
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error SQl Clase EliminarCorredor "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("Error SQl Clase EliminarCorredor: "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return a;
    }
    
    //Elimminar a todos los corredores
    public int eliminarAll(){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM corredor ";
        PreparedStatement ps = null;
        int a = 0;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error SQl Clase EliminarCorredor "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("Error SQl Clase EliminarCorredor: "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return a;
    }


}
