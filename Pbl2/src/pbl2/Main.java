/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2;

import java.util.Scanner;

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

public class Main {
    
    /**
     * 
     */
    public static Scanner kayboard = new Scanner(System.in);

    /**
     *  Executa todos os métodos contido no Controler
     * @param args
     */
    public static void main(String[] args) {
        Controler controler = new Controler();
        String resposta;
        
        String bufferStr01, bufferStr02, bufferStr03, bufferStr04, bufferStr05, bufferStr06;
        
        do{
            Options();
            System.out.print("Escolha: ");  
            resposta = kayboard.nextLine();
            
            switch (resposta){
                // sai do programa
                case "0":
                    break;
                // pega cada informação para colocar na função newbook que contém no controler
                case "1":
                    System.out.print("Numero de E_Book: ");
                    bufferStr01 = kayboard.nextLine();
                    
                    System.out.print("Titulo do livro: ");
                    bufferStr02 = kayboard.nextLine();
                    
                    System.out.print("Autor do livro: ");
                    bufferStr03 = kayboard.nextLine();
                    
                    System.out.print("Mes de publicação: ");
                    bufferStr04 = kayboard.nextLine();
                    
                    System.out.print("Ano de publicação: ");
                    bufferStr05 = kayboard.nextLine();
                    
                    System.out.print("Link para acesso do livro: ");
                    bufferStr06 = kayboard.nextLine();
                    
                    controler.newBook(bufferStr01, bufferStr02, bufferStr03, bufferStr04, bufferStr05, bufferStr06);
                    break;
                    
                case "2":
                    controler.readFile("catalogo_v2");
                    break;
                    
                case "3":
                    controler.saveFile("catalogo_v2");
                    break;
                    
                case "4":
                    controler.printAuthorsQuant();
                    break;
                    
                case "5":
                    System.out.print("Nome do autor: ");
                    bufferStr01 = kayboard.nextLine();
                    controler.printAuthorBooks(bufferStr01);
                    break;
                    
                case "6":
                    controler.printBooks();
                    break;
                    
                case "7":
                    System.out.print("Numero do E_Book: ");
                    bufferStr01 = kayboard.nextLine();
                    controler.printLinkBook(bufferStr01);
                    break;
                
                case "8":
                    System.out.print("Ano de lançamento: ");
                    bufferStr01 = kayboard.nextLine();
                    controler.printYearBooks(bufferStr01);
                    break;
                    
                case "9":
                    System.out.print("Numero do E_Book: ");
                    bufferStr01 = kayboard.nextLine();
                    controler.deletBook(bufferStr01);
                    break;
                
                default:
                    System.out.println("*Opção invalida*");
            
            }
        }while (!"0".equals(resposta));
    }
    
    /**
     * 
     */
    public static void Options(){
        System.out.println("|          Opções           |");
        System.out.println("|1|  Cadastrar novo livro   |");
        System.out.println("|2| Carregar base de dados  |");
        System.out.println("|3|     Gravar arquivo      |");
        System.out.println("|4|Listar autores/quantidade|");
        System.out.println("|5|  Listar autores/livros  |");
        System.out.println("|6|      Listar livros      |");
        System.out.println("|7|      Buscar livro       |");
        System.out.println("|8|    Buscar livro/ano     |");
        System.out.println("|9|      Excluir livro      |");
        System.out.println("|0|          Sair           |");
    }
    
}
