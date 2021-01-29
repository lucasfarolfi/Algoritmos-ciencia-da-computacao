#include <iostream>

using namespace std;

int main() {

  //Array que será ordenado
  int v[] = {5,4,1,9,6,3,7,8};
  int n = 8;

  //Percorre do vetor 0 até o vetor 4
  for(int i = 0; i < n - 1; i++){
  
    //variável auxiliar que ajudará a ordenar
    int aux = 0;

    //vetor que percorrerá números a frente do vetor[i]
    for(int j = i + 1; j < n; j++){

      //Se o vetor j for maior que o vetor i, será feito a troca
      if (v[i] > v[j]){

        //auxiliar recebe o valor de vetor i, o vetor i recebe o valor do vetor j, e o vetor j recebe o valor da variavel auxiliar
        aux = v[i];
        v[i] = v[j];
        v[j] = aux;
      }
    }
  }

  for(int k = 0; k < n; k++) cout << v[k] << " " ;
}