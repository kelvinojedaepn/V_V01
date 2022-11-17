import java.util.ArrayList;

public class Almacenamiento {

    private ArrayList<Persona> listaPersonas;

    public Almacenamiento() {
        this.listaPersonas = new ArrayList<>();
    }

    public void almacenarDatos (Persona persona){
        this.listaPersonas.add(persona);
    }

    public int encontrarPersona (Persona persona){
        return this.listaPersonas.indexOf(persona);
    }
    public void imprimir() {
        for (Persona p : listaPersonas) {
            System.out.println(p.toString());
        }
    }
}
