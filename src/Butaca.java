
/**
 *
 * @author Saul Neri
 */
public class Butaca {
    private String nombre, sexo, nivel;
    private int edad;
    
    public Butaca() {}
    
    public Butaca(String nombre, String nivel, String sexo, int edad) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.sexo = sexo;
        this.edad = edad;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getSexo() {
        return this.sexo;
    }
    
    public String getNivel() {
        return this.nivel;
    }
    
    public int getEdad() {
        return this.edad;
    }
     
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
