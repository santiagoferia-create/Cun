public class Usuario {
    private int id;
    private String name;
    private String username;
    private String email;

    // Getters (Gson los necesita o usa reflexión para campos privados)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }

    // Setters opcionales, pero recomendados para claridad
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
