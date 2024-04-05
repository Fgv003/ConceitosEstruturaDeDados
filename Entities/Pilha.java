package Entities;

import javax.swing.JOptionPane;


public class Pilha {
    int topo;
    int tamanho;
    Tarefa vetor[];

    Pilha(int tam) {
        topo = -1; //Marca que a pilha está vazia
        tamanho = tam;
        vetor = new Tarefa[tam];
    }

    public boolean vazia() {
        if (topo == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cheia() {
        if (topo == tamanho - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void empilhar(Tarefa elem) {
        if (cheia() == false) {
            topo++;
            vetor[topo] = elem;
        } else {
            JOptionPane.showMessageDialog(null,
                    "PILHA CHEIA!");
        }
    }

    public Tarefa desempilhar() {
        Tarefa valorDesempilhado;
        if (vazia() == true) {
            valorDesempilhado = null;
        } else {
            valorDesempilhado = vetor[topo];
            topo--;
        }
        return valorDesempilhado;
    }

    public void ExibePilha() {
        String imp = "";
        if (vazia() == true) {
            JOptionPane.showMessageDialog(null,
                    "PILHA VAZIA!");
        } else {
            for (int i = topo; i >= 0; i--) {
                imp += "Elemento "+ vetor[i].getNome() + " - posição " + i + "\n";
            }
            JOptionPane.showMessageDialog(null,
                    imp);
        }
    }
}
