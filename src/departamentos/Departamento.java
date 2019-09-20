/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamentos;

import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author valer
 */
public class Departamento {

    private String departamento;

    //metodo constructor
    public Departamento(String departamento) {
        this.departamento = departamento;
    }

    public String obtenerDepartamento() {
        return departamento;
    }

    private static Departamento[] departamentos;

    static String buscarPath(String DepartamentoAct, String[][] datos) {
        String nombreImagen = null;
        int i = 0;
        while (i < datos.length) {
            if (DepartamentoAct.equals(datos[i][0])) {
                nombreImagen = datos[i][1];
                break;
            } else {
                i++;
            }
        }
        return nombreImagen;
    }

    public static void mostrarImagen(String[][] datos, JPanel pnl, String DepartamentoAct) {

        String nombreImagen = buscarPath(DepartamentoAct, datos);

        String nombreArchivo = System.getProperty("user.dir")
                + "/src/mapas/" + nombreImagen;

        Util.mostrarImagen(pnl, nombreArchivo);

    }

    public static Departamento obtenerDepartamento(int indice) {
        return departamentos[indice];
    }

    public static Departamento buscarDepartamento(String nombreDepart) {
        for (int i = 0; i < departamentos.length; i++) {
            if (departamentos[i].obtenerDepartamento().equals(nombreDepart)) {
                return departamentos[i];
            }
        }
        return null;
    }//

    public static void ObtenerDepartamentos(String[][] datos) {
        departamentos = null;

        String anteriorDepartamento = "";
        for (int i = 0; i < datos.length; i++) {
            if (!datos[i][0].equals(anteriorDepartamento)) {

                if (departamentos == null) {

                    departamentos = new Departamento[1];
                } else {

                    departamentos = (Departamento[]) Util.redimensionar(departamentos, departamentos.length + 1);
                }
                departamentos[departamentos.length - 1] = new Departamento(datos[i][0]);

                anteriorDepartamento = datos[i][0];
            }
        }
    }

    public static void llenarLista(JComboBox cmb) {
        cmb.removeAllItems();

        if (departamentos != null) {
            for (int i = 0; i < departamentos.length; i++) {
                cmb.addItem(departamentos[i].obtenerDepartamento());
            }
        }
    }

}
