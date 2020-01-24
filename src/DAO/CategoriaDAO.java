package DAO;

import Conexion.Conectar;
import VO.CategoriaVO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


/*Metodo listar*/
public class CategoriaDAO{

    public ArrayList<CategoriaVO> Listar_CategoriaVO(){
        ArrayList<CategoriaVO> list = new ArrayList<CategoriaVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT id_Categoria, `nombreCategoria`, `desdeAnio`, `hastaAnio` FROM `categoria`";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                CategoriaVO vo = new CategoriaVO();
                vo.setId_categoria(rs.getInt(1));
                vo.setNombreCategoria(rs.getString(2));
                vo.setDesdeAnio(rs.getInt(3));
                vo.setHastaAnio(rs.getInt(4));
//                vo.setSexocategoria(rs.getString(4));
                
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println("Exception SQL Clase CatalogoDAO: "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("Exception Clase CatalogoDAO: "+ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }
    
    
    
     /*Metodo Listar Categoria en un ComboBOX*/
    public void Listar_Categoria_ComboBOX(JComboBox box){
        DefaultComboBoxModel value;
        Conectar conec = new Conectar();
        String sql = "SELECT `nombreCategoria` FROM `categoria`";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            value = new DefaultComboBoxModel();
            box.setModel(value);
            while(rs.next()){
                value.addElement(rs.getString(1));
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
        
    }
    
     /*Metodo Listar Categoria en un ComboBOX*/
    public void Listar_CategoriaPorEdad_ComboBOX(JComboBox box, int edad){
        DefaultComboBoxModel value;
        Conectar conec = new Conectar();
        String sql = "SELECT nombreCategoria FROM categoria WHERE ? BETWEEN desdeAnio AND hastaAnio";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, edad);
            rs = ps.executeQuery();
            value = new DefaultComboBoxModel();
            box.setModel(value);
            while(rs.next()){
                value.addElement(rs.getString(1));
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
        
    }
    
    public CategoriaVO buscarCategoriaXid(String cat) {
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM `categoria` WHERE nombreCategoria = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        CategoriaVO vo = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, cat);
//            ps.setString(2, genero);
            rs = ps.executeQuery();
            
//            int idcategoria;
//            int montoacobrar;
//            String descripcion;

            if (rs.first()) {
                vo = new CategoriaVO();
                vo.setId_categoria(rs.getInt(1));
                vo.setNombreCategoria(rs.getString(2));                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return vo;
    }
    
    public CategoriaVO buscarCategoriaXEdad(int edad) {
        Conectar conec = new Conectar();
        String sql = "SELECT nombreCategoria FROM categoria WHERE ? BETWEEN desdeAnio AND hastaAnio;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        CategoriaVO vo = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, edad);
//            ps.setString(2, genero);
            rs = ps.executeQuery();
            
//            int idcategoria;
//            int montoacobrar;
//            String descripcion;

            if (rs.first()) {
                vo = new CategoriaVO();
                //vo.setId_categoria(rs.getInt(1));
                vo.setNombreCategoria(rs.getString(1));                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
        return vo;
    }



/*Metodo agregar*/
    public int Agregar_CategoriaVO(CategoriaVO vo){
        Conectar conec = new Conectar();
        //String sql = "INSERT INTO `categoria`(`id_Categoria`, `edadCategoria`, `sexoCategoria`) VALUES(?,?,?);";
        String sql = "INSERT INTO `categoria`(`nombreCategoria`, `desdeAnio`, `hastaAnio`) VALUES(?,?,?);";
        int a  = 0;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setString(1, vo.getNombreCategoria());
            ps.setInt(2, vo.getDesdeAnio());
            ps.setInt(3, vo.getHastaAnio());
//            ps.setString(4, vo.getSexocategoria());
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Exception SQL en agregarCategoria: "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("Exception agregarCAtegoria: "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){
            }
        }
        return a;
    }


/*Metodo Modificar*/
    public int Modificar_CategoriaVO(CategoriaVO vo, CategoriaVO vo2){
        Conectar conec = new Conectar();
        //String sql = "UPDATE `categoria` SET `edadCategoria`=?,`sexoCategoria`=? WHERE `id_Categoria`=?";
        String sql = "UPDATE `categoria` SET `nombreCategoria`=?,`desdeAnio`=?,`hastaAnio`=? WHERE `nombreCategoria`=? ";
        int a = 0;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombreCategoria());
            ps.setInt(2, vo.getDesdeAnio());
            ps.setInt(3, vo.getHastaAnio());
//            ps.setString(4, vo.getSexocategoria());
            ps.setString(4, vo2.getNombreCategoria());
//            ps.setString(6, vo2.getSexocategoria());
            a = ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
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
    public int Eliminar_CategoriaVO(CategoriaVO vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM `categoria` WHERE nombreCategoria = ?;";
        PreparedStatement ps = null;
        int a=0;
//        System.out.println("Nombre: "+vo.getNombreCategoria()+" Sexo: "+vo.getSexocategoria());
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombreCategoria());
//            ps.setString(2, vo.getSexocategoria());
            a = ps.executeUpdate();
            System.out.println(a);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
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

    

}
