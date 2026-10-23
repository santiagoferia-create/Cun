import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorUsuarioTest {

    // Instancia de la clase a probar
    ValidadorUsuario validador = new ValidadorUsuario();

    @Test
    @DisplayName("Debe aceptar un email válido")
    public void testEmailValido() {
        // Preparación
        String emailTest = "ana@correo.com";
        // Ejecución y Aserción (El Juez)
        assertTrue(validador.esEmailValido(emailTest), "El email debería ser válido");
    }

    @Test
    @DisplayName("Debe rechazar un email sin @")
    public void testEmailSinArroba() {
        String emailTest = "ana.correo.com";
        assertFalse(validador.esEmailValido(emailTest), "El email sin @ debe ser inválido");
    }

    @Test
    @DisplayName("Debe rechazar un email nulo")
    public void testEmailNulo() {
        assertFalse(validador.esEmailValido(null), "El email nulo debe ser inválido");
    }

    @Test
    @DisplayName("Debe validar nombres de 3 letras o más")
    public void testNombreValido() {
        assertTrue(validador.esNombreValido("Ana"), "Ana tiene 3 letras, es válido");
        assertTrue(validador.esNombreValido("Carlos"), "Carlos es válido");
    }

    @Test
    @DisplayName("Debe rechazar nombres de menos de 3 letras")
    public void testNombreInvalido() {
        assertFalse(validador.esNombreValido("Al"), "Al tiene 2 letras, debe fallar");
    }
}
