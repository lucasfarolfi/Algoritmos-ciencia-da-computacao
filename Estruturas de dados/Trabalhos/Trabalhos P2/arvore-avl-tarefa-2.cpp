#include <iostream>
#include <stdlib.h>

using namespace std;

struct no{
  int num;
  struct no * esq;
  struct no * dir;
  int alt;
};

//Optei por não colocar * antes do No ao usar o typedef, pois antes estava tendo muito conflito com as funções que eu utilizei, e também achei mais pratico por não precisar usar constantemente * nos ponteiros que são passados por parâmetro.
typedef struct no No;

//---------- Menu -----------//
// Complexidade da função: O(1)
int menu (int opcao){
  cout << "\nEscolha uma opção:" << endl;
  cout << "1 - Inserir" << endl;
  cout << "2 - Remover" << endl;
  cout << "3 - Exibir em ordem" << endl;
  cout << "0 - Sair" << endl;
  cout << "Opção: ";

  cin >> opcao; 

  return opcao; 
}

//---------- Endereço Vazia -----------//
// Complexidade da função: O(1)
bool enderecoVazio(No* p){

  if (p == NULL) return true;

  else return false;
}

//---------- Exibir em ordem crescente -----------//
// Complexidade da função: O(n)
void exibirEmOrdem(No* p){
  system("clear");
  
  if(enderecoVazio(p) == false){
    exibirEmOrdem(p->esq);
    cout << "| " << p->num << " |" ;
    exibirEmOrdem(p->dir);
  }
}

//---------- Altura do nó -----------//
// Complexidade da função: O(1)
int altura(No* p){

  if(enderecoVazio(p) == true) return 0;

  else return p->alt;
}

//---------- MaiorAltura -----------//
// Complexidade da função: O(1)
int maiorAltura(int x, int y) {
  if (x > y) return x;
  else return y;
}

//---------- Cria Nós -----------//
// Complexidade da função: O(1)
No* criaNos (int num){ 
  No* n = new no; 
  n->num = num; 
  n->esq = NULL; 
  n->dir = NULL; 
  n->alt = 1;

  system("clear");
  cout << "O nó " << n->num << " foi inserido no endereço "<< n << "." << endl;
  return n; 
} 

//---------- Fator Balanceamento -----------//
// Complexidade da função: O(1)
int fatorBalanceamento(No* p){
  if(enderecoVazio(p) == true) return 0;

  else return altura(p->esq) - altura(p->dir);
}

//---------- Rotação simples a esquerda -----------//
// Complexidade da função: O(1)
No* rotacaoEE(No* x){
  No* y = x->dir;
	No* aux = y->esq;
	
  // Faz a rotação
  y->esq = x;
  x->dir = aux;

  // Atualiza as alturas
  x->alt = 1 + maiorAltura (altura (x->esq), altura (x->dir) );
  y->alt = 1 + maiorAltura (altura (y->esq), altura (y->dir) );

  return y;
}

//---------- Rotação simples a direita -----------//
// Complexidade da função: O(1)
No* rotacaoDD(No* y){
  No* x = y->esq;
  No* aux = x->dir;

  // Faz a rotação
  x->dir = y;
  y->esq = aux;

  // Atualiza as alturas
  y->alt = 1 + maiorAltura (altura (y->esq), altura (y->dir) );
  x->alt = 1 + maiorAltura (altura (x->esq), altura (x->dir) );

  return x;
}

//---------- Menor elemento à direita -----------//
// Complexidade da função: O(1)
No* menorDireita(No* p){
  No* aux = p;

  if(aux->esq != NULL){
    aux = menorDireita(aux->esq);
  }
  return aux;
}

