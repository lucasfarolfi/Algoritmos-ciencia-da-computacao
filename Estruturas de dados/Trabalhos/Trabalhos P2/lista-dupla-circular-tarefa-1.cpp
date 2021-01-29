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

    for(int i = 0; i < qtd_no; i++){
      
      if(i == 0){ //Primeiro nó
        cout << aux->num << " " << aux << " | "; //Valor + Endereço
      }
      else if(i == qtd_no - 1){ //Último nó
        cout << aux->num << " " << aux->prox << " | "; //Valor + Endereço do próximo
      }
      else{ //Nó entre o primeiro e o último
        cout << aux->num << " | ";
      }
      
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

    for(int i = qtd_no; i > 0; i--){

      if(i == qtd_no){ //Primeiro nó
        cout << aux->num << " " << aux << " | "; //Valor + Endereço
      }
      else if(i == 1){ //Último nó
        cout << aux->num << " " << aux->ant << " | "; //Valor + Endereço do próximo
      }
      else{ //Nó entre o primeiro e o último
        cout << aux->num << " | ";
      }
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

  if(listaVazia(*topo) == true){ //Quando a lista estiver vazia

    *topo = p;
    p->prox = *topo; //p->prox apontará para ele mesmo, tornando-se circular
    *ultimo  = p;
  }
  else{ //Quando a lista não estiver vazia

    p->prox = *topo; 
    p->prox->ant = p; 
    *topo = p;
    (*ultimo)->prox = *topo; //O último->prox apontará para p, tornando-se circular
  }
  p->ant = *ultimo;

  system("clear");
  *qtd_no = *qtd_no + 1;

  cout << "O novo elemento foi armazenado no endereço " << p << endl;
}

//----- Função Remover -----//
void remover (No *topo, No *ultimo, int *qtd_no){

  bool numeroEncontrado = false;
  int num;
  No busca = *topo, ant;
  
  cout << "\nDigite o número a ser removido: ";
  cin >> num;

  if(listaVazia(*topo) == true){ //Se a lista estiver vazia
    system("clear");
    cout << "A lista já está vazia !!!" << endl;
  }

  else{ //Se a lista não tiver vazia
    
    busca = *topo;

    for(int i = 1; i <= *qtd_no && numeroEncontrado == false ; i++){

      if(busca->num == num){ //Se o número for encontrado

        if(busca == *topo && *qtd_no == 1){ //Primeiro nó a remover| Quando houver só um nó
          *topo = NULL;
          *ultimo = NULL;
        }
        else if(busca == *topo && *qtd_no > 1){ //Primeiro nó a remover| Quando houver mais de um nó
          *topo = (*topo)->prox;
          (*topo)->ant = *ultimo;
          (*ultimo)->prox = *topo;
        }
        else if(busca != *topo && busca->prox != *topo){ //Nó entre o primeiro e último nó
          ant->prox = busca->prox;
          busca->prox->ant = ant;
        }
        else if(busca != *topo && busca->prox == *topo){ //Último nó
          *ultimo = (*ultimo)->ant;
          (*ultimo)->prox = *topo;
          (*topo)->ant = *ultimo;
        }

        numeroEncontrado = true;
        system("clear");
        cout << "O elemento foi removido da lista !!!" << endl;
        delete(busca);
        
        *qtd_no = *qtd_no - 1;
      }// fim if

      ant = busca;
      busca = busca->prox;
    }//fim for
    
    if(numeroEncontrado == false){ //Se o número não for encontrado
      system("clear");
      cout << "Este elemento não foi encontrado na lista !!!" << endl;
    }

  }//fim else (listaVazia == true)
}//fim remover

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