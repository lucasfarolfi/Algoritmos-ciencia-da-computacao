#include <iostream>
#include <stdlib.h>
using namespace std;

struct processo{
  int cod;
  struct processo* prox;
};

typedef struct processo * No;
No topo = NULL;
No ultimo;

//Funções:

//------Menu------
void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Incluir novo processo" << endl;
  cout << "2 - Remover primeiro da fila" << endl;
  cout << "3 - Exibir fila de processos" << endl;
  cout << "0 - Sair" << endl;
}

//------Lista Vazia------
bool listaVazia (){
  
  if (topo == NULL) return true; 

  else return false; 
}

//------Exibir------
void exibirProcessos(){

  if(listaVazia() == true){
    system("clear");
    cout << "Não há processos a serem executados." << endl;
  }
  else {
    No aux = topo;

    do{
      system("clear");
      cout << aux->cod << " | "; 
      aux = aux->prox; 

    }while (aux != NULL);

    cout << "" << endl;
  }
  
}

//------Inserir e remover------
void inserir (){

  No p = new processo; 

  cout << "Digite o código do processo: ";
  cin >> p->cod; 

  p->prox = NULL;

  if(listaVazia () == true){
    topo = p; 
    ultimo = topo; 
  }
  else{
    
    ultimo->prox = p; 
    ultimo = p; 
  }

  system("clear");
}

void remover (){

  system("clear");
  
  No aux; 

  if (listaVazia () == true){
    cout << "Não há processos a serem removidos." << endl;
  }
  else{
    aux = topo; 
    topo = aux->prox; 
    delete (aux); 

    cout << "O processo foi removido da fila !!!" << endl;
  }
}

//------Main------
int main() {
  
  int opcao;

  do{
    
    menu ();

    cout << "Opção: ";
    cin >> opcao;    

    switch (opcao){

      case 1:
        inserir(); 
        break;
    
      case 2:
        remover();
        break;

      case 3:
        exibirProcessos();
        break;
    }

  }while(opcao != 0);

}