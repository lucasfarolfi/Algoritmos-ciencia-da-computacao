#include <stdio.h>

int tabuada (int n);

int main() {
  int n;
  printf ("Digite um numero: ");
  scanf ("%d", &n);

  tabuada (n);

  for (int n = 1; n <= 10; n++)
  tabuada (n);
  return 0;
}
int tabuada (int n){
  int tabuada;
  for (int i = 1; i <= 10; i++){
    tabuada = n * i;
    printf ("\n%d x %d = %d\n", n, i, tabuada);
  }
  return tabuada;
}