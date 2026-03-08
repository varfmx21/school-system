public class Persona {
    private String nombre;
    private int edad;

    // Constructor vacio
    public Persona() {}

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Obtener edad
    public int getEdad() {
        return edad;
    }

    // Setear nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Setear edad
    public void setEdad(int edad) {
        this.edad = edad;
    }

}