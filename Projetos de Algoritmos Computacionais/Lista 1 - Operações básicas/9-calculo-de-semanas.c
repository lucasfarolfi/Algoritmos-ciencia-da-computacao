#include <stdio.h>

void calcula_semanas (int numdias);

int main() {
  int numdias;
  printf ("Digite o numero de dias apos o evento: ");
  scanf ("%d", &numdias);

  calcula_semanas (numdias);
  return 0;
}
void calcula_semanas (int numdias){
  int semanas, dias;

  semanas = numdias / 7;
  dias = numdias % 7;

  printf ("%d semanas e %d dias !!!", semanas, dias);
}