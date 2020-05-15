/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;

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

public class Controler {

    /**
     *
     */
    public Tree books;

    /**
     *
     */
    public Tree authors;

    /**
     *
     */
    public Tree year;
    
    /**
     *  Método construtor da classe controler.
     */
    public Controler(){
        this.authors = new Tree();
        this.books = new Tree();
        this.year = new Tree();
    }
    
    /**
     *  Método que realiza o requisito 1- Cadastrar livro, inserindo o livro nas árvores e deletando arquivos
     *  de buscas existente com aquele autor e ano.
     * @param eBook
     * @param title
     * @param author
     * @param month
     * @param year
     * @param link
     */
    public void newBook(String eBook, String title, String author, String month, String year, String link){
        if (books.find(eBook) == null){
            
            Book newBook = new Book(eBook, title, author, month, year, link);
            this.books.insert(newBook.getEBook(), newBook);
            
            if (this.authors.find(author) == null){
                this.authors.insert(author, new Autor(author));
            }
            Autor thisAutor = (Autor) this.authors.find(author); //Encontra o Objeto Autor com o nome do novo livro, quardando-a na variavel "thisAutor"
            thisAutor.newBook(newBook);
            
            File f1 = new File(author+".csv");
            f1.delete();
            
            if (this.year.find(year) == null){
                this.year.insert(year, new Year(year));
            }
            Year thisYear = (Year) this.year.find(year);
            thisYear.newBook(newBook);
            
            File f2 = new File(year+".csv");
            f2.delete();
                
            
        } else {
            System.out.println("*O livro com o E-Book " + eBook + " ja existe, o livro " + title + " não foi adicionado*");
        }
    }
    
    /**
     *  Método que realiza o requisito 2 - Carregar base de dados, carrega os dados e sepera as informações para ser
     *  adicionada na árvore.
     * @param fileName
     */
    public void readFile(String fileName){
        
        try{           
            FileInputStream file = new FileInputStream(fileName+".csv");
            InputStreamReader input = new InputStreamReader(file, "ISO-8859-1");
            BufferedReader br = new BufferedReader(input);

            String linha;
            String[] linhaCortada;
            
            do{
                linha = br.readLine();
                if (linha != null){
                    linhaCortada = linha.split(";");
                    if (!"".equals(linhaCortada[0]) && !"N_EBOOK".equals(linhaCortada[0])){
                        this.newBook(linhaCortada[0], linhaCortada[1], linhaCortada[2], linhaCortada[3], linhaCortada[4], linhaCortada[5]);
                    }
                }
            }while(linha != null);
            br.close();
            input.close();
            file.close();
        
        }catch (Exception e){
            System.out.println("*Erro na leitura");
        }
    }
    
    /**
     *  Método que realiza o requisito 3- Grava arquivo, escreve todos os livros no arquivo csv.
     * @param fileName
     */
    public void saveFile(String fileName){
        try{
            FileOutputStream file = new FileOutputStream(fileName+".csv");
            PrintWriter pw  = new PrintWriter(file);
            
            Iterator<Object> inte;
            Book bk;
            inte = this.books.getArrayList().iterator();    
            
            //Coloca as duas linhas padrão do arquivo
            pw.println("N_EBOOK;TITULO;AUTOR;MES;ANO;LINK");
            pw.println("");
            
            while (inte.hasNext()){ //Analisa se ainda tem algo na ArrayList para colocar no arquivo (O metodo hasNext() retorna True ou False se apos o no que ele esta tem ou não outro no) 
                bk = (Book) inte.next(); //Pega o conteudo do no successor ao que o interetor esta e vai para a posição do no successor
                pw.println(bk.getEBook()+";"+bk.getTitle()+";"+bk.getAuthor()+";"+bk.getMonth()+";"+bk.getYear()+";"+bk.getLink());
            }

            pw.close();
            file.close();
        } catch (Exception e){
            System.out.println("Erro ao gravar");
        }
    }
    
    /**
     *  Método que realiza o requisito 4 - Lista autores/quantidade.
     * @return boolean
     */
    public boolean printAuthorsQuant(){
        Iterator<Object> inte = this.authors.getArrayList().iterator();
        Autor author;
        
        while (inte.hasNext()){
            author = (Autor) inte.next();
            System.out.println("Nome: "+author.getName()+ " | Quantidade de Obras: "+ author.getBooks().size());
        }
        return true;
    }
    
