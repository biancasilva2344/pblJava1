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

public class Tree {
    private Node root;
    
    /**
     * Método construtor da árvore.
     */
    public Tree(){
        this.root = null;
    }
    
    /**
     *
     * @return
     */
    public String getRoot(){
        return this.root.getKey();
    }
    
    /**
     * Insere a palavra chave da árvore e o conteúdo como um objeto, insere já balanceando.
     * @param key
     * @param content
     */
    public void insert(String key, Object content){
        Node newNode = new Node(key, content);
        this.insertAvl(this.root, newNode);
    }
    
    private void insertAvl(Node toCompare,Node newNode){
        if(toCompare == null){ // verifica se já existe um nó na árvore.
            this.root = newNode;
        } else {
            if (newNode.getKey().compareTo(toCompare.getKey()) < 0){// Compara se a chave do novo nó é menor que 0.
                if (toCompare.getLeft() == null){ // se o nó da esquerda for vazio, insere um novo nó a esquerda.
                    toCompare.setLeft(newNode);
                    newNode.setDad(toCompare); 
                    this.checkBalancing(toCompare); // analisa se a árvore está balanceada.
                } else {
                    this.insertAvl(toCompare.getLeft(), newNode); //senão, faz a recursão, passando o nó da direita do atual.
                }
            } else if (newNode.getKey().compareTo(toCompare.getKey()) > 0){ // Compara se a chave do novo nó é maior que 0.
                if (toCompare.getRight() == null){ // se o nó a direita for vazio, insere um novo nó a direita.
                    toCompare.setRight(newNode);
                    newNode.setDad(toCompare); 
                    this.checkBalancing(toCompare); // balanceia a árvore.
                } else {
                    this.insertAvl(toCompare.getRight(), newNode);//senão, faz a recursão, passando o nó da esquerda do atual.
                }
            } else {  // O nó já existe
                System.out.println("*A chave "+ newNode.getKey() +" já existe*");  
            }
        }
    }
    
    private void checkBalancing(Node node){
        this.setBalancing(node); 
        int balancing = node.getBalancing(); 
        if (balancing == -2){ // mexe com o lado esquerdo da árvore.
            // se o filho da esquerda for maior que o filho da direita, faz rotação simples a direita.
            if (this.height(node.getLeft().getLeft()) >= this.height(node.getLeft().getRight())){ 
                node = this.rightRotation(node);
            } else {// se não faz dupla rotação esquerda a direita.
                node = this.doubleLeftRightRotation(node);
            }
        } else if (balancing == 2){ // mexe com o lado direito da árvore.
            // se o filho da direita for maior que o filho da esqueda, faz rotação simples a esquerda.
            if (this.height(node.getRight().getRight()) >= this.height(node.getRight().getLeft())){
                node = this.leftRotation(node);
            } else {// se não faz dupla rotação direita a esquerda
                node = this.doubleRightLeftRotation(node);
            }
        }
        if (node.getDad() != null){ // se o nó atual tiver pai analisa se está balanceado.
            this.checkBalancing(node.getDad());
        } else { // raiz é igual ao atual.
            this.root = node;
        }
    }
    
    /**
     * Método que remove um elemento dado sua chave e rebalenceia a árvore.
     * @param key
     */
    public void remove(String key){
        this.removeAvl(this.root, key);
    }
    
    private void removeAvl(Node current, String key){
        if (current == null){ // verifica se a árvore está vazia.
            return;
        } else {// irá continuar fazendo o método recursivo até achar item procurado.
            if (current.getKey().compareTo(key) > 0) {// verifica se o item procurado é maior que 0.
		this.removeAvl(current.getLeft(), key); 
            } else if (current.getKey().compareTo(key) < 0) {
                this.removeAvl(current.getRight(), key);
            } else if (current.getKey().compareTo(key) == 0) {
                this.removeNode(current);
            }
        }
    }
    
    private void removeNode(Node node){
        Node axl1;
        if (node.getLeft() == null || node.getRight() == null){// se o nó da esquerda ou direita for igual a nulo.
            // Se o item a ser removido não tiver pai igualá ele a nulo.
            if (node.getDad() == null){
                this.root = null;
                node = null;
                return;
            }
            axl1 = node;
            
        } else {
            axl1 = this.successor(node); // ax11 vai receber o filho do nó
            node.setKey(axl1.getKey()); // a chave do nó vai ser alterada pela chave de ax11
            node.setContent(axl1.getContent());// o contéudo vai ser alterado pelo contéudo de ax11
            // após isto, o node deixará de existir
        }
        Node axl2;
        if (axl1.getLeft() != null){// se a esquerda for diferente de nulo o ax12 recebe a esquerda do aux11
            axl2 = axl1.getLeft();
        } else {// se não recebe a direita
            axl2 = axl1.getRight();
        }
        // caso ax12 seja direfente de nulo, o pai de ax12 vai ser ax11
        if (axl2 != null){
            axl2.setDad(axl1.getDad());
        }
        // se o pai de ax11 for nulo, a raiz será igual a ax12
        if (axl1.getDad() == null){
            this.root = axl2;
        
        } else {
            if (axl1 == axl1.getDad().getLeft()){
                axl1.getDad().setLeft(axl2);
            } else {
                axl1.getDad().setRight(axl2);
            }
            // verifica se está banlanceada
            this.checkBalancing(axl1.getDad());
        }
        axl1 = null;
    }
    
