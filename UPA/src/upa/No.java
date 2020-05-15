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
public class No {
    private No proximo;
    private Medico medico;
    private Paciente paciente;
    private Exame exame;
    
    /**
     *  Método construtor de medico, da classe No.
     * @param medico
     */
    public No(Medico medico) {
        this.proximo = null;
        this.medico = medico;
    }

    /**
     *  Método construtor de paciente, da classe No.
     * @param paciente
     */
    public No (Paciente paciente){
        this.proximo = null;
        this.paciente = paciente;
    }
    
    /**
     *  Método construtor de exame, da classe No.
     * @param exame
     */
    public No(Exame exame){
        this.proximo = null;
        this.exame = exame;
    }
    
    /**
     * Método getProximo, da classe No.
     * @return proximo
     */
    public No getProximo() {
        return proximo;
    }

    /**
     *  Método setProximo, da classe No.
     * @param proximo
     */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    /**
     *  Método getMedico, da classe No.
     * @return medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     *  Método setMedico, da classe No.
     * @param medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    /**
     *  Método getPaciente, da classe No.
     * @return
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     *  Método setPaciente, da classe No.
     * @param paciente
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    /**
     *  Método geteExame, da classe No.
     * @return exame
     */
    public Exame getExame() {
        return exame;
    }

    /**
     *  Método getExame, da classe No.
     * @param exame
     */
    public void setExame(Exame exame) {
        this.exame = exame;
    }

}
