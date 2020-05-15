/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2;

import java.util.ArrayList;

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

public class Year {
    private String year;
    private ArrayList<Book> books;

    /**
     *
     * @param year
     */
    public Year(String year) {
        this.year = year;
        this.books = new ArrayList<Book>();
    }

    /**
     *
     * @return String
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @return ArrayList
     */
    public ArrayList<Book> getBooks() { // caso não for usar, lembrar de apagar
        return books;
    }
    
    /**
     *
     * @param book
     */
    public void newBook(Book book) {
        this.books.add(book);
    }
}

