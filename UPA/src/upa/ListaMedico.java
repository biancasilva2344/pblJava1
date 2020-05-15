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
public class ListaMedico {
    private No primeiro;
    private No ultimo;
    private int qtd;
    
    /**
     * Método construtor, da classe ListaMedico.
     */
    public ListaMedico(){
        this.primeiro = null;
        this.ultimo = null;
        this.qtd = 0;
    }

    /**
     *  Método getPrimeiro, da classe ListaMedico.
     * @return primeiro
     */
    public No getPrimeiro() {
        return primeiro;
    }

    /**
     *  Método setPrimeiro, da classe ListaMedico.
     * @param primeiro
     */
    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    /**
     *  Método getUltimo, da classe ListaMedico.
     * @return ultimo
     */
    public No getUltimo() {
        return ultimo;
    }

    /**
     *  Método setUltimo, da classe ListaMedico.
     * @param ultimo
     */
    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    /**
     *  Método getQtd, da classe ListaMedico.
     * @return qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     *  Método setQtd, da classe ListaMedico.
     * @param qtd
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    /**
     * Método eVazia, da classe ListaMedico.
     * Método para saber se a lista está vazia.
     * @return boolean
     */
    public boolean eVazia(){
        return (this.primeiro == null);
        
    }
    
    /**
     * Método inserirPrimeiro, da classe ListaMedico.
     * Insere o médico na primeira posição da lista.
     * @param m
     */
    public void inserirPrimeiro(Medico m){
        No novoNo = new No(m);
        if(this.eVazia()){ // verifica se a lista é vazia
            this.ultimo = novoNo;
        }
        novoNo.setProximo(this.primeiro);
        this.primeiro = novoNo;
        this.qtd++;
    }
    
    /**
     * Método procurarNo, da classe ListaMedico.
     * Procura o nó em que o médico solicitado pelo usário está.
     * Para poder ser possível alterar o nome.
     * @param crmProcurado
     * @return atual
     */
    public No procurarNo(String crmProcurado){
        No atual = this.primeiro;
        if(atual == null)
            return null;
        else{
        while(!atual.getMedico().getCrm().equals(crmProcurado)){
            if(atual.getProximo() == null)
                return null;
            else
                atual = atual.getProximo();
        }
        }
    return atual;
    }
    
    /**
     * Método posicao, da classe ListaMedico.
     * retorna um médico da posição dada.
     * @param p
     * @return medico
     */
    public Medico posicao(int p){
        if (p> this.qtd) return null;
        No aux = this.primeiro;
        for (int i =0; i<p; i++){
            aux = aux.getProximo();
        }
        return aux.getMedico();
    }
    
    /**
     * Método editarNome, da classe ListaMedico.
     * Dado o CRM do médico edita o nome.
     * @param crmProcurado
     * @param nome
     */
    public void editarNome(String crmProcurado,String nome){
       this.procurarNo(crmProcurado).getMedico().setNome(nome);
        
    }
    /**
     * Método menorLista, da classe ListaMedico.
     * Procurar qual médico tem a lista de paciente menor.
     * @return menor
     */
    public No menorLista(){      
        No menor = this.primeiro;
        No atual = this.primeiro;
        for (int i = 0; i< this.qtd;i++){
            if(atual.getMedico().getListaPaciente().getQtd_p() < menor.getMedico().getListaPaciente().getQtd_p()){
                menor = atual;        
                atual = atual.getProximo();
            }
        }
        return menor;
    }
}
