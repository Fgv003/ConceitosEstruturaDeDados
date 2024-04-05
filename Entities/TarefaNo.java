package Entities;

import Entities.Tarefa;


public class TarefaNo {
    Tarefa valor;
    TarefaNo prox;
    
    TarefaNo(Tarefa ValorNo){
        valor = ValorNo;
        prox = null;
    }
}
