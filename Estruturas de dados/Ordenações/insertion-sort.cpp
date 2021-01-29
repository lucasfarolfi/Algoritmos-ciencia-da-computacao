#include <iostream>
using namespace std;

void InsertionSort (int vet[], int tam){

  for (int i = 1; i < tam ; i++){
    int j = i; //J usa I como referencia para andar 1 casa no vetor

    while (j > 0 && vet[j - 1] > vet [j]){ //Se j-1 for maior que j

      swap (vet[j], vet[j - 1]); // troca
      j=j-1; //j recebe o numero no indice j-1 e refaz a comparação
    }
  }

  for (int k = 0; k < tam; k++) cout << vet[k]<< " ";
}

int main() {

  int vet[] = {5,2,1,8,4,23,12,40,35,94};
  int tam = 10;

  InsertionSort (vet, tam);
}