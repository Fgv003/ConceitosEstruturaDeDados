package Entities;


import service.Prioridade;
import javax.swing.JOptionPane;

public class ListaEncadeada {
    TarefaNo primeiro, ultimo;
    int numero_nos=0;
    
    ListaEncadeada(){
        primeiro = ultimo = null;   
    }
    void insereNo_fim (TarefaNo novoNo){
	novoNo.prox = null;
        if (primeiro == null)
            primeiro = novoNo;
	if (ultimo != null)
            ultimo.prox = novoNo;
        ultimo = novoNo;
	numero_nos++;
    }
    void insereNo_inicio (TarefaNo novoNo){
        novoNo.prox = primeiro;
	if(primeiro == null && ultimo==null) //Só tem um elemento na lista
        {
            ultimo = novoNo;
	}
	primeiro = novoNo;
        numero_nos++;
    }
    int ContarNos(){
	int tamanho = 0;
        TarefaNo temp_no = primeiro;
    	while (temp_no != null)
        {   tamanho++;
            temp_no = temp_no.prox;
	}
        return tamanho;
    }
    void insereNo_posicao(TarefaNo novoNo, int posicao){
	TarefaNo temp_no = primeiro;
	int numero_nos = ContarNos();
	int pos_aux;
	if(posicao == 0)
	{
            novoNo.prox = primeiro;
            if(primeiro == ultimo)
            {
                ultimo = novoNo;
            }
            primeiro = novoNo;
        }
        else
	{
            if (posicao <= numero_nos)
            {   
		pos_aux = 1;
		while(temp_no != null && posicao > pos_aux)
		{
                    temp_no = temp_no.prox;
                    pos_aux ++;
                }
                novoNo.prox = temp_no.prox;
                temp_no.prox = novoNo;
            }
            else
            {
                if(posicao > numero_nos)
		{
                    ultimo.prox = novoNo;
                    ultimo = novoNo;
		}
            }	 
        }
    }


    TarefaNo buscaNo (String buscaValor){
        int i = 0;
        TarefaNo temp_no = primeiro;
        while (temp_no != null)
        {
            if (temp_no.valor.getNome().equals(buscaValor))
            {
                JOptionPane.showMessageDialog(null, "A tarefa " + temp_no.valor.getNome() + " posição " + i + "foi encontrada");
                return temp_no;	
            }
            i++;
            temp_no = temp_no.prox;
            System.out.println(temp_no);
        }
        return null;
    }
    void excluiNo (Tarefa valor){
        TarefaNo temp_no = primeiro;
        TarefaNo anterior_no=null;
        while (temp_no != null && temp_no.valor != valor){
            anterior_no = temp_no;
            temp_no = temp_no.prox;
        }
        if (temp_no == primeiro){
            if (temp_no.prox !=null)
                primeiro = temp_no.prox;
            else
                primeiro = null;
        }
        else{
            anterior_no.prox =temp_no.prox;
        }
        
        if (ultimo == temp_no)
            ultimo = anterior_no;
    }
    
    public String exibeLista(boolean imprimirCompleto){
        TarefaNo temp_no = primeiro;
        int i = 0;
        String imp= "";
        while (temp_no != null)
        {
            if(imprimirCompleto){
            imp += temp_no.valor.imprimirCompleto() + " \n";
            }else{
            imp += temp_no.valor.imprimir() + " \n";
            }
            temp_no = temp_no.prox;
            i++;
        }
        return imp;
    }
    
        public String exibeListaPrioridade(Prioridade p){
        TarefaNo temp_no = primeiro;
        int i = 0;
        String imp= "";
        while (temp_no != null)
        {
            if(temp_no.valor.getP() == p){
            imp += temp_no.valor.imprimirCompleto() + " \n";
            }
            temp_no = temp_no.prox;
            i++;
        }
        return imp;
    }

}
