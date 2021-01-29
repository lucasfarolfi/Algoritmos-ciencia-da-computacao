#include <stdio.h>

int main() {
  //Pré Incrementação:
  int x = 1, y = 0;

  y = ++x; // soma em x e depois iguala
  printf ("x = %d \\ y = %d\n", x, y); 

  //Pós Incrementação
  int a = 1, b = 0;

  b = a++; // iguala A e B, depois soma em A
  printf ("a = %d \\ b = %d", a, b);
  return 0;
}