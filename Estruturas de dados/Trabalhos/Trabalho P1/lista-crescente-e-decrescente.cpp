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

//---Função menu---
void menu (){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Ordem Crescente" << endl;
  cout << "4 - Ordem Decrescente" << endl;
  cout << "5 - Exibir" << endl;
  cout << "0 - Sair" << endl;
  cout << "Opção: ";
}
//---Função da Lista Vazia---
bool listaVazia (){

  if (topo == NULL) return true;

  else return false;
}
//---Função de exibir---
//Pior caso: O(n)

void exibir(){
  
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
    
    cout << "" << endl;
  }
}
//---Crescente e Decrescente---

//Pior caso: O(n²)
void crescente(){
  
  if (listaVazia() == true){
    system("clear");
    cout <<"A lista está vazia !!!" << endl;
  }
  else{ //Se a lista tiver elementos
  
    No i = topo, j;
    int aux;

    //Algoritmo do Blubble Sort adaptado para Lista Encadeada
    while(i != NULL){ 
      j = i->prox;

      while(j != NULL){

        if(i->num > j->num){

          aux = i->num;
          i->num = j->num;
          j->num = aux;
        }
        
        j = j->prox;//j++
      }//fim while (j)
      
      i = i->prox; //i++
    }// fim while (i)

  }//fim else

  system("clear");
  cout << "Os elementos da lista foram ordenados em ordem crescente." << endl;  
}

//Pior caso: O(n²)
void decrescente(){

  if (listaVazia() == true){
    system("clear");
    cout <<"A lista está vazia !!!" << endl;
  }
  else{ //Se a lista tiver elementos
  
    No i = topo, j;
    int aux;

    //Algoritmo do Blubble Sort adaptado para Lista Encadeada
    while(i != NULL){ 
      j = i->prox;

      while(j != NULL){

        if(i->num < j->num){

          aux = i->num;
          i->num = j->num;
          j->num = aux;
        }
        
        j = j->prox;//j++
      }//fim while (j)
      
      i = i->prox; //i++
    }// fim while (i)

  }//fim else

  system("clear");
  cout << "Os elementos da lista foram ordenados em ordem decrescente." << endl;  
}

//---Inserir e Remover---

//Pior caso: O(1)
void inserir(){
  
  No p = new no;

  cout<< "\nDigiteo valor do elemento: ";
  cin >> p->num;
  p->ant = NULL;

  if(listaVazia() == true){
    p->prox = NULL; 
    ultimo = p;
  }
  else{
    p->prox = topo;
    topo->ant = p;
  }
  topo = p;

  system("clear");
  cout << "O elemento foi armazenado no endereço " << p << endl;
}
//Pior caso: O(n)
void remover(){
  
  No busca = topo, ant;
  bool numeroEncontrado = false;
  int num;

  cout << "\nDigite o numero a ser removido: ";
  cin >> num;

  if(listaVazia() == true){
    system("clear");
    cout << "\nA lista está vazia !!!" << endl;
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
        else if(busca != topo && busca->prox != NULL){ //segundo nó em diante
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
        cout << "O número foi retirado da lista!" << endl;
      }
      ant = busca;
      busca = busca->prox;
    
    }//fim while

    if(numeroEncontrado == false){ //Caso o número da busca não for encontrado
      system("clear");
      cout << "Este número não está na lista !!!" << endl;
    }
    
  }//fim else
  
}//fim remover

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
      crescente(); 
      break;

      case 4: 
      decrescente(); 
      break;

      case 5: 
      exibir(); 
      break;
    }
  } while(op!=0);

}