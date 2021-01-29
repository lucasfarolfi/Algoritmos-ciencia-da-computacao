#include <iostream>
using namespace std;

struct no{
  int num;
  struct no * ant;
  struct no * prox;
};

typedef struct no * No;
No topo = NULL;
No ultimo;

//---Função menu---//
void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Exibir Ordem Crescente" << endl;
  cout << "4 - Exibir Ordem Decrescente" <<endl;
  cout << "0 - Sair" << endl;
  cout << "Opção: ";
}
//---Função da Lista Vazia---//
bool listaVazia (){

  if (topo == NULL) return true;

  else return false;
}
//---Funções de exibição---//

//-Crescente-//
//Pior Caso: O(n), pois percorre toda a lista para exibir a lista através de estrutura de repetição.
void Crescente (){
  
  No aux = topo;

  if (listaVazia() == true){
    system("clear");
    cout << "A lista está vazia !!!" << endl;
  } 
  else{
    system("clear");

    do{
      cout << aux->num << " | ";
      aux = aux->prox;
    } while (aux != NULL);
    
    cout << "" <<endl;
  }
}

//-Decrescente-//
//Pior Caso: O(n), pois percorre toda a lista para exibir a lista através de estrutura de repetição.
void Decrescente (){
  
  No aux = ultimo;

  if (listaVazia() == true){
    system("clear");
    cout << "A lista está vazia !!!" << endl;
  } 
  else{
    system("clear");

    do{
      cout << aux->num << " | ";
      aux = aux->ant;
    } while (aux != NULL);

    cout << "" <<endl;
  }
}
//---Inserir e Remover---//

//-Inserir-//
//Pior Caso: O(n), pois no pior caso terá que percorrer toda a lista para inserir o maior elemento (último), através da estrutura de repetição.
void inserir(){
  
  No ant, aux, p = new no;

  cout<< "\nDigiteo valor do elemento: ";
  cin >> p->num;
  p->ant = NULL;

  if(listaVazia() == true){ //Quando não tem nenhum nó
    p->prox = NULL; 
    topo = p;
    ultimo = p;
  }

  else{ //Quando já existe um ou mais nós

    aux = topo ;

    while (aux != NULL && p->num > aux->num){//O aux percorre a lista até achar um antigo nó maior que o novo nó ou o NULL
      ant = aux;
      aux = aux->prox;
    }
    if(aux == topo){ //Se o novo nó for menor que todos da lista (primeiro da lista)
      
      p->prox = aux;
      aux->ant = p;
      topo = p;
    }
    else{

      if (aux != NULL){ //Se o novo nó for maior que o primeiro e menor que o último da lista

        p->prox = aux; 
        aux->ant = p;

        ant->prox = p;
        p->ant = ant;
      }
      else{ //Se o novo nó for maior que todos da lista (último da lista)
        p->prox = NULL;
        ant->prox = p;
        p->ant = ant;
        ultimo = p;
      }
    
    } //fim else

  }// fim else 

  system("clear");
  cout << "O elemento foi armazenado no endereço " << p << endl;
}

//-Remover-//
//Pior Caso: O(n), pois no pior caso terá que percorrer toda a lista para remover o último elemento (maior), através da estrutura de repetição.
void remover(){
  
  No busca = topo, ant;
  bool numeroEncontrado = false;
  int num;

  cout << "\nDigite o numero a ser removido: ";
  cin >> num;

  if(listaVazia() == true){
    system("clear");
    cout << "A lista já está vazia !!!" << endl;
  }
  else{

    busca = topo;

    while(busca != NULL && numeroEncontrado == false){ //O busca percorre a lista até achar o nó ou o NULL

      if(busca->num == num){//Se o número for encontrado

        if (busca == topo && topo->prox != NULL){ //Primeiro nó a remover| Quando houver mais de um nó
          busca->prox->ant = NULL;
          topo = topo->prox;
        }
        else if(busca == topo && topo->prox == NULL){ //Primeiro nó a remover| Quando houver só um nó
          topo = NULL;
          ultimo = topo;
        }
        else if(busca != topo && busca->prox != NULL){ //Nó que está entre o segundo e o penúltimo
          ant->prox = busca->prox;
          busca->prox->ant = ant;
        }
        else if(busca != topo && busca->prox == NULL){ //Ultimo nó
          ultimo = ant;
          ant->prox = busca->prox;
        }
        numeroEncontrado = true;
        delete (busca);
        system("clear");
        cout << "O número foi removido da lista !!!" << endl;

      }//fim if (busca->num == num)
      ant = busca;
      busca = busca->prox;

    }//fim while

    if(numeroEncontrado == false){ //Caso o número da busca não for encontrado
      system("clear");
      cout << "Este número não foi encontrado na lista !!!" << endl;
    }
  }
}

//---Main---//
int main() {

  int op;

  do {

    menu ();

    cin>> op;
      
    switch(op){
      case 1: 
      inserir(); 
      break;
        
      case 2: 
      remover(); 
      break;
        
      case 3: 
      Crescente(); 
      break;

      case 4: 
      Decrescente(); 
      break;
    }
  } while(op!=0);

}