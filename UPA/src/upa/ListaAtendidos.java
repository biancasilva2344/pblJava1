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
public class ListaAtendidos {
    private ListaPaciente listaPaciente;
    
    /**
     *  Método construtor, da classe ListaAtendidos.
     */
    public ListaAtendidos(){
        this.listaPaciente = new ListaPaciente();
    }

    /**
     *  Método getListaPaciente, da classe ListaAtendidos.
     * @return listaPaciente
     */
    public ListaPaciente getListaPaciente() {
        return listaPaciente;
    }

    /**
     *  Método setListaPaciente, da classe ListaAtendidos.
     * @param listaPaciente
     */
    public void setListaPaciente(ListaPaciente listaPaciente) {
        this.listaPaciente = listaPaciente;
    }
    
    /**
     * Método toString, da classe ListaAtendidos.
     * Imprimi a matricula dos pacientes que já foram atendidos.
     * @return lista de paciente
     */
    @Override
    public String toString() {
        if(this.listaPaciente.getQtd_p()== 0) 
            return "Lista vazia";
        No aux = this.listaPaciente.getPrimeiro_p();
        for(int i = 0; i<this.listaPaciente.getQtd_p(); i++){
            System.out.println("Nome:");
            System.out.println(aux.getPaciente().getNome());
            aux = aux.getProximo();
        }
        return "";
    }
}
  
