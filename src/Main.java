import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String cedula;
        String password;

        cedula = ingresarMensaje("Ingrese su cédula", JOptionPane.INFORMATION_MESSAGE);
        if (validarCedula(cedula)) {
            password = ingresarMensaje("Ingrese su contraseña", JOptionPane.INFORMATION_MESSAGE);
            if (validarContrasenia(password)) {
                mostarMensaje("Ingreso correctamente", JOptionPane.INFORMATION_MESSAGE);
                Almacenamiento almacenamiento = new Almacenamiento();
                almacenamiento.almacenarDatos(new Persona(cedula, password));

            } else {
                mostarMensaje("La contraseña no es válida", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            mostarMensaje("La cédula no es válida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostarMensaje(String mensaje, int informationMessage) {
        JOptionPane.showMessageDialog(null, mensaje, "Log in", informationMessage);
    }

    private static String ingresarMensaje(String mensaje, int informationMessage) {
        return JOptionPane.showInputDialog(null, mensaje, "Log in", informationMessage);
    }

    public static boolean validarContrasenia(String password) {
        Pattern pat = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        Matcher mat = pat.matcher(password);
        return mat.matches() ? true : false;
    }

    public static boolean validarCedula(String cedula) {
        Pattern pat = Pattern.compile("^\\d{10}$");
        Matcher mat = pat.matcher(cedula);
        return mat.matches() ? true : false;
    }


}