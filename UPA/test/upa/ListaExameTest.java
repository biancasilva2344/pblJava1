/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bianca Santana de Araujo Silva
 */
public class ListaExameTest {
    private ListaExame listaExame;
    private Paciente p1, p2, p3;
    private Medico m1,m2;
    private ListaMedico listaMedico;
    private Exame e1;
    private ListaGeral listaGeral;

    /**
     * Método construtor de ListaExameTest
     */
    public ListaExameTest() {
    }
    
    /**
     * Inicializando listas e atributos.
     */
    @Before
    public void setUp() {
        listaMedico = new ListaMedico();
        listaExame = new ListaExame();
        listaGeral = new ListaGeral();
        m1 = new Medico("joao","44");
        m2 = new Medico("Joana", "76");
        listaMedico.inserirPrimeiro(m1);
        listaMedico.inserirPrimeiro(m2);
        p1 = new Paciente("jose", "42", true);
        p2 = new Paciente("maria", "34", false);
        p3 = new Paciente("carlos", "22", false);
        m1.getListaPaciente().inserirPrioridade(p1);
        m1.getListaPaciente().inserirUltimo(p2);
        m2.getListaPaciente().inserirUltimo(p3);
        e1 = new Exame("DNA");
    }
    
    /**
     *
     */
    @Test
    public void testEVazia() {
        assertEquals(true,listaExame.eVazia());
    }

    /**
     * Teste do método inserirPrimeiro, da classe ListaExame.
     * Testando requisito 6, 7, 8 e 9.
     * Verifica se o tipo de exame foi inserido na lista de exames, se o exame foi inserido na lista
     * de exames do paciente, se o paciente foi adicionado na lista geral de atendimentos e se foi inserido
     * na lista de atendidos do medico.
     * Verifica também se a ordem desejada de inserção está correta.
     */
    @Test
    public void testInserir() {
        No aux = m1.getListaPaciente().removerInicio();
        assertEquals(p1,aux.getPaciente());
        m1.getListaAtendidos().getListaPaciente().inserirUltimo(aux.getPaciente());
            assertEquals(aux.getPaciente(),m1.getListaAtendidos().getListaPaciente().getPrimeiro_p().getPaciente());
        listaExame.inserirPrimeiro(e1);// inserindo tipo de exame na lista de exame
            assertEquals(e1,listaExame.getPrimeiro_E().getExame());
        e1.getListaPaciente().inserirUltimo(p1);// inserindo paciente na fila de exame
            assertEquals(p1,listaExame.getPrimeiro_E().getExame().getListaPaciente().getPrimeiro_p().getPaciente());
        p1.getListaExame().inserirPrimeiro(e1);// inserindo tipo de exame na lista de exames do paciente
            assertEquals(e1, p1.getListaExame().getPrimeiro_E().getExame());
        listaGeral.getListaPaciente().inserirUltimo(p1);// inserindo paciente na lista geral de atendimento
            assertEquals(p1,listaGeral.getListaPaciente().getPrimeiro_p().getPaciente());
       
        No aux2 = m1.getListaPaciente().removerInicio();
        assertEquals(p2,aux2.getPaciente());
        m1.getListaAtendidos().getListaPaciente().inserirUltimo(aux2.getPaciente());
            assertEquals(aux2.getPaciente(),m1.getListaAtendidos().getListaPaciente().getUltimo_p().getPaciente());
        e1.getListaPaciente().inserirUltimo(p2);
            assertEquals(p2,listaExame.getPrimeiro_E().getExame().getListaPaciente().getUltimo_p().getPaciente());
        p2.getListaExame().inserirPrimeiro(e1);
            assertEquals(e1, p2.getListaExame().getPrimeiro_E().getExame());
        listaGeral.getListaPaciente().inserirUltimo(p2);
            assertEquals(p2,listaGeral.getListaPaciente().getUltimo_p().getPaciente());
        
     
    }

    /**
     * Teste do método buscaExame, da classe ListaExame.
     * Método usado requisito 6, 7 e 10.
     * Procurando se o exame existe na lista e o retorna.
     */
    @Test
    public void testBuscaExame() {
        listaExame.inserirPrimeiro(e1);
        No result = listaExame.buscaExame("DNA");
        assertEquals(e1,result.getExame());
        assertEquals(null, listaExame.buscaExame("SANGUE"));
    }


    
}
