#include <iostream>
using namespace std;

struct no{
  int num;
  struct no * ant;
  struct no * prox;
};

typedef struct no * No;

No primeiro_fila;

//Menu da fila

void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Exibir Normal" << endl;
  cout << "4 - Exibir Invertido" << endl;
  cout << "0 - Sair" << endl;
  cout << "Opção: ";
}

//Função listaVazia

bool listaVazia (No topo){
  
  if (topo == NULL) return true; 

  else return false; 
}

//Funções de exibição

void exibirNormal (No topo){

  No aux = primeiro_fila;

  if(listaVazia(topo) == true){
    system("clear");
    cout << "A lista ja esta vazia." << endl;
  }
  else{

    system("clear");

    do{
      cout << aux->num << " | ";
      aux = aux->ant;
    } while (aux != NULL);

    cout << "" << endl; // Pula a linha após exibir a fila
  }
}

void exibirInvertido (No topo){

  system("clear");

  if(listaVazia(topo) == true){
    system("clear");
    cout << "A lista está vazia." << endl;
  }
  else {
    No aux = topo;

    system("clear");

    do{
      
      cout << aux->num << " | "; 
      aux = aux->prox; 

    }while (aux != NULL); 

    cout << "" << endl;
  }
}



//Funções Inserir e Remover

void inserir(No * i){

  No p = new no;

  cout<< "\nDigiteo valor do elemento: ";
  cin >> p->num; 
  p->ant = NULL;  

  if(listaVazia(*i)){
    p->prox = NULL;
    primeiro_fila = p; //O primeiro da fila será o primeiro nó criado
  }
  else{
    p->prox = *i;
    (*i)->ant = p;
  }

  *i = p;

  system("clear");
}

void remover(No * i){

  No aux = *i;

  if(!listaVazia(*i)){

    if(aux->prox == NULL){
      *i = NULL;
    }
    else{
      aux = primeiro_fila;
      primeiro_fila = primeiro_fila->ant;
      primeiro_fila->prox = NULL;
    }
    delete (aux);

    system("clear");
    cout <<"\nO primeiro da fila foi retirado .\n";
  }

  else{
    system("clear");
    cout << "\nA lista ja esta vazia." << endl;
  }
}

int main() {

  No topo = NULL;

  int op;

  do {

    menu ();

    cin>> op;
      
    switch(op){
      case 1: 
      inserir(&topo); 
      break;
        
      case 2: 
      remover(&topo); 
      break;
        
      case 3: 
      exibirNormal(topo); //Esta função exibe pegando o próximo do nó
      break;

      case 4: 
      exibirInvertido(topo); //Já esta função exibe pegando o anterior do nó
      break;
    }

  } while(op!=0);

  return 0;
}