#include <iostream>
#include <stdlib.h>
using namespace std;

//Struct do tipo spool
struct spool
{
	int cod;
	struct spool * prox;
};

typedef struct spool * No;

No topo = NULL;
No ultimo; 

//Funções:

void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Exibir" << endl;
  cout << "0 - Sair" << endl;
}

bool listaVazia (){
  
  if (topo == NULL) return true; // Retorna 1

  else return false; // Retorna 0
}

void exibirLista(){

  if(listaVazia() == true){
    cout << "\nA lista está vazia." << endl;
  }
  else {
    No aux = topo; //Aux receberá o que o topo está apontando

    do{
      system("clear");
      cout << aux->cod << " | "; //Exibe o valor do elemento
      aux = aux->prox; //pula para o proximo nó

    }while (aux != NULL); //Termina o laço quando o aux receber o nulo
    cout << "" << endl;
  }
  
}

void Inserir (){

  system ("clear");

  No p = new spool; //P apontará para o novo nó criado

  cout << "Digite a impressão a ser inserida: ";
  cin >> p->cod; //O valor entrará no nó apontado por p

  p->prox = NULL;

  if(listaVazia () == true){
    topo = p; //Topo recebe P e começa a apontar para o novo nó
    ultimo = topo; //*ultimo vai receber topo e apontar para o novo nó
  }
  else{
    
    ultimo->prox = p; //O proximo do ultimo nó receberá p = novo nó
    ultimo = p; //O ultimo passa a apontar para P = novo nó
  }

  system("clear");
}

void Remover (){

  system("clear");
  
  No aux; //Cria-se uma struct auxiliar

  if (listaVazia () == true){
    cout << "\nNão foi possível executar este comando, pois a lista já está vazia." << endl;
  }
  else{
    aux = topo; //auxiliar recebe o topo e aponta para o primeiro nó da lista
    topo = aux->prox; // topo recebe o proximo nó
    delete (aux); //Aux é apagado junto com o primeiro nó da lista apontado

    cout << "\nA impressão foi removido da fila." << endl;
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
        Inserir(); //Função que acrescenta um elemento na fila
        break;
    
      case 2:
        Remover();//Função que remove o primeiro elemento da fial
        break;

      case 3:
        exibirLista();
        break;
    }

  }while(opcao != 0);

  return 0;
}