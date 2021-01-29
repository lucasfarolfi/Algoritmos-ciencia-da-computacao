#include <iostream>

using namespace std;

int main() {
  
  //Vetor a ser ordenado
  int vet [] = {2,5,9,3,1};

  //Repetição que percorre na posição i (0...5)
  for(int i = 0; i < 5; i++){

    //Variável responsavel por guardar o valor de i enquanto ele é menor que os proximos numeros
    int pivo = i;

    //Repetição que percorre os numeros a direita do vetor na posição i
    for(int j = i+1; j < 5; j++){

      //Se o vetor na posição J for menor que o vetor na posição do pivô, o valor de J é passado para o pivô para ocorrer a troca
      if(vet[pivo] > vet[j]){
        pivo = j;
      }
    }

    //Caso o numero do pivô seja diferente de i, onde estava definido no começo do for, ocorrerá a troca entre o vetor na posição pivo (= vet[j]) e o vetor na posição i
    if(pivo != i){
      swap(vet[pivo], vet[i]);
    }
  }

  for (int k = 0; k < 5; k++) cout << vet[k] << " ";
}