#include <stdio.h>

void Variavelponteiro (int *pX){
  (*pX)++;
}

int main() {
  int x = 1;
  int *px = &x;

  Variavelponteiro (px);

  printf ("%d", *px);
  return 0;
}