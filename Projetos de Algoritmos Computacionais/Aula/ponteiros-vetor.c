#include <stdio.h>

int CalculaSoma (int vetor [], int x){
  int soma = 0;
  int *p;
  int * pfinal = vetor + x; // O ponteiro agora aponta para o ultimo numero do vetor

  for (p = vetor; p < pfinal; ++p){ // ponteiro P aponta pro primeiro numero do vetor
    soma += *p;
  }
  return soma;
}

int main() {
  int vetor [] = {5, 5, 5, 5, 5};
  int soma;

  soma = CalculaSoma (vetor, 5);

  printf ("A soma dos vetores eh: %d", soma);
  return 0;
}