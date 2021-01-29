#include <iostream>
using namespace std;

struct no{
  int num;
  struct no * prox;
};
typedef struct no *No;

No topo = NULL;

void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir:" << endl;
  cout << "2 - Buscar:" << endl;
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
      cout << aux->num << " | ";
      aux = aux->prox;
    }while (aux != NULL);
    cout << "" << endl;
  }
  
}

void inserir (){

  No ant, aux, p = new no;

  cout << "Digite um valor: ";
  cin >> p->num;

  if (listaVazia() == true){
    p->prox = topo; // p->prox irá receber nulo
    topo = p;
  }
  else{
    
    aux = topo;

    while(aux != NULL && p->num > aux->num){

      ant = aux;
      aux = aux->prox;
    
    }  
    if (aux == topo){
      p->prox = aux;
      topo = p;
    }
    else{
      p->prox = aux;
      ant->prox = p;
    }
  }
  
  system("clear");
}

void buscar (){

  system("clear");

  No busca = topo;
  bool numeroEncontrado;
  int numero;
  
  cout << "Digite o valor a ser encontrado: ";
  cin >> numero;

  if (listaVazia () == true){
    cout << "A lista está vazia.";
  }
  else{

    while (busca != NULL && numeroEncontrado == false){
      
      if (busca->num == numero){
        cout << "Valor encontrado !!!" << endl;
        numeroEncontrado = true;
      }
      busca = busca->prox;
    }
    if(numeroEncontrado == false){
      cout << "Este numero não está incluso na lista" << endl;
    }
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
        exibirLista();
        break;
    }

  }while(opcao != 0);

  return 0;
}