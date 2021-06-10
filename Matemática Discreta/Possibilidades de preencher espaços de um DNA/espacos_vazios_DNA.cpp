#include <iostream>
using namespace std;

struct no{
  string valor;
  struct no * prox;
};

typedef struct no * No;
No topo = NULL;

void saida(char a[], char b[], int tA, int tB){

  //Transforma as letras do array atual no caractere #
  for(int i=0; i<tA; i++){
   if((a[i] >= 'A' && a[i] <= 'Z') || (a[i] >= 'a' && a[i] <= 'z')){
     a[i] = '#';
   } 
  }

  //Trocar os caracteres # para as letras da cadeia menor original
  int contB = 0;
  for(int k=0; k<tA; k++){
    if(a[k] == '#'){
      a[k] = b[contB];
      contB++;
    }
  }

  //Lista encadeada que contem os resultados sem permutar as letras da cadeia
  string sA = a;

  if(topo == NULL){
    No p = new no;

    p->valor = sA;
    p->prox = topo;
    topo = p;
  }
  else {
    No aux = topo;
    bool achouString = false;

    do{
      if(aux->valor == sA){
        achouString = true;
        break;
      }
      aux = aux->prox;
    }while (aux != NULL);
    
    if(achouString == false){
      No p = new no;

      p->valor = sA;
      p->prox = topo;
      topo = p;

      for(int i=0; i < tA; i++){
        cout << a[i];
      } 
      cout << endl;
    }
  }
}

//Função que Permuta os espaços vazios
void possibilidades(char cad[], int t, char cadmc[] ,int tmc, int tmc2){
  if(t == 1){
    saida(cad, cadmc ,tmc, tmc2);
  }

  for(int i=0; i < t; i++){
    possibilidades(cad, t-1,cadmc, tmc, tmc2);

    swap(cad[i], cad[t-1]);

    possibilidades(cad, t-1,cadmc, tmc, tmc2);
  }
}

void adicionar_EspacoVazio(char menorCad[], int Tam_MenorC, int Tam_MaiorC){

  int espacosBrancos = Tam_MaiorC - Tam_MenorC;  
  int tamSubcad = Tam_MenorC + espacosBrancos;
  char subCad[tamSubcad];

  //Guarda todos os resultados

  for(int i=0; i < Tam_MenorC; i++) subCad[i] = menorCad[i];
  
  for(int j=0; j < espacosBrancos; j++) subCad[Tam_MenorC + j] = '_';

  cout << "\nManeiras de adicionar espaços vazios: " << endl;

  for(int k=0; k < tamSubcad; k++) cout << subCad[k];
  cout << endl;
  possibilidades(subCad, tamSubcad, menorCad,tamSubcad, Tam_MenorC);
}

int main() {

  int tamCadeia1 = 0, tamCadeia2 = 0;
  
  cout << "### Maneiras de incrementar espaço vazio ###\n" << endl;

  //Entrada da cadeia 
  cout << "Digite o tamanho da primeira cadeia: ";
  cin >> tamCadeia1;

  char cadeia1[tamCadeia1];
  cout << "Digite a primeira cadeia (Sem espaço): ";
  scanf("%s", cadeia1);

  //Entrada da cadeia 2
  cout << "\nDigite o tamanho da segunda cadeia: ";
  cin >> tamCadeia2;

  char cadeia2[tamCadeia2];
  cout << "Digite a segunda cadeia (Sem espaço): ";
  scanf("%s", cadeia2);
  
  //Comparador de cadeia
  if(tamCadeia1 >= tamCadeia2){
    adicionar_EspacoVazio(cadeia2, tamCadeia2, tamCadeia1);
  }
  else{
    adicionar_EspacoVazio(cadeia1, tamCadeia1, tamCadeia2);
  }
  
}