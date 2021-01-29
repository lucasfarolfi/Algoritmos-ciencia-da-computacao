#include <stdio.h>
#include <math.h>

int calcula_soma (int n1, int n2);
void calcula_media (int n1, int n2);

int main() {
  int n1, n2, soma;

  printf ("Digite dois numeros: ");
  scanf ("%d%d", &n1, &n2);

  soma = calcula_soma (n1, n2);
  calcula_media (n1, n2);

  printf ("\nA soma dos dois numeros eh %d", soma);
  return 0;
}
int calcula_soma (int n1, int n2){
  int soma;

  soma = n1 + n2;
  return soma;
}
void calcula_media (int n1, int n2){
  int media;

  media = (n1 + n2)/(2);
  printf ("A media entre os dois numeros eh %d", media);
}