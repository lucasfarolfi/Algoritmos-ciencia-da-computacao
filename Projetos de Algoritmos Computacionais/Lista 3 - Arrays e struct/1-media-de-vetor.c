#include <stdio.h>

int CalculaMedia (int vet[], int tam){
  int media=0;
  
  for (int i = 0;  i < tam; i++){
    printf ("%d\n", vet[i]);
    media += vet[i]; 
  }
  
  media = (media)/(tam);

  return media;
}

int main() {
  int tam;
  int vet[tam], media;

  printf ("Digite a quantidade de numeros: ");
  scanf ("%d", &tam);

  for (int i = 0; i < tam; i++){
    printf ("Digite o valor do vetor %d: ", i);
    scanf ("%d", &vet[i]);
  }
  media = CalculaMedia (vet, tam);

  printf ("A media dos numeros eh: %.1d", media);
  return 0;
}

