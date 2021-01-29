#include <stdio.h>

void SomaVetores (float vet1[], float vet2[], float vet3[], int tam){
  
  for (int i = 0; i < tam; i++){
    vet3[i] = vet1[i] + vet2[i];
    printf ("%.1f ", vet3[i]);
}
  }
  

int main() {
  int tam;
  float vet1[tam], vet2[tam], vet3[tam];

  scanf ("%d", &tam);
  
  printf ("Digite os valores do vetor 1: ");
  for (int i = 0; i < tam; i++){
    scanf ("%f", &vet1[i]);
  }
  printf ("Digite os valores do vetor 2: ");
  for (int i = 0; i < tam; i++){
    scanf ("%f", &vet2[i]);
  }

  SomaVetores (vet1, vet2, vet3, tam);
  return 0;
}