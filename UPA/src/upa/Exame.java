
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upa;

/**
 *
 * @author Bianca Santana de Araujo Silva
 */
public class Exame {
    private String tipoExame;
    private ListaPaciente listaPaciente;
            
    /**
     *  Método construtor, da classe Exame.
     * @param tipoExame
     */
    public Exame(String tipoExame) {
        this.tipoExame = tipoExame;
        listaPaciente = new ListaPaciente();
    }

    /**
     *  Método getListaPaciente, da classe Exame.
     * @return listaPaciente
     */
    public ListaPaciente getListaPaciente() {
        return listaPaciente;
    }

    /**
     *  Método setListaPaciente, da classe Exame.
     * @param listaPaciente
     */
    public void setListaPaciente(ListaPaciente listaPaciente) {
        this.listaPaciente = listaPaciente;
    }
    
    /**
     *  Método getTipoExame, da classe Exame.
     * @return tipoExame
     */
    public String getTipoExame() {
        return tipoExame;
    }

    /**
     *  Método setTipoExame, da classe Exame.
     * @param tipoExame
     */
    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    /**
     *  Método toString, da classe Exame.
     * @return tipoExame
     */
    @Override
    public String toString() {
        return tipoExame;
    }

    

}