//---------- Inserir ----------//
// Complexidade da função: O(log(n))
No* inserir(No* p, int num){

  if (enderecoVazio(p) == true){
    return criaNos(num);
  }

  else{

    if(num < p->num){
      p->esq = inserir(p->esq, num);
    }
    else if(num >= p->num){
      p->dir = inserir(p->dir, num);
    }

    //Calcula Altura do nó pai
    p->alt = 1 + maiorAltura (altura (p->esq), altura (p->dir) );
      
    //Calculo do fator de balanceamento
    int fb = fatorBalanceamento(p);

    //--- Em casos de desbalanceamento ---//

    // Esquerda-Esquerda
    if(fb > 1 && num < p->esq->num){
      return rotacaoDD(p);
    }
    
    // Direita-Direita
    if(fb < -1 && num > p->dir->num){
      return rotacaoEE(p);
    }

    // Esquerda-Direita
    if(fb > 1 && num > p->esq->num){
      p->esq = rotacaoEE(p->esq);
      return rotacaoDD(p);
    }

    // Direita-Esquerda
    if(fb < -1 && num < p->dir->num){
      p->dir = rotacaoDD(p->dir);
      return rotacaoEE(p);
    }
   
    return p;
  }
}

//---------- Remover -----------//
// Complexidade da função: O(log(n))
No* remover(No* p, int num){

  if(enderecoVazio(p) == true){
    system("clear");
    cout << "A árvore está vazia !!!" << endl;
    return p;
  }
  else{

    // Se o número for menor que o nó que está sendo apontado
    if (num < p->num){
      p->esq = remover(p->esq, num);
	  }

    // Se o número for maior que o nó que está sendo apontado
    else if(num > p->num){
	    p->dir = remover(p->dir, num);
	  }

    // Se o nó for encontrado
    else{

      // Se o nó não possui ou possui apenas um filho
      if( (p->esq) == NULL || (p->dir) == NULL){

        // Se p->esq não for nulo, receberá p->dir, sendo NULL ou não
        No* aux = (p->esq != NULL) ? p->esq : (p->dir);

        // Se os dois forem NULL
        if(aux == NULL){
          aux = p;
          p = NULL;
        }
        // Se apenas um for NULL
        else{
          *p = *aux; //Copia aux
          delete(aux);
        }
      }

      // Se o nó possui dois filhos
      else{

        // Aux receberá o menor dos nós à direita do nó a ser removido
        No* aux = menorDireita(p->dir);

        // O número do nó a ser removido será trocado pelo menor dos nós à direita
        p->num = aux->num;

        // Aqui será feito a remoção do valor
        p->dir = remover(p->dir, aux->num);
      }
    }//fim else nó encontrado

  }//fim else (endereço != NULL)

  system("clear");
  cout << "O nó foi removido com sucesso !!!" << endl;

  // Se a raiz for nula
  if (p == NULL) return p;
  
  // Se a raiz não for nula
  else{

    p->alt = 1 + maiorAltura (altura (p->esq), altura (p->dir) );
      
    //Calculo do fator de balanceamento
    int fb = fatorBalanceamento(p);

    //--- Em casos de desbalanceamento ---//

    // Esquerda-Esquerda
    if(fb > 1 && fatorBalanceamento(p->esq) >= 0){
      return rotacaoDD(p);
    }
    
    // Direita-Direita
    if(fb < -1 && fatorBalanceamento(p->dir) <= 0){
      return rotacaoEE(p);
    }

    // Esquerda-Direita
    if(fb > 1 && fatorBalanceamento(p->esq) < 0){
      p->esq = rotacaoEE(p->esq);
      return rotacaoDD(p);
    }

    // Direita-Esquerda
    if(fb < -1 && fatorBalanceamento(p->dir) > 0){
      p->dir = rotacaoDD(p->dir);
      return rotacaoEE(p);
    }
   
    return p;
  }
}

//---------- Main -----------//
int main(){
	
	No* raiz = NULL;
	int num, opcao;

	do{
		
    opcao = menu(opcao);

		switch(opcao){

			case 1:
				cout << "\nDigite o valor do elemento: ";
				cin >> num;
				raiz = inserir(raiz, num);
				break;

			case 2:
				cout << "\nDigite o elemento a ser removido: ";
        cin >> num;
				raiz = remover(raiz, num);
				break;
      
      case 3:
        if(enderecoVazio(raiz) == false){
          exibirEmOrdem(raiz);
        }
        else{
          system("clear");
          cout << "A árvore está vazia !!!";
        }
        cout << endl;
        break;

		}//fim switch

	} while(opcao != 0);
	
}// fim algoritmo