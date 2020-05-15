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
public class Paciente {
    private String nome;
    private String matricula;
    private boolean prioridade;
    private ListaExame listaExame = new ListaExame();
    
    /**
     * Método construtor, da classe Paciente.
     * @param nome
     * @param matricula
     * @param prioridade
     */
    public Paciente(String nome, String matricula, boolean prioridade){
        this.nome=nome;
        this.matricula=matricula;
        this.prioridade=prioridade;
    }

    /**
     *  Método getListaExame, da classe Paciente.
     * @return listaExame
     */
    public ListaExame getListaExame() {
        return listaExame;
    }

    /**
     *  Método serListaExame, da classe Paciente.
     * @param listaExame
     */
    public void setListaExame(ListaExame listaExame) {
        this.listaExame = listaExame;
    }
    
    /**
     *  Método getNome, da classe Paciente.
     * @return nome
     */
    public String getNome(){
        return nome;
    }
    
    /**
     *  Método setNome, da classe Paciente.
     * @param nome
     */
    public void setNome(String nome){
        this.nome=nome;
    }
    
    /**
     *  Método getMatricula, da classe Paciente.
     * @return matricula
     */
    public String getMatricula(){
        return matricula;
    }
            
    /**
     *  Método setMatricula, da classe Paciente.
     * @param matricula
     */
    public void setMatricula(String matricula){
        this.matricula=matricula;
    }
    
    /**
     *  Método getprioridade, da classe Paciente.
     * @return prioridade
     */
    public boolean getPrioridade(){
        return prioridade;
    }
    
    /**
     *  Método setPrioridade, da classe Paciente.
     * @param prioridade
     */
    public void setPrioridade(boolean prioridade){
        this.prioridade=prioridade;
    }

    /**
     *  Método toString, da classe Paciente.
     * @return nome,matricula
     */
    @Override
    public String toString() {
        return "Paciente" + "nome=" + nome + ", matricula=" + matricula;
    }
    
}
