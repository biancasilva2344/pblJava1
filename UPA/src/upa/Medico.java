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
public class Medico {
    private String nome;
    private String crm;
    private ListaPaciente listaPaciente = new ListaPaciente();
    private ListaAtendidos listaAtendidos = new ListaAtendidos();
    
    /**
     * Método construtor, da classe Medico.
     * @param nome
     * @param crm
     */
    public Medico(String nome, String crm){
        this.nome=nome;
        this.crm=crm;
    }

    /**
     *  Método getNome, da classe Medico.
     * @return nome
     */
    public String getNome(){
        return nome;
    }
    
    /**
     *  Método setNome, da classe Medico.
     * @param nome
     */
    public void setNome(String nome){
        this.nome=nome;
    }
    
    /**
     *  Método getCrm, da classe Medico.
     * @return crm
     */
    public String getCrm(){
        return crm;
    }
    
    /**
     *  Método setCrm, da classe Medico.
     * @param crm
     */
    public void setCrm(String crm){
        this.crm=crm;
    }

    /**
     *  Método getListaPaciente, da classe Medico.
     * @return listaPaciente
     */
    public ListaPaciente getListaPaciente() {
        return listaPaciente;
    }

    /**
     *  Método setListaPaciente, da classe Medico.
     * @param listaPaciente
     */
    public void setListaPaciente(ListaPaciente listaPaciente) {
        this.listaPaciente = listaPaciente;
    }

    /**
     *  Método getListaAtendidos, da classe Medico.
     * @return listaAtendidos
     */
    public ListaAtendidos getListaAtendidos() {
        return listaAtendidos;
    }

    /**
     *  Método setListaAtendidos, da classe Medico.
     * @param listaAtendidos
     */
    public void setListaAtendidos(ListaAtendidos listaAtendidos) {
        this.listaAtendidos = listaAtendidos;
    }
    
}
