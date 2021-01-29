#include <iostream>
using namespace std;

struct no{
  int num;
  struct no * ant;
  struct no * prox;
};

typedef struct no * No;

//----- Função Menu -----//
void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Exibir" << endl;
  cout << "4 - Exibir Invertido" << endl;
  cout << "0 - Sair" << endl;
}

//----- Função Lista Vazia -----//
bool listaVazia (No topo){

  if(topo == NULL) return true;

  else return false;
}

//----- Função Exibir -----//
void exibir (No topo, int qtd_no){
  
  system("clear");

  if(listaVazia(topo) == true){
    cout << "A lista está vazia !!!" << endl;
  }
  else{
    No aux = topo;

    for(int i = 0; i < qtd_no *2; i++){
      cout << aux->num << " | ";
      aux = aux->prox;
    }
    cout << " " << endl;
  }
}

//----- Função Exibir Invertido -----//
void exibirInvertido (No topo, No ultimo, int qtd_no){
  
  system("clear");

  if(listaVazia(topo) == true){
    cout << "A lista está vazia !!!" << endl;
  }
  else{
    No aux = ultimo;

    for(int i = qtd_no * 2; i > 0; i--){
      cout << aux->num << " | ";
      aux = aux->ant;
    }
    cout << " " << endl;
  }
}

//----- Função Inserir -----//
void inserir (No *topo, No *ultimo, int *qtd_no){
  No p = new no;

  cout << "\nDigite o valor do elemento: ";
  cin >> p->num;

  if(listaVazia(*topo) == true){
    *topo = p; //topo aponta para P
    p->prox = *topo; //p->prox aponta para topo, pois a lista precisa ficar em loop
    *ultimo  = p;
  }
  else{
    p->prox = *topo;
    p->prox->ant = p;
    *topo = p;
    (*ultimo)->prox = *topo;
  }
  p->ant = *ultimo;

  system("clear");
  *qtd_no = *qtd_no + 1;
}

//----- Função Remover -----//
void remover (No *topo, No *ultimo, int *qtd_no){

  if(listaVazia(*topo) == true){
    system("clear");
    cout << "A lista já está vazia !!!" << endl;
  }
  else{
    No aux = *topo;

    if(*qtd_no == 1){
      *topo = NULL;
      *ultimo = NULL;
    }
    else{
      *topo = (*topo)->prox;
      (*topo)->ant = *ultimo;
      (*ultimo)->prox = *topo;
    }

    system("clear");
    cout << "O número "<< aux->num <<" foi removido da lista." << endl;
    delete(aux);

    *qtd_no = *qtd_no - 1;
  }
}

//----- Main -----//
int main() {

  No topo = NULL, ultimo;
  int opcao, qtd_no = 0;

  do{
    menu ();

    cout << "Opção: ";
    cin >> opcao;    

    switch (opcao){

      case 1:
        inserir(&topo, &ultimo, &qtd_no);
        break;
    
      case 2:
        remover(&topo, &ultimo, &qtd_no);
        break;

      case 3:
        exibir(topo, qtd_no);
        break;

      case 4:
        exibirInvertido(topo, ultimo, qtd_no);
        break;
    }

  }while(opcao != 0);
}