/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2;

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

public class Book {
    private String eBook;
    private String title;
    private String author;
    private String month;
    private String year;
    private String link;

    /**
     *
     * @param eBook
     * @param title
     * @param author
     * @param month
     * @param year
     * @param link
     */
    public Book(String eBook, String title, String author, String month, String year, String link) {
        this.eBook = eBook;
        this.title = title;
        this.author = author;
        this.month = month;
        this.year = year;
        this.link = link;
    }

    /**
     *
     * @return String
     */
    public String getEBook() {
        return this.eBook;
    }

    /**
     *
     * @return String
     */
    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @return String
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     *
     * @return String
     */
    public String getMonth() {
        return this.month;
    }

    /**
     *
     * @return String
     */
    public String getYear() {
        return this.year;
    }

    /**
     *
     * @return String
     */
    public String getLink() {
        return this.link;
    }
 
}
