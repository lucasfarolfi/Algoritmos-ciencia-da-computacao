#include <stdio.h>

int main() {
  struct horario{
    int horas;
    int minutos;
    int segundos;
  };
  struct horario agora, *depois;
  depois=&agora;

  depois->horas = 03;
  depois->minutos = 20;
  depois->segundos = 50;

  printf ("%d:%d:%d", agora.horas, agora.minutos, agora.segundos);
  return 0;
}