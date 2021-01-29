#include <stdio.h>

int main() {
  struct horario{
    int *phora;
    int *pmin;
    int *pseg;
  };

  struct horario agora;
  int hora = 02;
  int min = 30;
  int seg = 00;

  agora.phora = &hora;
  agora.pmin = &min;
  agora.pseg = &seg;

  printf ("Hora %d:%d:%d", *agora.phora, *agora.pmin, *agora.pseg);

  return 0;
}