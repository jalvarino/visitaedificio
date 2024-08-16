public class Visitante {
    private String nombre;
    private String apellido;
    private int edad;
    private char tipodesangre;
    private int visitas;
    private boolean jubilado;

    public Visitante(String nombre, String apellido, int edad, char tipodesangre, int visitas, boolean jubilado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.tipodesangre = tipodesangre;
        this.visitas = visitas;
        this.jubilado = jubilado;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getTipodesangre() {
        return tipodesangre;
    }
    public void setTipodesangre(char tipodesangre) { this.tipodesangre = tipodesangre; }

    public int getVisitas() {
        return visitas;
    }
    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public boolean getJubilado() { return jubilado; }
    public void setJubilado(boolean jubilado) { this.jubilado = jubilado; }

}
