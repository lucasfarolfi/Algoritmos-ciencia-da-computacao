#include <iostream>
using namespace std;

//------- Função Maior Subcadeia -------//
void maiorSubcadeia(char maiorCad[], int Tam_MaiorC ,char menorCad[], int Tam_MenorC){

  char subCad[Tam_MaiorC];
  string cadAtual;

  int maiorCadeia = 0;
  int contCadeia = 0;

  //Sentido normal
  for(int j=0; j < Tam_MenorC; j++){
    for(int i=0; i < Tam_MaiorC; i++){
 
      if(maiorCad[i] == menorCad[i+j]){
        ++contCadeia;
        cadAtual += maiorCad[i];

        if(contCadeia > maiorCadeia){

          for(int k=0; k < contCadeia; k++) subCad[k] = cadAtual[k];
          maiorCadeia = contCadeia;
        }
      }
      else{
        cadAtual = "";
        contCadeia = 0;
      }
    }
  }

  //Sentido inverso
  for(int j=Tam_MenorC-1; j >= 0; j--){
    for(int i=0; i < Tam_MaiorC; i++){
 
      if(maiorCad[i] == menorCad[j-i]){
        ++contCadeia;
        cadAtual += maiorCad[i];

        if(contCadeia > maiorCadeia){

          for(int k=0; k < contCadeia; k++) subCad[k] = cadAtual[k];
          maiorCadeia = contCadeia;
        }
      }
      else{
        cadAtual = "";
        contCadeia = 0;
      }
    }
  }
  
  //Imprime a maior subcadeia
  cout << "\nMaior subcadeia: ";
  for(int i=0; i < maiorCadeia; i++) cout << subCad[i] << " ";
  cout << "\n\nTamanho: " << maiorCadeia;
}

//------- Main -------//
int main() {

  int tamCadeia1 = 0, tamCadeia2 = 0;
  
  cout << "### Calculadora da maior sequencia do DNA ###\nObs: Digite apenas os caracteres A, C, G e T, e sem espaço entre os mesmos\n" << endl;

  //Entrada da cadeia 1
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
    maiorSubcadeia(cadeia1, tamCadeia1, cadeia2, tamCadeia2);
  }
  else{
    maiorSubcadeia(cadeia2, tamCadeia2, cadeia1, tamCadeia1);
  }
  
}