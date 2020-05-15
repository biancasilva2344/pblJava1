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

public class Node {
    private Node right;
    private Node left;
    private Node dad;
    private String key;
    private Object content;
    private int balancing;
    
    /**
     *
     * @param key
     * @param content
     */
    public Node(String key, Object content){
        this.right = null;
        this.left = null;
        this.dad = null;
        this.balancing = 0;
        this.key = key;
        this.content = content;
    }
    
    /**
     *
     * @return node
     */
    public Node getRight(){
        return this.right;
    }
    
    /**
     *
     * @param newRight
     */
    public void setRight(Node newRight){
        this.right = newRight;
    }
    
    /**
     *
     * @return node
     */
    public Node getLeft(){
        return this.left;
    }
    
    /**
     *
     * @param newLeft
     */
    public void setLeft(Node newLeft){
        this.left = newLeft;
    }
    
    /**
     *
     * @return node
     */
    public Node getDad(){
        return this.dad;
    }
    
    /**
     *
     * @param newDad
     */
    public void setDad(Node newDad){
        this.dad = newDad;
    }
    
    /**
     *
     * @return int
     */
    public int getBalancing(){
        return this.balancing;
    }
   
    /**
     *
     * @param newBalancing
     */
    public void setBalancing(int newBalancing){
        this.balancing = newBalancing;
    }
    
    /**
     *
     * @return String
     */
    public String getKey(){
        return this.key;
    }
    
    /**
     *
     * @param newKey
     */
    public void setKey(String newKey){
        this.key = newKey;
    }
    
    /**
     *
     * @return Object
     */
    public Object getContent(){
        return this.content;
    }
    
    /**
     *
     * @param newContent
     */
    public void setContent(Object newContent){
        this.content = newContent;
    }
}
