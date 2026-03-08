
abstract public class Estudiante extends Persona {
    static final double NOTA_APROBACION = 6.0;

    private double nota;

    // Obtener nota
    public double getNota() {
        return nota;
    }

    // Obtener setear nota
    public void setNota(double nota) {
        this.nota = nota;
    }

    // Obtener estado: aprobado o reprobado
    public String obtenerEstado() {
        return nota >= NOTA_APROBACION ? "Aprobado" : "Reprobado";
    }

    // Obtener tipo para poder sobreescribir en clases EstudianteRegular y EstudianteBeca
    public abstract String obtenerTipo();

    // Mostrar info del estudiante
    public void mostrarInfo() {
        System.out.println("Nombre: " + getNombre() + ", Nota: " + getNota());
    }

    // Sobrecarga de mostrar info del estudiante
    public void mostrarInfo(boolean mostrarEstado) {
        System.out.println("Nombre: " + getNombre() + ", Nota: " + getNota());
        if (mostrarEstado) {
            System.out.println("Estado: " + obtenerEstado());
        }
    }
}