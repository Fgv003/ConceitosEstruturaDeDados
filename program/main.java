/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import Entities.TarefaNo;
import Entities.Tarefa;
import service.Prioridade;
import Entities.ListaEncadeada;
import Entities.Pilha;
import Entities.Fila;
import javax.swing.JOptionPane;

/**
 *
 * @author liggia
 */
public class main {

    public static void main(String[] args) {
        int opcao = 0;
        int tamanho = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tamanho da lista to-do"));

        ListaEncadeada le = new ListaEncadeada();
        Pilha p = new Pilha(tamanho);
        Fila f = new Fila(tamanho);
        Tarefa valor;

        while (opcao != 7) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "1 -Criar Tarefa\n" + "2- Remover Tarefa\n"
                    + "3- Listar Tarefas(Nomes)\n" + "4- Listar Tarefas(Nome e Descrição)\n"
                    + "5- Listar Tarefas(Preioridade)\n" + "6- Concluir Tarefa\n"
                    +"7- Sair\n"));

            switch (opcao) {

                case 1:

                    String nome = JOptionPane.showInputDialog(null, "Digite o nome da Tarefa");
                    String descricao = JOptionPane.showInputDialog(null, "Digite a descrição da Tarefa (opcional)");
                    int prioridade = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a prioridade 1 para Alta, 2 para Media e 3 para baixa da Tarefa"));
                    Prioridade pri;
                    if (prioridade == 1) {
                        pri = Prioridade.ALTA;
                    } else if (prioridade == 2) {
                        pri = Prioridade.MEDIA;
                    } else if (prioridade == 3) {
                        pri = Prioridade.BAIXA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Tarefa invalida");
                        break;
                    }

                    if (descricao == null) {
                        valor = new Tarefa(nome, pri);
                        f.enfileirar(valor);
                    } else {
                        valor = new Tarefa(nome, descricao, pri);
                        f.enfileirar(valor);
                    }
                    TarefaNo no = new TarefaNo(valor);
                    le.insereNo_fim(no);
                    JOptionPane.showMessageDialog(null, "Tarefa Criada");
                    break;

                case 2:
                    String nomeExcluir = JOptionPane.showInputDialog(null, "Digite o nome da Tarefa que quer excluir");
                    TarefaNo n = le.buscaNo(nomeExcluir);
                    System.out.println(n.valor);
                    le.excluiNo(n.valor);
                    System.out.println("A tarefa foi excluida");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, le.exibeLista(false));

                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, le.exibeLista(true));
                    break;

                case 5:
                    Prioridade pri2;
                     int op = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite qual prioridade vc quer 1 para Alta, 2 para media e 3 para baixa"));
                    if(op == 1){
                        pri2 = Prioridade.ALTA;
                    } else if (op == 2) {
                        pri2 = Prioridade.MEDIA;
                    } else if (op == 3) {
                        pri2 = Prioridade.BAIXA;
                    } else {
                        JOptionPane.showMessageDialog(null, "Tarefa invalida");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, le.exibeListaPrioridade(pri2));

                    break;

                case 6:
                p.ExibePilha();
                String nom =JOptionPane.showInputDialog(null,"Digite qual o nome da tarefa que deseja concluir:");
                Fila fc = new Fila(tamanho);
                
                
                while(!f.vazia()){
                    
                Tarefa t =f.desenfileirar();
                    if(t.getNome().equals(nom)){
                        p.empilhar(t);
                        p.ExibePilha();
                        break;
                    }
                    fc.enfileirar(t);
                }
                
                for(int i=0; i<f.total; i++){
                    fc.enfileirar(f.desenfileirar());
                }
                
                f=fc;
                    break;

            }

        }
    }
}
