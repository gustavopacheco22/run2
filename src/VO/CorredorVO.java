package VO;

public class CorredorVO {

/*Todo los atributos*/
    int id_corredor;
    int DNI;
    String nombre;
    String apellido;
    int edad;
    int numero;
    String tiempo;
    String sexoCorredor;
    boolean estado;
    int id_categoria;

public CorredorVO(){}

/*Todo los codigos get*/

    public int getId_corredor() {
        return id_corredor;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumero() {
        return numero;
    }

    public String getTiempo() {
        return tiempo;
    }

    public String getSexoCorredor() {
        return sexoCorredor;
    }

    public boolean isEstado() {
        return estado;
    }
    
    public int getId_categoria() {
        return id_categoria;
    }
    


/*Todo los codigos set*/

    public void setId_corredor(int id_corredor) {
        this.id_corredor = id_corredor;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int telefono) {
        this.edad = telefono;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public void setSexoCorredor(String sexoCorredor) {
        this.sexoCorredor = sexoCorredor;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    

}
