#include <stdio.h>

int CalculaMaioresNumeros (float vet[], int tam){
  int nummaiores = 0;

  
  for (int i=0; i < tam-1; i++){
   if (vet[i] > vet [tam-1]){
      nummaiores += 1;
    }
  }

  return nummaiores;
}

int main() {
  int tam, nummaiores;
  float vet[tam];

  scanf ("%d", &tam);

  for (int i=0; i<tam; i++){
    scanf ("%f", &vet[i]);
  }

  nummaiores = CalculaMaioresNumeros (vet, tam);

  printf ("%d numero(s) maiores que o ultimo valor armazenado !!!", nummaiores);
  return 0;
}