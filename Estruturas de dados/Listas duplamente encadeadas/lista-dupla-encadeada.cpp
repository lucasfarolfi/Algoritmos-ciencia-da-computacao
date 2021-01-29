#include <iostream>
using namespace std;

struct no{
  int num;
  struct no * ant;
  struct no * prox;
};

typedef struct no * No;

//Função menu:
void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Exibir" << endl;
  cout << "0 - Sair" << endl;
}
//Função da Lista Vazia:
bool listaVazia (No topo){

  if (topo == NULL) return true;

  else return false;
}
//Função de exibir:
void exibir (No topo){
  
  No aux = topo;

  if (listaVazia(topo) == true){
    system("clear");
    cout << "A lista está vazia !!!" << endl;
  } 
  else{
    system("clear");

    do{
      cout << aux->num << " | ";
      aux = aux->prox;
    } while (aux != NULL);
    
  }
}
//Inserir e Remover:
void inserir(No * i){
  No p = new no;

  cout<< "\nDigiteo valor do elemento: ";
  cin >> p->num;
  p->ant = NULL;

  if(listaVazia(*i)){
    p->prox = NULL;
  }
  else{
    p->prox = *i;
    (*i)->ant = p;
  }

  *i = p;
}
void remover(No * i){

  No p = *i;

  if(listaVazia(*i) == false){

    if(p->prox == NULL){
      *i = NULL;
    }
    else{
      *i = (*i)->prox;
      (*i)->ant = NULL; // ou *i->ant
    }

    delete (p);
    cout <<"\nO elemento foi retirado da lista!\n";
  }

  else{
    cout << "\nA lista ja esta vazia." << endl;
  }
}

int main() {

  No topo = NULL;

  int op;

  do {

    system ("clear");

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
      exibir(topo); 
      break;
    }
  } while(op!=0);

}