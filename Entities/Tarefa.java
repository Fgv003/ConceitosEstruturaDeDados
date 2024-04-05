package Entities;

import service.Prioridade;

public class Tarefa {
       private String nome;
       private String descricao; 
       private Prioridade p;
       
    public Tarefa(String nome, Prioridade p) {
        this.nome = nome;
        this.p = p;
    }
    public Tarefa(String nome, String descricao,Prioridade p ) {
        this.nome = nome;
        this.descricao = descricao;
        this.p = p;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String imprimir(){    
        String  f  = "Nome: " + this.nome;    
        return f;
    }
    
    public String imprimirCompleto(){    
        String  f  = "Nome: " + this.nome +
                 "\nDescrição: " + this.descricao +
                 "\nPrioridade: " + this.p + "\n";        
        return f;
    }

    public Prioridade getP() {
        return p;
    }

    public void setP(Prioridade p) {
        this.p = p;
    }
     
}
