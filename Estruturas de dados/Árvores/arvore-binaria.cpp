#include <iostream>
using namespace std;

struct no{
  int num;
  struct no * esq;
  struct no * dir;
};

typedef struct no * No;

//---------- Menu -----------//
int menu (int opcao){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Exibir" << endl;
  cout << "4 - Buscar" << endl;
  cout << "0 - Sair" << endl;
  cout << "Opção: ";

  cin >> opcao; 

  return opcao; 
}

//---------- Lista Vazia -----------//
bool raizVazia(No p){

  if (p == NULL) return true;

  else return false;
}

//----- //---------- Funções de exibição -----------// -----//

//---------- Função Exibir -----------//
int exibir (int opcao){
  system("clear");
  cout << "Escolha uma opção:" << endl;
  cout << "1 - Listar em ordem" << endl;
  cout << "2 - Listar pré ordem" << endl;
  cout << "3 - Listar pos ordem" << endl;
  cout << "Opção: ";

  cin >> opcao;

  return opcao;
}

//---------- Exibir em ordem crescente -----------//
void listarEmOrdem(No p){
  system("clear");

  if(raizVazia(p) == false){
    listarEmOrdem(p->esq);
    cout << p->num << "\t";
    listarEmOrdem(p->dir);
  }
}

//---------- Exibir em pré ordem -----------//
void listarPreOrdem(No p){
  system("clear");
  
  if(raizVazia(p) == false){
    cout << p->num << "\t";
    listarPreOrdem(p->esq);
    listarPreOrdem(p->dir);
  }
}

//---------- Exibir em pós ordem -----------//
void listarPosOrdem(No p){
  system("clear");
  
  if(raizVazia(p) == false){
    listarPosOrdem(p->esq);
    listarPosOrdem(p->dir);
    cout << p->num << "\t";
  }
}

//---------- Maior dos nós à esquerda -----------//
No maiorEsquerda(No *p){

  No aux = *p;

  if(aux->dir == NULL){
    *p = (*p)->esq;
    return(aux);
  }
  else{
    return maiorEsquerda(&(*p)->dir);
  }
}
//---------- Inserir -----------//
void inserir(No *p, int num){

  if(raizVazia(*p) == true){
    *p = new no;
    (*p)->num = num;
    (*p)->esq = NULL;
    (*p)->dir = NULL;
  }
  else{
    
    if(num < (*p)->num) inserir(&(*p)->esq, num);
    
    else inserir(&(*p)->dir, num);
  }

  system("clear");
  cout << "O valor foi inserido com sucesso !!!" << endl;
}

//---------- Remover -----------//
void remover(No *p, int num){

  bool numeroEncontrado = false;
  No aux;

  if(raizVazia(*p) == true){ //Se a árvore estiver vazia
    system("clear");
    cout << "A lista está vazia !!!" << endl;
  }

  else{ //Se não estiver vazia
    
    if(num == (*p)->num){ //Se o número for encontrado
      
      aux = *p;

      if((*p)->esq == NULL){ //Se a esquerda de p for NULL
        *p = (*p)->dir; //P será substituido por *p->dir
      }
      else{ //Se a esquerda de p não for NULL

        if((*p)->dir == NULL){ //Se a direita de p for NULL
          *p = (*p)->esq; //P será substituido por *p->esq
        }
        else{ //Se a esquerda e nem direita de p for NULL, então o nó será substituido pelo maior dos subnós à esquerda

          aux = maiorEsquerda(&(*p)->esq);
          (*p)->num = aux->num;
        }

      }

      numeroEncontrado = true;
      delete(aux);
      system("clear");
      cout << "O número foi removido da árvore." << endl;
    }
    else{ //Se não for encontrado
      
      if(num < (*p)->num){
        remover(&(*p)->esq, num);
      }
      else{
        remover(&(*p)->dir, num);
      }
    }

  }// else raiz != NULL

  if(numeroEncontrado == false){
    system("clear");
    cout << "O número não foi encontrado na árvore !!!" << endl;
  }
  
}

//---------- Main -----------//
int main() {

  No raiz = NULL;
  int opcao_menu, opcao_exibir, num;
  bool numeroEncontrado;

  do{

    opcao_menu = menu (opcao_menu);

    switch (opcao_menu){

      case 1:
        cout << "\nDigite o valor do elemento: ";
        cin >> num;
        inserir(&raiz, num); 
        break;
    
      case 2:
        cout << "\nDigite o elemento a ser removido: ";
        cin >> num;
        remover(&raiz, num); 
        break;
      
      case 3:
        opcao_exibir = exibir (opcao_exibir);

        switch(opcao_exibir){
          case 1:
            listarEmOrdem(raiz);
            cout << endl;
            break;

          case 2:
            listarPreOrdem(raiz);
            cout << endl;
            break;

          case 3:
            listarPosOrdem(raiz);
            cout << endl;
            break;
        }
        break;
    }// Fim switch

  }while(opcao_menu != 0);
}