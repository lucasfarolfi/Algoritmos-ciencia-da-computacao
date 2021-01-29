#include <stdio.h>

int CalculaAcimaMedia (float vet[], int tam, float media){
  int acima;

  for (int i=0; i<tam; i++){
    if (vet[i] > media){
      acima += 1;
    }
  }
  return acima;
}

int main() {
  int tam, acima;
  float vet[tam], media;

  scanf ("%d", &tam);

  for (int i=0; i < tam; i++){
    scanf ("%f", &vet[i]);
  }

  for (int i=0; i<tam; i++){
    media += vet[i];
  }
  media = (media)/(tam);

  acima = CalculaAcimaMedia (vet, tam, media);

  printf ("%d numero(s) acima da media !!!", acima);
  return 0;
}