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
public class ListaExame {
    private No primeiro_E;
    private No ultimo_E;
    private int qtd_E;

    /**
     * Método construtor, da classe ListaExame.
     */
    public ListaExame() {
        this.primeiro_E = null;
        this.ultimo_E = null;
        this.qtd_E = 0;
    }

    /**
     *  Método getPrimeiro_E, da classe ListaExame.
     * @return primeiro_E
     */
    public No getPrimeiro_E() {
        return primeiro_E;
    }

    /**
     *  Método setPrimeiro_E, da classe ListaExame.
     * @param primeiro_E
     */
    public void setPrimeiro_E(No primeiro_E) {
        this.primeiro_E = primeiro_E;
    }

    /**
     * Método getUltimo_E, da classe ListaExame.
     * @return ultimo_E
     */
    public No getUltimo_E() {
        return ultimo_E;
    }

    /**
     *  Método setUltimo_E, da classe ListaExame.
     * @param ultimo_E
     */
    public void setUltimo_E(No ultimo_E) {
        this.ultimo_E = ultimo_E;
    }

    /**
     *  Método getQtd_E, da classe ListaExame.
     * @return qtd_E
     */
    public int getQtd_E() {
        return qtd_E;
    }

    /**
     *  Método setQtd_E, da classe ListaExame.
     * @param qtd_E
     */
    public void setQtd_E(int qtd_E) {
        this.qtd_E = qtd_E;
    }
    
    /**
     *  Método eVazia, da classe ListaExame.
     *  Verifica se a lista está vazia.
     * @return boolean
     */
    public boolean eVazia(){
        return (this.primeiro_E == null);
        
    }
    
    /**
     *  Método inserirPrimeiro, da classe ListaExame.
     *  Insere o tipo de exame na primeira posição da lista.
     * @param exame
     */
    public void inserirPrimeiro(Exame exame){
        No novoExame = new No(exame);
        if(this.eVazia()==true){
            this.ultimo_E=novoExame;
        }
        novoExame.setProximo(this.primeiro_E);
        this.primeiro_E = novoExame;
        this.qtd_E++;
    }
    
    /**
     *  Método buscaExame, da classe ListaExame.
     *  Verifica se o exame está na lista. 
     * @param tipoExame
     * @return atual
     */
    public No buscaExame(String tipoExame){
        No atual = this.primeiro_E;
        if(atual == null)
            return null;
        else{
            while(!atual.getExame().getTipoExame().equals(tipoExame)){
                if(atual.getProximo() == null)
                    return null;
                else
                    atual = atual.getProximo();
            }
        }
        return atual;
    }
     
    /**
     *  Método toString, da classe ListaExame.
     *  Lista todos os paciente que tem dentro de um exame.
     * @return lista de paciente 
     */
    @Override
    public String toString() {
        No aux = this.primeiro_E;
        for(int i = 0; i<this.qtd_E; i++){
            System.out.println(aux.getPaciente().getNome());
            aux = aux.getProximo();
        }
        return "";
    }
}
