/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upa;

import java.util.Scanner;

/**
 *
 * @author Bianca Santana de Araujo Silva
 */
public class UpaApp {

    /**
     * @return 
     */
    public static int menu(){
        int opcao;
        Scanner ler = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("#    Escolha uma opção    #");
        System.out.println("---------------------------");
        System.out.println("(1) Adiciona Medico");
        System.out.println("(2) Editar Medico");
        System.out.println("(3) Adiciona Paciente");
        System.out.println("(4) Lista de paciente");
        System.out.println("(5) Atender Paciente");
        System.out.println("(6) Lista Pacientes atendidos");
        System.out.println("(7) Lista de exames");
        System.out.println("(8) Lista de exames solicitados");
        System.out.println("(9) Realizar exames");
        System.out.println("(10) Sair");
        System.out.println("----------------------------");
        opcao=ler.nextInt();
        return opcao;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ler = new Scanner(System.in);
        ListaMedico listaMedico = new ListaMedico();
        ListaExame listaExame = new ListaExame();
        ListaGeral listaGeral = new ListaGeral();
        int opcao;
        
        
        do{
            opcao = menu();
            switch(opcao){
                case 1:
                    System.out.println("-----Adicionando medico-----");
                    Medico medico;
                    medico = new Medico("nome","crm");
                    System.out.println("Nome : ");
                    medico.setNome(ler.nextLine());
                    System.out.println("CRM : ");
                    medico.setCrm(ler.nextLine());
                    listaMedico.inserirPrimeiro(medico);
                
                    break;
                case 2:
                    if(listaMedico.eVazia()){
                        System.out.println("Lista de médico está vazia.");
                    }
                    else{
                        System.out.println("-----Localizando medico-----\nDigite o CRM:");
                        String crmProcurado= ler.nextLine();
                        if(listaMedico.procurarNo(crmProcurado)== null){
                            System.out.println("O medico não está na lista.");                        
                        }
                        else{
                            System.out.println("Digite o novo Nome:");
                            String novoNome = ler.nextLine();
                            listaMedico.editarNome(crmProcurado, novoNome);
                        }
                    }
                    break;
                case 3:
                    if(listaMedico.eVazia()){
                        System.out.println("Lista de médico está vazia.");
                    }
                    else{
                        ListaPaciente auxL = listaMedico.menorLista().getMedico().getListaPaciente();
                        System.out.println("O paciente é prioridade?\n Digite Sim ou Nao:");
                        String p = ler.nextLine().toUpperCase();
                        if (p.equals("SIM")){
                            Paciente paciente = new Paciente("nome", "matricula", true);
                            System.out.println("Digite o nome do Paciente:");
                            paciente.setNome(ler.nextLine());
                            System.out.println("Digite o número da matricula:");
                            paciente.setMatricula(ler.nextLine());
                            auxL.inserirPrioridade(paciente);

                        }
                        else{
                            Paciente paciente = new Paciente("nome2", "matricula2", false);
                            System.out.println("Digite o nome do paciente:");
                            paciente.setNome(ler.nextLine());
                            System.out.println("Digite o número da matricula:");
                            paciente.setMatricula(ler.nextLine());
                            auxL.inserirUltimo(paciente);
                        }
                    }
                    break;
                    
                case 4:
                    
                    if(listaMedico.eVazia()){
                        System.out.println("Lista de médico está vazia.");
                    }
                    else{
                        
                        System.out.println("Localizando medico\nDigite o CRM:");
                        String crmProcurado= ler.nextLine();
                        No aux = listaMedico.procurarNo(crmProcurado);
                        if(aux == null){
                            System.out.println("O medico não está na lista.");                        
                        }
                        else{
                            System.out.println(aux.getMedico().getListaPaciente());
                        } 
                    }
                    break;
                 
                case 5:
                    System.out.println("Digite o CRM do medico que irá atender:");
                    String crmProcurado= ler.nextLine();
                    No aux = listaMedico.procurarNo(crmProcurado); // pegando um nó de médico.
                    if(aux == null)
                        System.out.println("O medico não está na lista.");                        
                    else{
                        if(aux.getMedico().getListaPaciente().eVazia())
                            System.out.println("A lista de Paciente está vazia.");
                        else{
                            No aux2 = aux.getMedico().getListaPaciente().removerInicio(); // pegando um nó de paciente.
                            // inserindo paciente na lista de atendidos
                            aux.getMedico().getListaAtendidos().getListaPaciente().inserirUltimo(aux2.getPaciente());
                            System.out.println("Deseja solicitar exames?");
                            String e = ler.nextLine().toUpperCase(); 
                            do{

                                if (e.equals("SIM")){
                                    Exame exame = new Exame("tipoExame");
                                    System.out.println("----Procurando exame----\nDigite o tipo de exame:"); 
                                    String exameProcurado = ler.nextLine().toUpperCase();
                                    No aux_e = listaExame.buscaExame(exameProcurado);// pegando nó de exame.
                                    if(aux_e == null){
                                        System.out.println("--Exame não existe--\nDigite o nome do novo tipo de exame:");
                                        exame.setTipoExame(ler.nextLine().toUpperCase());
                                        //inserindo exame na lista de exame.
                                        listaExame.inserirPrimeiro(exame);
                                        //inserindo paciente dentro de um exame.
                                        exame.getListaPaciente().inserirUltimo(aux2.getPaciente());
                                        //inserindo exame na lista de exames de um paciente.
                                        aux2.getPaciente().getListaExame().inserirPrimeiro(exame);
                                        //inserindo paciente na lista geral de exames.
                                        listaGeral.getListaPaciente().inserirUltimo(aux2.getPaciente());
                                        System.out.println("Paciente foi adicionado.");
                                    }
                                    else{
                                        System.out.println("Exame já existe.");
                                        aux_e.getExame().getListaPaciente().inserirUltimo(aux2.getPaciente());
                                        aux2.getPaciente().getListaExame().inserirPrimeiro(exame);
                                        listaGeral.getListaPaciente().inserirUltimo(aux2.getPaciente());
                                        System.out.println("Paciente foi adicionado.");
                                    }
                                }
                                System.out.println("Deseja realizar outro exame?");
                                e = ler.nextLine().toUpperCase();
                            }while(e.equals("SIM"));
                           
                        }   
                    }
                    break;
                case 6:
                    System.out.println("Digite o CRM do medico que irá atender:");
                    String medProcurado= ler.nextLine();
                    No aux_m = listaMedico.procurarNo(medProcurado); // pegando um nó de médico.
                    if(aux_m == null)
                        System.out.println("O medico não está na lista.");                        
                    else{
                        System.out.println(aux_m.getMedico().getListaAtendidos());           
                    }
                    break;
                case 7 :
                   if (listaExame.eVazia())
                        System.out.println("Lista de exames está vazia.");
                   else{
                    System.out.println("----Procurando exame----\nDigite o tipo de exame:"); 
                    String exameProcurado = ler.nextLine().toUpperCase();
                    No aux_e = listaExame.buscaExame(exameProcurado);// nó do exame encontrado
                       if(aux_e == null)
                            System.out.println("O exame não foi encontrado.");                        
                        else{
                            System.out.println("Quantidade de pessoas:" + aux_e.getExame().getListaPaciente().getQtd_p());
                            System.out.println(aux_e.getExame().getListaPaciente());
                            
                        } 
                   }
                    break;
                
                case 8:
                    if(listaGeral.getListaPaciente().getPrimeiro_p() == null)
                        System.out.println("A lista geral de exames está vazia.");
                    else{
                        System.out.println("----Localizando paciente----\nDigite a matricula do paciente:");
                        String matriculaProcu = ler.nextLine();
                        No aux_p = listaGeral.getListaPaciente().buscaPaciente(matriculaProcu);
                        if(aux_p == null)
                            System.out.println("O paciente não foi encontrado.");
                        else{
                            System.out.println(aux_p.getPaciente().getListaExame());  
                        }                       
                    }
                    break;
                case 9:
                    if(listaGeral.getListaPaciente().getPrimeiro_p() == null)
                        System.out.println("A lista geral de exames está vazia.");
                    else{
                        System.out.println("----Localizando paciente----\nDigite a matricula do paciente:");
                        String matriculaProcu = ler.nextLine();
                        No aux_p = listaGeral.getListaPaciente().buscaPaciente(matriculaProcu);
                        System.out.println("Digite o tipo de exame que o paciente irá realizar:");
                        String exameProcurado = ler.nextLine().toUpperCase();
                        No aux_e = listaExame.buscaExame(exameProcurado);// nó do exame encontrado
                        if(aux_e == null)
                            System.out.println("O exame não foi encontrado.");                        
                        else{
                               //istaGeral.getListaPaciente().remover(matriculaProcu);
                        }   
                    }
                    break;
            }
            
        }while (opcao!=10);
        System.exit(0);
    

    
    }
   
}
