/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Bianca Santana de Araujo Silva
 */
public class ListaMedicoTest {
    ListaMedico listaMedico;
    Medico m1;
    Medico m2;

    /**
     *  Método construtor, da classe ListaMedicoTest.
     */
    public ListaMedicoTest() {
        
    }
    
    /**
     * Inicializando a lista e os atributos.
     */
    @Before
    public void setUp() {
        listaMedico = new ListaMedico();
        m1 = new Medico("joao","44");
        m2 = new Medico("Joana", "76");
        
    }
    
    /**
     * Teste do metodo eVazia, da classe ListaMedico.
     * Verifica se a lista está vazia.
     */
    @Test
    public void testEVazia() {
        assertEquals(true,listaMedico.eVazia());
    }

    /**
     * Teste do metodo inserirPrimeiro, da classe ListaMedico.
     * Verifica se está inserindo os medicos na lista.
     * Requisito 1.
     */
    @Test
    public void testInserirPrimeiro() {
        listaMedico.inserirPrimeiro(m1);
        listaMedico.inserirPrimeiro(m2);
        assertNotEquals(m2,listaMedico.getUltimo().getMedico()); 
        assertEquals(m1,listaMedico.getUltimo().getMedico());
        assertEquals(m2,listaMedico.getPrimeiro().getMedico());
        assertNotEquals(true,listaMedico.eVazia());
    }
    
    /**
     * Teste do metodo procurarNo, da classe ListaMedico.
     * Verifica se está procurando o medico solicitado.
     * Requisito 2.
     */
    @Test
    public void procurarNo(){
        listaMedico.inserirPrimeiro(m1);
        listaMedico.inserirPrimeiro(m2);
        No result = listaMedico.procurarNo("76");
        assertEquals(listaMedico.getPrimeiro().getMedico().getCrm() ,result.getMedico().getCrm());
        assertEquals(m2,result.getMedico());
        assertEquals(null,listaMedico.procurarNo("555"));
      
    }
    /**
     * Teste do metodo editarNome, da classe ListaMedico.
     * Verifica se está alterando o nome desejado.
     * Requisito 2.
     */
    @Test
    public void editarNome(){
        listaMedico.inserirPrimeiro(m1);
        listaMedico.inserirPrimeiro(m2);
        listaMedico.editarNome("76", "Marta");
        assertEquals(m2.getNome(),listaMedico.getPrimeiro().getMedico().getNome());
    }
    
}
