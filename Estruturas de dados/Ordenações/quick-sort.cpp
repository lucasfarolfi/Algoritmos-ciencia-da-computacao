#include <iostream>
#include <stdlib.h>

using namespace std;

void troca (int *a, int *b){
  
  int aux;

  aux = *a;
  *a = *b;
  *b = aux;
}

void quicksort (int vet[], int inicio, int fim){

  int i, j, chave;

  int meio = fim - inicio;

  if (meio < 2) {
    
    if ((meio) == 1) {
      
      if(vet[inicio] > vet[fim]){
        troca (&vet[inicio], &vet[fim]);
      }
    }
  }
  else{

    i= inicio;
    j= fim;
    chave = vet[inicio];

    while(j > i) {
      i++;
      
      while(vet[i] < chave) {
        i++;
      }
      while(vet[j] > chave) {
        j --;
      }
      if(j > i) { 
        troca (&vet[i], &vet[j]);
      }

    } 

    troca (&vet[inicio], &vet[j]);
    quicksort(vet, inicio, j - 1);
    quicksort(vet, j + 1, fim);

  } 
} 

int main() {
  
  int vet[] = {30,20,70,80,50,40};
  int tamanho = 6;

  quicksort (vet, 0, tamanho-1);

  for(int i=0; i < tamanho; i++) cout << vet[i] << " ";
}