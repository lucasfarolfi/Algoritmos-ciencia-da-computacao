#include <stdio.h>

int ParImpar (int vetor[], int tam);

int main() {
  int tam;
  int vetor[tam];
  scanf ("%d", &tam);

  for (int i=0; i<tam; i++){
    scanf ("%d", &vetor[i]);
  }
  ParImpar (vetor, tam);
  
  return 0;
}

int ParImpar (int vetor[], int tam){
  int par, impar;

  for (int i=0; i<tam; i++){
    if (vetor[i] % 2 == 0){
      par += 1;
    }
    else {
      impar += 1;
    }
  }
  printf ("%d par | %d impar", par, impar);

  return par;
}