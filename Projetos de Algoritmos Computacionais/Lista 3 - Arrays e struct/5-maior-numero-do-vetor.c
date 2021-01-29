#include <stdio.h>

float MaiorNumero (float vet[], int tam){
  float maior = 0;

  for (int i=0; i < tam; i++){
    if (vet[i] > maior){
      maior = vet[i];
    }
  }
  return maior;
}

int main() {
  int tam;
  float vet[tam], maior;

  scanf ("%d", &tam);

  for (int i=0; i < tam; i++){
    scanf ("%f", &vet[i]);
  }

  maior = MaiorNumero (vet, tam);

  printf ("O maior numero eh: %.1f", maior);
  return 0;
}