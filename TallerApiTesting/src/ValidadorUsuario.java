public class ValidadorUsuario {
    // Regla de negocio: Un email es válido si contiene un "@" y un "."
    public boolean esEmailValido(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    // Regla de negocio: El nombre debe tener al menos 3 letras
    public boolean esNombreValido(String nombre) {
        if (nombre == null) return false;
        return nombre.trim().length() >= 3;
    }
}
