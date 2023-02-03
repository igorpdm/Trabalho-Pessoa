package t1;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void telainicial() {
        System.out.println("--------------Registro--------------");
        System.out.println("Digite 1: Registrar Pessoa");
        System.out.println("Digite 2: Apagar Pessoa");
        System.out.println("Digite 0: Para finalizar o programa");
        System.out.print("Opcao: ");
    }

    public static void main(String[] args) throws ParseException {
        Pessoa[] vetor = new Pessoa[10];
        Scanner scn = new Scanner(System.in);
        telainicial();
        int escolha;
        escolha = scn.nextInt();
        OUTER:
        do {
            switch (escolha) {
                case 1:
                    String positive = "Sim";
                    boolean BI = false;
                    boolean BCPF = false;
                    boolean BCH = false;
                    boolean BTE = false;
                    System.out.println("");
                    System.out.println("Registrando Pessoa:");
                    scn.nextLine();
                    System.out.println("Informe  seu nome: ");
                    String nome = scn.nextLine();
                    System.out.println("Seu nome e: " + nome + ". Aperte ENTER para CONFIRMAR");
                    scn.nextLine();
                    System.out.println("Informe o telefone: ");
                    String telefone = scn.next();
                    /*--------------------------------------------------------------------------------------------------------------------------*/
                    System.out.println("Voce possui Cadastro de Pessoa Fisica? (Digite Sim ou Nao)");
                    String CP = scn.next();

                    if (CP.compareTo(positive) == 0) {
                        BCPF = true;
                    }

                    System.out.println("Voce possui Carteira de Identidade? (Digite Sim ou Nao)");
                    String I = scn.next();

                    if (I.compareTo(positive) == 0 && BCPF) {
                        BI = true;

                    } else if (BCPF == false && I.compareTo(positive) == 0) {
                        System.out.println("CPF necessario para a criacao de Carteira de Identidade.");
                        System.out.println("Retornando ao Menu Principal...");
                        telainicial();
                        escolha = scn.nextInt();
                        break;
                    } else if (I.compareTo(positive) != 0) {}

                    System.out.println("Voce possui Carteira Nacional de Habilitacao? (Digite Sim ou Nao)");
                    String CH = scn.next();

                    if (CH.compareTo(positive) == 0 && BCPF && BI) {
                        BCH = true;
                    } else if (CH.compareTo(positive)== 0 && (BCPF && BI)){
                        System.out.println("CPF necessario para a criacao de Carteira Nacional de Habilitacao.");
                        System.out.println("Retornando ao Menu Principal...");
                        telainicial();
                        escolha = scn.nextInt();
                        break;
                    } else if (CH.compareTo(positive)!=0){}

                    System.out.println("Voce possui Titulo de Eleitor? (Digite Sim ou Nao)");
                    String T = scn.next();

                    if (T.compareTo(positive) == 0) {
                        BTE = true;
                    }

                    Pessoa p = new Pessoa(nome, telefone);
                    /*----------------------------------------------------------------------------------------------------------------------------*/

                    if (BCPF) {
                        System.out.println("");
                        System.out.println("Registrando Cadastro de Pessoa Fisica. Aperte ENTER para CONFIRMAR");
                        scn.nextLine();
                        System.out.println("Informe seu cpf: ");
                        String cpf = scn.next();
                        System.out.println("Sua data de nascimento(dia/mes/ano): ");
                        String nascimentocpf = scn.next();

                        p.criaCPF(p, cpf, nascimentocpf);

                        if (p.validaCPF(cpf) == false) {
                            p = null;
                            System.out.println("");
                            System.out.println("Cadastro nao realizado.");
                            System.out.println("Voltando para o menu principal...");
                            telainicial();
                            escolha = scn.nextInt();
                            break;
                        }
                    }

                    if (BI) {
                        System.out.println("");
                        System.out.println("Registrando Carteira de Identidade. Aperte ENTER para CONFIRMAR");
                        scn.nextLine();
                        System.out.println("Informe o nome da mae: ");
                        String nomemae = scn.nextLine();
                        System.out.println("O nome da sua mae é: " + nomemae + ". Aperte ENTER para CONFIRMAR");
                        scn.nextLine();
                        System.out.println("Informe o nome do pai: ");
                        String nomepai = scn.nextLine();
                        System.out.println("O nome do seu pai é: " + nomepai + ". Aperte ENTER para CONFIRMAR");
                        scn.nextLine();
                        System.out.println("Informe sua Nacionalidade(Cidade/estado): ");
                        String nacionalidade = scn.next();
                        System.out.println("Informe sua Identidade(Somente numeros): ");
                        String identidadeci = scn.next();
                        System.out.println("Informe sua data de nascimento(dia/mes/ano): ");
                        String datadenascimento = scn.next();

                        p.criaCI(p, nomepai, nomemae, nacionalidade, identidadeci, datadenascimento);

                    }
                    if (BCH) {
                        System.out.println("Registrando Carteira Nacional de Habilitacao.Aperte ENTER para CONFIRMAR");
                        scn.nextLine();
                        System.out.println("Informe sua idade:");
                        int idade = scn.nextInt();
                        scn.nextLine();
                        System.out.println("Informe o nome do pai: ");
                        String nomepaicnh = scn.nextLine();
                        System.out.println("O nome do seu pai e: " + nomepaicnh + ". Aperte ENTER para CONFIRMAR");
                        scn.nextLine();
                        System.out.println("Informe o nome da mae: ");
                        String nomemaecnh = scn.nextLine();
                        System.out.println("O nome da sua mae e: " + nomemaecnh + ". Aperte ENTER para CONFIRMAR");
                        scn.nextLine();
                        System.out.println("Informe sua data de nascimento(dia/mes/ano): ");
                        String datadenascimentocnh = scn.next();

                        p.criaCNH(p, nomepaicnh, nomemaecnh, datadenascimentocnh, idade);
                    }

                    if (BTE) {
                        System.out.println("Registrando Titulo de Eleitor.Aperte ENTER para CONFIRMAR");
                        scn.nextLine();
                        System.out.println("Insira sua idade:");
                        int idade1 = scn.nextInt();
                        System.out.println("Informe sua data de nascimento(dia/mes/ano): ");
                        String nascimentoTE = scn.next();
                        System.out.println("Informe o numero de inscricao: ");
                        String inscricao = scn.next();
                        System.out.println("Informe a zona de voto: ");
                        String zona = scn.next();
                        System.out.println("Informe a secao de voto: ");
                        String secao = scn.next();
                        System.out.println("Informe o estado de nascimento(MG,SP...): ");
                        String estado = scn.next();

                        p.criaTE(p, nascimentoTE, inscricao, zona, secao, estado, idade1);

                        if (p.validaNumTE(inscricao) == false) {
                            p = null;
                            System.out.println("");
                            System.out.println("Cadastro nao realizado.");
                            System.out.println("Voltando para o menu principal...");
                            telainicial();
                            escolha = scn.nextInt();
                            break;
                        }
                    }
                    if(p.adicionaPessoa(vetor) == false){
                        Pessoa[] vetor1 = new Pessoa[vetor.length*2];
                        for(int i=0;i<vetor.length;i++){
                            vetor1[i] = vetor[i];
                        }
                        vetor = vetor1;
                    }
                    System.out.println("Cadastro realizado com sucesso");
                    System.out.println("Voltando ao menu principal...");
                    telainicial();
                    escolha = scn.nextInt();
                    break;
                case 2:
                    String nometemp;
                    System.out.println("---------- Apagando Pessoa ----------");
                    System.out.println("Digite o nome da pessoa que deseja apagar: ");
                    nometemp = scn.next();
                    if(Pessoa.removePessoa(vetor, nometemp)){
                        System.out.println("Pessoa apagada com sucesso!");
                        System.out.println("Retornando ao menu principal...");
                        telainicial();
                        escolha = scn.nextInt();
                    }else{
                        System.out.println("Falha ao apagar Pessoa. Nenhuma pessoa com o nome inserido");
                        System.out.println("Retornando ao menu principal...");
                        telainicial();
                        escolha = scn.nextInt();
                    }
                    break;
                case 0:
                    break OUTER;
            }
        } while (true);
    }
}
