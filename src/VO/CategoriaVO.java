package VO;

public class CategoriaVO {

/*Todo los atributos*/
    int id_categoria;
    String nombreCategoria;
    int desdeAnio;
    int hastaAnio;
    //String sexocategoria;

public CategoriaVO(){}

/*Todo los codigos get*/

    public int getId_categoria() {
        return id_categoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public int getDesdeAnio() {
        return desdeAnio;
    }

    public int getHastaAnio() {
        return hastaAnio;
    }

//    public String getSexocategoria() {
//        return sexocategoria;
//    }



/*Todo los codigos set*/

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

        public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void setDesdeAnio(int desdeAnio) {
        this.desdeAnio = desdeAnio;
    }

    public void setHastaAnio(int hastaAnio) {
        this.hastaAnio = hastaAnio;
    }

//    public void setSexocategoria(String sexocategoria) {
//        this.sexocategoria = sexocategoria;
//    }
  

}
