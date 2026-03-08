public class EstudianteBeca extends Estudiante {
    // Polimorfismo de obtener tipo de estudiante
    @Override
    public String obtenerTipo() {
        return "Becado";
    }
}