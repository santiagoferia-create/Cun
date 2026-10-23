# TallerApiTesting - G78

Proyecto Java para el taller "El Puente y El Escudo en Acción".

## Estructura
- src/ : Clases principales (Usuario, ValidadorUsuario, ConsumoAPI)
- tests/ : Pruebas JUnit (ValidadorUsuarioTest)
- libs/ : Dependencias (gson y junit standalone para ejecución por consola)

## Cómo importar en IDE (NetBeans / IntelliJ)

1. Crea un nuevo proyecto Java vacío llamado TallerApiTesting.
2. Copia los archivos .java de src/ al paquete fuente de tu proyecto.
3. Copia ValidadorUsuarioTest.java a la carpeta de tests.
4. Agrega el JAR de Gson (libs/gson-2.11.0.jar) al classpath/Libraries.
5. Configura JUnit 5 (usualmente automático al crear tests).

## Ejecución esperada

### ConsumoAPI (consola):
```
Iniciando petición HTTP GET...
Respuesta recibida con éxito.
JSON Crudo: { ... }
Objeto Java (Deserializado): Usuario{id=1, name='Leanne Graham', email='Sincere@april.biz'}
✅ El email recibido de la API es seguro y válido.
```

### Tests JUnit: 5 pruebas en verde.
