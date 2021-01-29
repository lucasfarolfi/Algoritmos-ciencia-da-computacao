#include <stdio.h>

int calcula_soma ();
void calcula_media (int soma);

int main() {
  int soma;
  
  soma = calcula_soma ();
  calcula_media (soma);
  return 0;
}

int calcula_soma (){
  int n1, n2, soma;
  scanf ("%d%d", &n1, &n2);

  soma = n1 + n2;
  printf ("A soma dos dois numeros eh %d", soma);

  return soma;
}
void calcula_media (int soma){
  int media;

  media = soma/2;

  printf ("\nA media dos numeros eh %d", media);
}