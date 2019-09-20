/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamentos;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author valer
 */
public class Municipio {

    private String capital;
    private String municipio;
    private Departamento depart;

    public Municipio(String municipio, String capital, String depart) {
        this.capital = capital;
        this.municipio = municipio;
        this.depart = Departamento.buscarDepartamento(depart);
    }

    public Departamento obtenerDepartamento() {
        return depart;
    }

    public String obtenerMunicipio() {
        return municipio;
    }

    public String obtenerCapital() {
        return capital;
    }

    private static Municipio[] municipios;

    public static void ObtenerRegiones(String[][] datos) {

        municipios = new Municipio[datos.length];
        for (int i = 0; i < datos.length; i++) {
            municipios[i] = new Municipio(datos[i][1], //municipio
                    datos[i][2], //capital
                    datos[i][0]);  //depart          
        }
    }

    public static void mostrar(JTable tbl, Departamento d) {
        String[] encabezados = new String[]{"Municipio", "Capital"};
        //Contar las regiones del pais
        int totalMunicipios = 0;
        for (int i = 0; i < municipios.length; i++) {
            if (d.obtenerDepartamento().equals(municipios[i].obtenerDepartamento().obtenerDepartamento())) {
                totalMunicipios++;
            }
        }
        String[][] datos = new String[totalMunicipios][2];
        totalMunicipios = 0;
        for (int i = 0; i < municipios.length; i++) {
            if (d.obtenerDepartamento().equals(municipios[i].obtenerDepartamento().obtenerDepartamento())) {
                datos[totalMunicipios][0] = municipios[i].obtenerMunicipio();
                datos[totalMunicipios][1] = municipios[i].obtenerCapital();
                totalMunicipios++;
            }
        }
        tbl.setModel(new DefaultTableModel(datos, encabezados));

    }
}
