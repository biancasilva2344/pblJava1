/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bianca Santana de Araujo Silva
 */
public class ListaPacienteTest {
    ListaPaciente listaPaciente;
    Paciente p1, p2, p3;
    Medico m1, m2;
    ListaMedico listaMedico;

    /**
     * Método construtor, da classe ListaPacienteTest.
     */
    public ListaPacienteTest() {
    }
    
    /**
     *  Inicializando lista e atributos
     */
    @Before
    public void setUp() {
        listaMedico = new ListaMedico();
        m1 = new Medico("joao","44");
        m2 = new Medico("Joana", "76");
        listaMedico.inserirPrimeiro(m1);
        listaMedico.inserirPrimeiro(m2);
        p1 = new Paciente("jose", "42", true);
        p2 = new Paciente("maria", "34", false);
        p3 = new Paciente("carlos", "22", false);
    }
    

    /**
     * Testes dos metodos inserirUltimo e inserirPrioridade, da classe ListaPaciente.
     * Teste do metodo menorLista, da classe ListaMedico.
     * Testando se os pacientes da lista são inseridos na ordem certa e se são inseridos no médico com a menor lista.
     * Requisito 3.
     */
    @Test
    public void testInserir() {
        No aux = listaMedico.menorLista();
        aux.getMedico().getListaPaciente().inserirPrioridade(p1);
        
        assertEquals(p1,aux.getMedico().getListaPaciente().posicao(0));
        assertEquals(1,aux.getMedico().getListaPaciente().getQtd_p());
        
        aux.getMedico().getListaPaciente().inserirUltimo(p2);
        
        assertEquals(p2,aux.getMedico().getListaPaciente().posicao(1));
        
        aux.getMedico().getListaPaciente().inserirUltimo(p3);
        
        assertEquals(p3,aux.getMedico().getListaPaciente().getUltimo_p().getPaciente());
        
        Paciente p4 = new Paciente("josefa", "11", true);
        aux.getMedico().getListaPaciente().inserirPrioridade(p4);
        
        assertNotEquals(p4 ,aux.getMedico().getListaPaciente().getUltimo_p().getPaciente());
        assertEquals(p4, aux.getMedico().getListaPaciente().posicao(1));
        assertEquals(p2, aux.getMedico().getListaPaciente().posicao(2));
        
        assertEquals(m2, listaMedico.menorLista().getMedico());
    }

    /**
     * Teste do método removerInicio, da classe ListaPaciente.
     * Testando se está removendo o primeiro paciente da lista de paciente do médico desejado.
     * Requisito 5.
     */
    @Test
    public void testRemoverInicio() {
        m1.getListaPaciente().inserirPrioridade(p1);
        m2.getListaPaciente().inserirUltimo(p2);
        m1.getListaPaciente().inserirUltimo(p3);

        m1.getListaPaciente().removerInicio();
        assertEquals(p3,m1.getListaPaciente().getPrimeiro_p().getPaciente());
        m2.getListaPaciente().removerInicio();
        assertEquals(true, m2.getListaPaciente().eVazia());
        
        
    }
    
}
