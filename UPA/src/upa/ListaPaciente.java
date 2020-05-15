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
public class ListaPaciente {

    private No primeiro_p;
    private No ultimo_p;
    private int qtd_p;

    /**
     *  Método construtor, da classe ListaPaciente.
     */
    public ListaPaciente() {
        this.primeiro_p = null;
        this.ultimo_p = null;
        this.qtd_p = 0;
    }

    /**
     *  Método getPrimeiro_p, da classe ListaPaciente.
     * @return  primeiro_p
     */
    public No getPrimeiro_p() {
        return primeiro_p;
    }

    /**
     *  Método setPrimeiro_p, da classe ListaPaciente.
     * @param primeiro_p
     */
    public void setPrimeiro_p(No primeiro_p) {
        this.primeiro_p = primeiro_p;
    }

    /**
     *  Método getUltimo_p, da classe ListaPaciente.
     * @return  ultimo_p
     */
    public No getUltimo_p() {
        return ultimo_p;
    }

    /**
     *  Método setUltimo, da classe ListaPaciente.
     * @param ultimo_p
     */
    public void setUltimo_p(No ultimo_p) {
        this.ultimo_p = ultimo_p;
    }

    /**
     *  Método getQtd_p, da classe ListaPaciente.
     * @return qtd_p
     */
    public int getQtd_p() {
        return qtd_p;
    }

    /**
     *  Método setQtd_p, da classe ListaPaciente.
     * @param qtd_p
     */
    public void setQtd_p(int qtd_p) {
        this.qtd_p = qtd_p;
    }
    
    /**
     *  Método eVazia, da classe ListaPaciente.
     *  Analisar se a lista está vazia.
     * @return boolean
     */
    public boolean eVazia(){
        return (this.primeiro_p == null);      
    }
    
    /**
     *  Método inserirUltimo, da classe ListaPaciente.
     *  Insere na ultima posição da lista.
     * @param paciente
     */
    public void inserirUltimo(Paciente paciente) {
        No novoPaciente = new No(paciente);
        if (this.qtd_p == 0) {
            this.primeiro_p = novoPaciente;
        } else {
            this.ultimo_p.setProximo(novoPaciente);
        }
        this.ultimo_p = novoPaciente;
        this.qtd_p++;
    }

    /**
     *  Método inserirPrioridade, da classe ListaPaciente.
     *  Insere os pacientes que são prioridade acima dos não prioridade.
     * @param paciente
     */
    public void inserirPrioridade(Paciente paciente) {
        No novoPaciente = new No(paciente);
        No aux = this.primeiro_p;
        No ant = aux;
        if (this.qtd_p == 0) {
            this.primeiro_p = novoPaciente;
            this.ultimo_p = this.primeiro_p;
            qtd_p++;
        } else {
            if (this.primeiro_p.getPaciente().getPrioridade() == false) {
                novoPaciente.setProximo(primeiro_p);
                this.primeiro_p = novoPaciente;
                this.qtd_p++;

            } else {
                while (aux != null && aux.getPaciente().getPrioridade() == true) {
                    ant = aux;
                    aux = aux.getProximo();
                }
                ant.setProximo(novoPaciente);
                novoPaciente.setProximo(aux);
                this.qtd_p++;
            }
        }
    }

    /**
     *  Método removerInicio, da classe ListaPaciente.
     *  Remove o paciente do inicio da lista e o retorna.
     * @return ant
     */
    public No removerInicio() {
        No atual = this.primeiro_p;
        No ant = this.primeiro_p;
        if (this.qtd_p == 0) {
            return null;
        } else {
            atual = this.primeiro_p.getProximo();
            this.primeiro_p = atual;
        }
        return ant;
    }
    
    /**
     *  Método posicao, da classe ListaPaciente.
     *  Permite acessar o paciente em uma determinada posição da lista.
     * @param p
     * @return paciente
     */
    public Paciente posicao(int p){
        if (p> this.qtd_p) return null;
        No aux = this.primeiro_p;
        for (int i =0; i<p; i++){
            aux = aux.getProximo();
        }
        return aux.getPaciente();
    }

    /**
     *  Método toString, da classe ListaPaciente.
     *  Imprimi a/as matricula/as dos paciente que contém na lista.
     * @return
     */
    @Override
    public String toString() {
        if(this.qtd_p==0) 
            return "Lista vazia";
        No aux = this.primeiro_p;
        for(int i = 0; i<this.qtd_p; i++){
            System.out.println("Matricula:");
            System.out.println(aux.getPaciente().getMatricula());
            aux = aux.getProximo();
        }
        return "";
    }
    /**
     *  Método buscaPaciente, da classe ListaGeral.
     *  Procura a matricula do paciente na lista geral.
     * @param matricula
     * @return atual
     */
    public No buscaPaciente(String matricula){
        No atual = this.primeiro_p;
        if(atual == null)
            return null;
        else{
            while(!atual.getPaciente().getMatricula().equals(matricula)){
                if(atual.getProximo() == null)
                    return null;
                else
                    atual = atual.getProximo();
            }
        }
        return atual;
    }
    
    
}