    /**
     * Método que realiza o requisito 5 - Lista autores/livros, cria arquivo csv com o nome do autor e salva seus livros neste arquivo.
     * @param name
     * @return boolean
     */
    public Boolean printAuthorBooks(String name){
        Autor author = (Autor) this.authors.find(name);
        if (author != null){
            try{
                FileInputStream file = new FileInputStream(name+".csv");
                InputStreamReader input = new InputStreamReader(file, "ISO-8859-1");
                BufferedReader br = new BufferedReader(input);
                
                String line;
                
                do{
                line = br.readLine();
                if (line != null){
                    System.out.println(line);
                }
                }while(line != null);

                br.close();
                input.close();
                file.close();

            } catch (Exception e){
                String line;
                try{
                    FileOutputStream fileSave = new FileOutputStream(name + ".csv");
                    PrintWriter pw  = new PrintWriter(fileSave);

                    Iterator<Book> inte = author.getBooks().iterator();
                    Book book;
                    pw.println("E_BOOK;Titulo");
                    System.out.println("E_BOOK;Titulo");
                    pw.println("");
                    System.out.println("");
                    while (inte.hasNext()){
                        book = inte.next();
                        line = book.getEBook()+";"+book.getTitle();
                        System.out.println(line);
                        pw.println(line);
                    }
                    pw.close();
                    fileSave.close();
                } catch (Exception i) {
                    System.out.println("*Erro ao salvar o arquivo*");
                }
            }
        } else {
            System.out.println("O autor não foi encontrado");
        }
        return true;
    }
    
    /**
     *  Método que realiza o requisito 6 - Lista livros.
     * @return boolean
     */
    public boolean printBooks(){
        Iterator<Object> iter = this.books.getArrayList().iterator();
        Book bk;
        
        while (iter.hasNext()) {
            bk = (Book) iter.next();
            System.out.println("eBook: "+bk.getEBook()+" | Titulo: "+bk.getTitle());
        }
        return true;
    }
    
    /**
     *  Método que realiza o requisito 7 - buscar livro. 
     * @param eBook
     * @return boolean
     */
    public boolean printLinkBook(String eBook){
        Book bk = (Book) this.books.find(eBook);
        if (bk != null){
            System.out.println("Link de acesso: "+bk.getLink());
        }else{
            System.out.println("*O livro com o eBook "+ eBook +" não foi encontrado*");
                    
        }
        return true;
    }
    
    /**
     * Método que realiza o requisito 8 - busca livro/ano, cria arquivo csv com o ano e salva seus livros neste arquivo.
     * @param year
     * @return boolean
     */
    public boolean printYearBooks(String year){
        Year foundYear = (Year) this.year.find(year);
        if (foundYear != null){
            try{
                FileInputStream file = new FileInputStream(year+".csv");
                InputStreamReader input = new InputStreamReader(file, "ISO-8859-1");
                BufferedReader br = new BufferedReader(input);
                
                String line;
                
                do{
                line = br.readLine();
                if (line != null){
                    System.out.println(line);
                }
                }while(line != null);

                br.close();
                input.close();
                file.close();

            } catch (Exception e){
                String line;
                try{
                    FileOutputStream fileSave = new FileOutputStream(year + ".csv");
                    PrintWriter pw  = new PrintWriter(fileSave);

                    Iterator<Book> inte = foundYear.getBooks().iterator();
                    Book bk;
                    pw.println("N_EBOOK;TITULO;AUTOR;MES;ANO;LINK");
                    System.out.println("N_EBOOK;TITULO;AUTOR;MES;ANO;LINK");
                    pw.println("");
                    System.out.println("");
                    while (inte.hasNext()){
                        bk = inte.next();
                        line = bk.getEBook()+";"+bk.getTitle()+";"+bk.getAuthor()+";"+bk.getMonth()+";"+bk.getYear()+";"+bk.getLink();
                        System.out.println(line);
                        pw.println(line);
                    }
                    pw.close();
                    fileSave.close();
                } catch (Exception i) {
                    System.out.println("*Erro ao salvar o arquivo*");
                }
            }
        } else {
            System.out.println("Nenhum livro catalogado nesse ano");
        }
        return true;
    }
    
    /**
     *  Método que realiza o requisito 9 - deleta livro, dado o ebook deleta o livro e os arquivos com autor e ano do livro.
     * @param EBook
     * @return boolean
     */
    public Boolean deletBook(String EBook){
        Book bk = (Book) this.books.find(EBook);
        if (bk != null) {
            this.books.remove(EBook);
            
            Autor autor = (Autor) this.authors.find(bk.getAuthor());
            autor.getBooks().remove(bk);
            if (autor.getBooks().size() == 0)
                this.authors.remove(bk.getAuthor());
            
            Year year = (Year) this.year.find(bk.getYear());
            year.getBooks().remove(bk);
            if (year.getBooks().size() == 0)
                this.year.remove(bk.getYear());
                
            File f1 = new File(bk.getAuthor()+".csv");
            f1.delete();
            File f2 = new File(bk.getYear()+".csv");
            f2.delete();
            return true;
        }
        return false;
    }
}
