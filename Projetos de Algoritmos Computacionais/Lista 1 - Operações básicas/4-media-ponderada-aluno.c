#include <stdio.h>
#include <math.h>

float calc_pond (float n1, float n2);

int main() {
  float n1, n2, media;

  printf ("Digite as duas notas do aluno: ");
  scanf ("%f%f", &n1, &n2);

  media = calc_pond (n1, n2);

  printf ("A media do aluno eh %.2f", media);
  return 0;
}
float calc_pond (float n1, float n2){
  float media;

  media = (n1 * 2 + n2 * 4)/(2+4);
  return media;
}