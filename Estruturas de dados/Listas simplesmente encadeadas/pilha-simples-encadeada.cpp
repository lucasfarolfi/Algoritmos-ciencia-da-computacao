#include <iostream>
#include <stdlib.h>
using namespace std;

//Struct do tipo nó que contem o número a ser armazenado e o elemento próximo que é um ponteiro que aponta pro proximo nó
struct no{
  int num;
  struct no * prox;
};


typedef struct no * No;//Estou definindo que a struct nó deverá se chamada por "No"
No topo = NULL;//struct topo do tipo *No recebe Nulo enquanto não foi criado um nó

//Funções:

void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Empilhar" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Exibir" << endl;
  cout << "0 - Sair" << endl;
}

bool listaVazia (){
  
  if (topo == NULL) return true;

  else return false;
}

void exibirLista(){

  if(listaVazia() == true){
    cout << "\nA lista está vazia." << endl;
  }
  else {
    No aux = topo;

    do{
      system("clear");
      cout << aux->num << " |";
      aux = aux->prox;
    }while (aux != NULL);
    cout << "" << endl;
  }
  
}

void push (){

  No p; // Cria a struct p que serve de auxiliar

  int valor;//Variavel que receberá o numero a ser guardado

  p = new no;// p está recebendo uma nova struct do tipo nó alocada

  cout << "\nDigite o valor do elemento: ";
  cin >> valor;

  p->num = valor; // p ou no->num recebe o valor
  p->prox = topo; // p ou no->prox recebe topo, no primeiro no recebera nulo, mas na segunda ou proxima vez ele receberá o valor de onde o topo está apontando
  topo = p; // topo passa a apontar para o P criado

  system("clear");
}

void pop (){
  No p = topo;//Struct p do tipo No recebe o topo

  if(listaVazia() == false){
    topo = p->prox; // topo passa a receber o nó depois de p
    delete (p); //A memória alocada para p agora está livre

    system("clear");
    cout << "\nO elemento foi removido." << endl;
  }
  else {
    system("clear");
    cout << "\nA lista já está vazia." << endl;
  }
}

int main() {
  
  int opcao;

  do{
    
    menu ();

    cout << "Opção: ";
    cin >> opcao;    

    switch (opcao){

      case 1:
        push(); //Função que empilha os nós
        break;
    
      case 2:
        pop();//Função que remove o ultimo nó que entrou
        break;

      case 3:
        exibirLista();
        break;
    }

  }while(opcao != 0);

  return 0;
}