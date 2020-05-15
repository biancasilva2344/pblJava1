/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
Autores: Bianca Santana de Araújo Silva e Paulo Queiroz de Carvalho
Componente Curricular: MI programação
Concluido em: 02/02/2020
Declaramos que este código foi elaborado por nós, em dupla e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a nossa está destacado com uma citação para o autor e a fonte
do código, e estamos ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/

public class ControlerTest {
    Controler cont;
    Controler contNull;
    Controler contUni;

    /**
     *
     */
    public ControlerTest() {
    }
    
    /**
     *
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    @Before
    public void setUp() throws UnsupportedEncodingException, IOException {
        cont = new Controler();
        cont.newBook("000123", "A Flor", "autor A", "Fev", "1980", "link1");
        cont.newBook("000124", "O Flor", "autor B", "Fev", "1980", "link");
        cont.newBook("000125", "E Flor", "autor A", "Fev", "1983", "link");
        try {
            FileOutputStream file = new FileOutputStream("Teste.csv");
            PrintWriter pw  = new PrintWriter(file);
            
            pw.println("N_EBOOK;TITULO;AUTOR;MES;ANO;LINK");
            pw.println("");
            pw.println("000435;O leão;Joana;Mar;2000;link3");
            pw.println("003455;O avião;Roberta;Abr;2020;link4");
            pw.println("000674;O passsaro;Lucas;Jan;2032;link6");
            pw.close();
            file.close();
            
         }   catch (FileNotFoundException ex) {
            Logger.getLogger(ControlerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        contNull = new Controler();
        contUni = new Controler();
        contUni.newBook("000125", "E Flor", "autor B", "Fev", "1983", "link");
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Teste do método NewBook, da classe Controler.
     * Teste Requisito 1 - Casdatrar Livro.
     */
    @Test
    public void testNewBook() {
        Book aux1 = (Book) cont.books.getArrayList().get(0);
        assertEquals("000123",aux1.getEBook());
        cont.newBook("000123", "Dona Maria", "Jose Carlos", "Dez", "1990", "link@ihf.com");
        Book aux2 = (Book) cont.books.getArrayList().get(2);
        assertEquals("000125",aux2.getEBook());
        aux1 = (Book) cont.books.getArrayList().get(0);
        assertEquals("autor A",aux1.getAuthor());//não sobescreveu 
        
    }

    
    /**
     * Teste do método ReadFile, da classe Controler.
     * Teste do Requisito 2 - Carregar a base de dados.
     */
    @Test
    public void testReadFile() {
        cont.readFile("Teste");
        //testando se está lendo arquivo
        assertEquals("000435",cont.books.getRoot());
        cont.readFile("naoExiste");
        //testando ao ler um arquivo que não exista a árvore deve permanecer a mesma
        assertEquals("000435",cont.books.getRoot());
        cont.readFile("Teste");
        //testando se ao ler o mesmo arquivo a árvore permanece a mesma
        assertEquals("000435",cont.books.getRoot());
        
    }

    /**
     * Teste do método SaveFile, da classe Controler.
     * Teste do Requisito 3 - Gravar dados no arquivo.
     */
    @Test
    public void testSaveFile(){
        cont.newBook("000111", "Dona Maria", "Jose Carlos", "Dez", "1990", "link@ihf.com");
        cont.saveFile("Teste1");
        Book aux = (Book) cont.books.find("000111");
        assertEquals("000111",aux.getEBook()); 
        assertEquals("Dona Maria", aux.getTitle()); // analisa se ta salvando o titulo do livro
        assertEquals("Jose Carlos", aux.getAuthor()); // analisa se ta salvando o autor
        assertEquals("Dez",aux.getMonth()); // analisa se ta salvando o mes
        assertEquals("1990", aux.getYear()); // analisa se ta salvando o ano 
        cont.readFile("Teste");
        cont.saveFile("Teste1");
        aux = (Book) cont.books.find("003455");// atualizando a variavel aux para ver se encontra os novos arquivos 
        assertEquals("003455",aux.getEBook());// encontrando os novos arquivos
        
    }

    /**
     * Teste do método PrintAuthorsQuant, da classe Controler.
     * Teste do Requisito 4 - Listagem de Autores/Quantidade.
     */
    @Test
    public void testPrintAuthorsQuant() {
        assertTrue(cont.printAuthorsQuant());// testando funcionamento normal
        assertTrue(contNull.printAuthorsQuant());//testando funcionamento sem nenhum livro adicionado
        assertTrue(contUni.printAuthorsQuant());//testando funcionamento apenas com um livro
    }

    /**
     * Teste do método printAuthorBooks, da classe Controler.
     * Teste do Requisito 5 - Listagem de Autores/Livros.
     */
    @Test
    public void testPrintAuthorBooks() {
        assertTrue(cont.printAuthorBooks("autor A"));// testando funcionamento normal
        assertTrue(contNull.printAuthorBooks("autor A"));//testando funcionamento sem nenhum livro adicionado
        assertTrue(contUni.printAuthorBooks("autor B"));//testando funcionamento apenas com um livro
        assertTrue(cont.printAuthorBooks("Mariana"));// Quando o Autor não existe
        
    }

    /**
     * Teste do método printBooks, da classe Controler.
     * Teste do Requisito 6 - Listagem Livros.
     */
    @Test
    public void testPrintBooks() {
        assertTrue(cont.printBooks());// testando funcionamento normal
        assertTrue(contNull.printBooks());//testando funcionamento sem nenhum livro adicionado
        assertTrue(contUni.printBooks());//testando funcionamento apenas com um livro
    }

    /**
     * Teste do método printLinkBook, da classe Controler.
     * Teste do Requisito 7 - Buscar Livro.
     */
    @Test
    public void testPrintLinkBook() {
        assertTrue(cont.printLinkBook("000124"));// testando funcionamento normal
        assertTrue(contNull.printLinkBook("000124"));//testando funcionamento sem nenhum livro adicionado
        assertTrue(contUni.printLinkBook("000123"));//testando funcionamento apenas com um livro
        assertTrue(cont.printLinkBook("000156"));// Quando o eBook não existe
    }

    /**
     * Teste do método printYearBooks, da classe Controler.
     * Teste do Requisito 8 - Buscar Livro/Ano.
     */
    @Test
    public void testPrintYearBooks() {
        assertTrue(cont.printYearBooks("1983"));// testando funcionamento normal
        assertTrue(contNull.printYearBooks("1983"));//testando funcionamento sem nenhum livro adicionado
        assertTrue(contUni.printYearBooks("1980"));//testando funcionamento apenas com um livro
        assertTrue(cont.printYearBooks("1980"));// Quando o ano não existe
    }

    /**
     * Teste do método deletBook, da classe Controler.
     * Teste do Requisito 9 - Excluir Livro.
     */
    @Test
    public void testDeletBook() {
        assertTrue(cont.deletBook("000123"));
        assertEquals(null,cont.books.find("000123"));//procurando na árvore de livro o livro deletado
        assertFalse(cont.deletBook("000555"));//Tentando deletar livro não existente
        Year aux = (Year) cont.year.find("1980");//Pegando o ano em que o livro retirado pertencia
        assertEquals(1,aux.getBooks().size());// Analisa se na lista de livro por ano foi retirado o livro
        Autor aux1 = (Autor) cont.authors.find("autor A");//Pegando o autor em que o livro retirado pertencia
        assertEquals(1,aux.getBooks().size());// Analisa se na lista de livro por autor foi retirado o livro
        
    }
  
}
