#include <iostream>
#include <stdlib.h>

using namespace std;

struct no{
  string nome;
  int num;
  struct no * prox;
};
typedef struct no *Contato;

Contato topo = NULL;

void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Adicionar contato" << endl;
  cout << "2 - Buscar contato" << endl;
  cout << "3 - Remover contato" << endl;
  cout << "4 - Exibir" << endl;
  cout << "0 - Sair" << endl;
}

bool listaVazia (){

  system("clear");
  
  if (topo == NULL) return true;

  else return false;
}

void exibirLista(){

  if(listaVazia() == true){
    cout << "\nA lista está vazia." << endl;
  }
  else {
    Contato aux = topo;

    do{
      system("clear");
      cout << aux->nome << " ";
      cout << aux->num << " | ";
      aux = aux->prox;
    }while (aux != NULL);
    cout << "" << endl;
  }
  
}

void inserir (){

  Contato ant, aux, p = new no;

  cout << "Digite o nome do contato: ";
  cin >> p->nome;
  cout << "Digite o número do contato: ";
  cin >> p->num;

  if (listaVazia() == true){
    p->prox = NULL; 
    topo = p;
  }
  else{
    
    aux = topo;
    while(aux != NULL && p->nome > aux->nome){

      ant = aux;
      aux = aux->prox;
    
    } 
    if (aux == topo){
      p->prox = aux;
      topo = p;
    }
    else{
      p->prox = NULL;
      ant->prox = p;
    }
  }
  
  system("clear");
}

void buscar (){

  system("clear");

  Contato busca = topo;
  bool numeroEncontrado;
  int numero;
  
  cout << "Digite o valor a ser encontrado: ";
  cin >> numero;

  if (listaVazia () == true){
    cout << "Nenhum contato existente.";
  }
  else{

    while (busca != NULL && numeroEncontrado == false){
      
      if (busca->num == numero){
        cout << "Contato encontrado, chamada sendo realizada." << endl;
        numeroEncontrado = true;
      }
      busca = busca->prox;
    }
    if(numeroEncontrado == false){
      cout << "Este este contato não existe." << endl;
    }
  }
}

void remover (){

  system("clear");

  Contato busca = topo, ant = topo;

  bool numeroEncontrado = false;
  int numero;
  
  cout << "Digite o valor a ser removido: ";
  cin >> numero;

  if (listaVazia () == true){
    cout << "Nenhum contato existente.";
  }
  else{

    while (busca!= NULL && numeroEncontrado == false){

      if(busca->num == numero){ // Acha numero procurado

        cout<<"busca->num: "<<busca->num;

        if(topo == busca && topo->prox == NULL){ // Se tiver um elemento

          topo = NULL;
        } 
        else if(topo == busca && topo->prox){ //Se o nó a ser removido for o primeiro da lista, e tiver 2 ou mais nós
          topo = topo->prox;
        }
        else{ //Se for remover o segundo ou um dos próximos números da lista

          ant->prox = busca->prox;
          cout << "ant->prox: " << ant->prox;

          cout<<"busca->num: "<<busca->num;
        }
        numeroEncontrado = true;
        delete (busca);
      } 
      ant = busca;
      busca = busca->prox;   
    }

  }
  if(numeroEncontrado == false){
    cout << "Este este contato não existe." << endl;
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
        inserir(); //Função que empilha os nós
        break;
    
      case 2:
        buscar();//Função que remove o ultimo nó que entrou
        break;

      case 3:
        remover();
        break;

      case 4:
        exibirLista();
        break;
    }

  }while(opcao != 0);

  return 0;
}