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
public class ListaGeral {
    private No primeiro_G;
    private ListaPaciente listaPaciente;
    private No ultimo_G;
    /**
     * Método construtor, da classe ListaGeral.
     */
    public ListaGeral(){
        this.listaPaciente = new ListaPaciente();
    }

    /**
     *  Método getListaPaciente, da classe ListaGeral.
     * @return listaPaciente
     */
    public ListaPaciente getListaPaciente() {
        return listaPaciente;
    }

    /**
     *  Método setListaPaciente, da classe ListaGeral.
     * @param listaPaciente
     */
    public void setListaPaciente(ListaPaciente listaPaciente) {
        this.listaPaciente = listaPaciente;
    }
    
    /**
     *  Método eVazia, da classe ListaGeral.
     *  Verifica se a lista está vazia.
     * @return boolean
     */
    public boolean eVazia(){
        return this.primeiro_G == null;
    }


    public boolean remover(String matricula){
        No atual = this.listaPaciente.getPrimeiro_p();
        No ant = null;
        while(atual != null && !atual.getPaciente().getMatricula().equals(matricula) ){
                ant = atual;
                atual = atual.getProximo();
            
        }
        if(atual==this.listaPaciente.getPrimeiro_p()){
            if(this.listaPaciente.getPrimeiro_p() == this.listaPaciente.getUltimo_p())
           //     this.listaPaciente.getUltimo_p() = null;
            this.primeiro_G = this.primeiro_G.getProximo();
        }
        else{
            if(this.primeiro_G==this.ultimo_G)
                this.ultimo_G=ant;
            ant.setProximo(atual.getProximo());
        }
        return true;
    }
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        No aux = this.listaPaciente.getPrimeiro_p();
        for(int i = 0; i<this.listaPaciente.getQtd_p(); i++){
            System.out.println("Nome do exame:");
            System.out.println(aux.getPaciente().getListaExame());
            aux = aux.getProximo();
        }
        return "";
    }
}