    /**
     * Este método realiza rotação simples a esquerda.
     * @param started
     * @return Node
     */
    public Node leftRotation(Node started){
        Node right = started.getRight();
        right.setDad(started.getDad());
        started.setRight(right.getLeft());
        if (started.getRight() != null){
            started.getRight().setDad(started);
        }
        right.setLeft(started);
	started.setDad(right);
        if (right.getDad() != null) {
            if (right.getDad().getRight() == started) {
		right.getDad().setRight(right);
			
            } else if (right.getDad().getLeft() == started) {
		right.getDad().setLeft(right);
            }
	}
        this.setBalancing(started);
        this.setBalancing(right);
        return right;
    }
    
    /**
     * Este método realiza rotação simples a direita.
     * @param started
     * @return Node
     */
    public Node rightRotation(Node started) {
	Node left = started.getLeft();
	left.setDad(started.getDad());
	started.setLeft(left.getRight());
            if (started.getLeft() != null) {
		started.getLeft().setDad(started);
            }
	left.setRight(started);
	started.setDad(left);
            if (left.getDad() != null) {
		if (left.getDad().getRight() == started) {
                    left.getDad().setRight(left);
		} else if (left.getDad().getLeft() == started) {
                    left.getDad().setLeft(left);
		}
            }

	this.setBalancing(started);
	this.setBalancing(left);

	return left;
    }
    
    /**
     * Este método realiza rotação dupla a esquerda.
     * @param started
     * @return node
     */
    public Node doubleLeftRightRotation(Node started) {
	started.setLeft(leftRotation(started.getLeft()));
	return rightRotation(started);
    }

    /**
     *  Este método realiza rotação dupla a direita.
     * @param started
     * @return node
     */
    public Node doubleRightLeftRotation(Node started) {
	started.setRight(rightRotation(started.getRight()));
	return leftRotation(started);
    }
    
    /**
     *  Método que pega o sucessor de um nó.
     * @param node
     * @return node
     */
    public Node successor(Node node) {
	if (node.getRight() != null) {
            Node axl1 = node.getRight();
            while (axl1.getLeft() != null) {
		axl1 = axl1.getLeft();
            }
            return axl1;
	} else {
            Node axl2 = node.getDad();
            while (axl2 != null && node == axl2.getRight()) {
		node = axl2;
		axl2 = node.getDad();
            }
            return axl2;
	}
    }
    
    private int height(Node node) {
        if (node == null) {
            return -1;
	}
	if (node.getLeft() == null && node.getRight() == null) {
            return 0; // está banlanceada
	} else if (node.getLeft() == null) {
            return 1 + height(node.getRight());	// pode está desbalanceada
	} else if (node.getRight() == null) {
            return 1 + height(node.getLeft()); // pode está desbalanceada
        } else {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}
    }
    
    private void setBalancing(Node node) {// atualiza a variável de balanceamento
        node.setBalancing(height(node.getRight()) - height(node.getLeft()));
    }
    
    /**
     *  Método que realiza as buscas em toda a árvore.
     * @param key
     * @return object
     */
    public Object find(String key){
        Node node;
        node = findAvl(this.root, key);
        if (node == null)
            return null;
        return node.getContent();
    }
    
    private Node findAvl(Node current, String key){
        if (current == null){
            return null;
        } else {
            if (current.getKey().compareTo(key) > 0) {// procura no lado esquerdo
		return this.findAvl(current.getLeft(), key);
            } else if (current.getKey().compareTo(key) < 0) {//procura no lado direito
                return this.findAvl(current.getRight(), key);
            } else {
                return current;
            }
        }
    }
    
    /**
     *  Método para auxiliar nos print transformando a árvore em uma lista encadeada.
     * @return arrayList
     */
    public ArrayList<Object> getArrayList() {
        ArrayList<Object> list = new ArrayList<Object>();
        this.getArrayList(root, list);
        return list;
    }

    private void getArrayList(Node node, ArrayList<Object> list) {
        if (node == null) {
                return;
        }
        this.getArrayList(node.getLeft(), list);
        list.add(node.getContent());
        this.getArrayList(node.getRight(), list);
    }
}
