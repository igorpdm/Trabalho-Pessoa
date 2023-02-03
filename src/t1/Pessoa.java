
package t1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pessoa {
    String nome,telefone;
    CNH cNacionalH;
    CPF cPessoaF;
    TE tEleitor;
    CI cIdentidade;
    
    public Pessoa(String nome,String telefone){
        if (nome!= null) {
            this.nome=nome;
        }else{
            System.out.println("Nome invalido...");
            return;
        }
        
        if (telefone!=null && telefone.length()==11) {
           this.telefone=telefone;
        }else{
            System.out.println("Numero de telefone invalido...");
            return;
        }
    }
    public boolean adicionaPessoa(Pessoa[] vetor){
        Pessoa temp;
        double temp1,temp2;
        if(vetor[vetor.length-1] != null){
            return false;
        }
        for(int i=0;i<vetor.length;i++){
            if(vetor[i] == null){
                vetor[i] = this;
                break;
            }
        }
        for(int i=0;i<vetor.length-1;i++){
            if(vetor[i]!= null && vetor[i+1]!= null){
                if(vetor[i].nome.compareTo(vetor[i+1].nome)>0){
                    temp = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = temp;
            }
        }
        }
        for(int i=0;i<vetor.length-1;i++){
            if(vetor[i]!= null && vetor[i+1]!= null){
                if(vetor[i].cPessoaF != null && vetor[i+1].cPessoaF != null){
                    if(vetor[i].nome.compareTo(vetor[i+1].nome)==0){
                        temp1 = Double.parseDouble(vetor[i].cPessoaF.cpf);
                        temp2 = Double.parseDouble(vetor[i+1].cPessoaF.cpf);
                        if(temp1 > temp2){
                            temp = vetor[i];
                            vetor[i] = vetor[i+1];
                            vetor[i+1] = temp;
                }
            }
        }
    }
    }
        return true;
        
        
    }
    public static boolean removePessoa(Pessoa[] vetor,String nome){
        for(int i=0;i<vetor.length;i++){
            if(vetor[i].nome.compareTo(nome) == 0){
                vetor[i] = null;
                for(int j =0;j<vetor.length-1;j++){
                    if(vetor[i]==null && vetor[i+1]!=null){
                        vetor[i] = vetor[i+1];
                        vetor[i+1] = null;
                    }
                }
                return true;
            }
        }
        for(int i=0;i<vetor.length;i++){
            if(vetor[i].nome.compareTo(nome)!= 0){
                return false;
            }
        }
        return true;
    }   
        public boolean validaCPF(String cpf){
        if (cpf!=null && cpf.length()==11) {
            int digito1;
            int soma =0;
            int soma1=0;                
            int ref =10;
            int ref1 =11;
            int[] vetCPF = new int[11];
            String temp = new String();
            for (int i = 0; i < 11; i++) {
                vetCPF[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
            }
            for (int i = 0; i < 9; i++) {
                soma=(vetCPF[i]*ref)+soma;
                ref=ref-1;
            }
            if ((soma%11)<2) {
                if (vetCPF[9]!=0) {
                    System.out.println("Verificacao de CPF invalida");
                    return false;
                }   
            }
            if ((soma%11)>=2) {
                if (vetCPF[9]!= (11-(soma%11))) {
                    System.out.println("Verificacao de CPF invalida");
                    return false;
                }
            }
            for (int i = 0; i < 10; i++) {
                soma1=(vetCPF[i]*ref1)+soma1;
                ref1=ref1-1;
            }
            if ((soma1%11)<2) {
                if (vetCPF[10]!=0) {
                    System.out.println("Verificacao de CPF invalida");
                    return false;
                }
            }
            if ((soma1%11)>=2) {
                if (vetCPF[10]!= (11-(soma1%11))) {
                    System.out.println("Verificacao de CPF invalida");
                    return false;
                }
            }
        }return true;
        }    
    
        public boolean validaNumTE(String numInsc){
        if (numInsc!=null && numInsc.length()==12) {
            int soma =0;
            int soma1=0;                
            int ref =2;
            int ref1 =7;
            int[] vetTE = new int[12];
            for (int i = 0; i < 11; i++) {
                vetTE[i] = Integer.parseInt(String.valueOf(numInsc.charAt(i)));
            }
        for (int i = 0; i < 8; i++) {
                soma=(vetTE[i]*ref)+soma;
                ref=ref+1;
            }
        if ((soma%11)!= vetTE[10]) {
                    System.out.println("Verificacao de Titulo de Eleitoral invalida");
                    return false;
        }   
        for (int i = 8; i < 12; i++) {
                soma1=(vetTE[i]*ref1)+soma1;
                ref1=ref1+1;
            }   
        if ((soma%11)!= vetTE[11]) {
                    System.out.println("Verificacao de Titulo de Eleitoral invalida");
                    return false;
        }
        System.out.println("Titulo de Eleitor validado com sucesso.");
        }
        
        return true;
    }
    
    public void criaCPF(Pessoa p,String cpf,String data) throws ParseException{
        CPF cpf1 = new CPF(p,cpf,data);
        p.cPessoaF=cpf1;
    }
    
    public void criaCI(Pessoa p, String nomePai, String nomeMae, String nacionalidade, String rg, String dataNasc) throws ParseException{
        CI ci1 = new CI(p,nomePai,nomeMae,nacionalidade,rg,dataNasc);
        p.cIdentidade=ci1;
    }
    
    public void criaCNH(Pessoa p, String nomePai, String nomeMae, String dataNasc,int idade) throws ParseException{
        CNH cnh1 = new CNH(p,nomePai,nomeMae,dataNasc,idade);
        p.cNacionalH=cnh1;
    }
    
    public void criaTE(Pessoa p, String dataNasc, String numInsc, String zona, String secao, String estado,int idade) throws ParseException{
        TE titulo = new TE(p,dataNasc,numInsc,zona,secao,estado,idade);
        p.tEleitor=titulo;
    }
    
    public class CPF {
    String nome,cpf,dataNasc;

    public CPF(Pessoa p, String cpf, String dataNasc) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date nasc = format.parse(dataNasc);
        if(p.nome != null){
            nome = p.nome;
        }
        
        this.dataNasc = dataNasc;
        
        if (validaCPF(cpf)) 
            this.cpf=cpf;  

    }
        
    }
    public class CI {

    String nomePortador, nomePai, nomeMae, cpf, cideestado;
    String dataNasc, rg;
    Date dataEmissao;
    
    public CI(Pessoa p, String nomePai, String nomeMae,String nacionalidade, String rg, String dataNasc) {
        Date agora = new Date();

        if (rg.length() == 8 && rg != null) {
            this.rg = rg;
        }

        if (p.nome != null) {
            nomePortador = p.nome;
        }
        this.cpf=p.cPessoaF.cpf;
        
        if (dataNasc != null) {
            this.dataNasc = dataNasc;
        }
        if (nomePai != null) {
            this.nomePai = nomePai;
        }
        if (nomeMae != null) {
            this.nomeMae = nomeMae;
        }
        this.cideestado = nacionalidade;
        this.dataEmissao = agora;
    }
    }
    
    
    
    
    
    
    
    
    
    public class CNH {

    String nomePortador, nomePai, nomeMae, cpf,rg;
    Date dataNasc, dataEmissao, dataValidade;
    int idade;
    
    public CNH(Pessoa p, String nomePai, String nomeMae, String dataNasc,int idade) throws ParseException  {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date nasc = format.parse(dataNasc);
        Date agora = new Date();
        
        GregorianCalendar validade = new GregorianCalendar();
        validade.setTime(agora);
        validade.add(Calendar.YEAR, 10);
        this.dataValidade = validade.getTime();
        
        this.rg=p.cIdentidade.rg;
        
        if (p.nome != null) {
            nomePortador = p.nome;
        }
        this.cpf=p.cPessoaF.cpf;
        
        if (nasc != null) {
            this.dataNasc = nasc;
        }
        if (nomePai != null) {
            this.nomePai = nomePai;
        }
        if (nomeMae != null) {
            this.nomeMae = nomeMae;
        }
        this.dataEmissao = agora;
        
        this.idade=idade;
    }
    public boolean validaIdade(CNH cnh){
        if (cnh.idade<18) {
            System.out.println("Voce nao possui idade minima para criar uma Carteira de Habilitacao.");
            cnh=null;
        }
            return true;    
    }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public class TE {
    String nome,dataNasc,zona,secao,numInsc,estado;
    int idade;
   

    public TE(Pessoa p, String dataNasc, String numInsc, String zona, String secao, String estado,int idade) {
        this.nome = p.nome;
        this.dataNasc = dataNasc;
        this.numInsc = numInsc;
        this.zona = zona;
        this.secao = secao;
        this.estado = estado;
        this.idade= idade;
    }
    
    public boolean validaIdade(TE te){
        if (te.idade<16) {
            System.out.println("Voce nao possui idade minima para criar uma Titulo de Eleitor.");
            te=null;
        }
            return true;    
    }
    
    public boolean validaUFTE(TE titulo){
        String uf;
        int[] vetTE = new int[12];
        for (int i = 0; i < 11; i++) {
                vetTE[i] = Integer.parseInt(String.valueOf(titulo.numInsc.charAt(i)));
            }
        if (vetTE[8]== 0 && vetTE[9]==1) {
            uf="SP";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 0 && vetTE[9]==2) {
            uf="MG";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
                
            }
        }
        if (vetTE[8]== 0 && vetTE[9]==3) {
            uf="RJ";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 0 && vetTE[9]==4) {
            uf="RS";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 0 && vetTE[9]==5) {
            uf="BA";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 0 && vetTE[9]==6) {
            uf="PR";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 0 && vetTE[9]==7) {
            uf="CE";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 0 && vetTE[9]==8) {
            uf="PE";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 0 && vetTE[9]==9) {
            uf="SC";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==0) {
            uf="GO";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==1) {
            uf="MA";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==2) {
            uf="PB";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==3) {
            uf="PA";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==4) {
            uf="ES";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==5) {
            uf="PI";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==6) {
            uf="RN";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==7) {
            uf="AL";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==8) {
            uf="MT";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 1 && vetTE[9]==9) {
            uf="MS";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==0) {
            uf="DF";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==1) {
            uf="SE";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==2) {
            uf="AM";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==3) {
            uf="RO";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==4) {
            uf="AC";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==5) {
            uf="AP";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==6) {
            uf="RR";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==7) {
            uf="TO";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        if (vetTE[8]== 2 && vetTE[9]==8) {
            uf="ZZ";
            if (uf.compareTo(titulo.estado)!=0) {
                System.out.println("Titulo de Eleitor invalido.");
                return false;
            }
        }
        System.out.println("Titulo de Eleitor validado com sucesso.");
      return true;
    }
    }
}
