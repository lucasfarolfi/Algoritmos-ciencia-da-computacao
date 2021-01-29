#include <stdio.h>
#include <math.h>

int calcula_media (int n1, int n2, int n3);

int main() {
  int n1, n2, n3, media;

  printf ("Digite tres numeros: ");
  scanf ("%d%d%d", &n1, &n2, &n3);

  media = calcula_media (n1, n2, n3);

  printf ("A media dos tres numeros eh %d", media);
  return 0;
}
int calcula_media (int n1, int n2, int n3){
  int media;

  media = (n1 + n2 + n3)/(3);
  return media;
}