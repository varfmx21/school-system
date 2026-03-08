public class EstudianteRegular extends Estudiante {
    // Polimorfismo de obtener tipo de estudiante
    @Override
    public String obtenerTipo() {
        return "Regular";
    }
}