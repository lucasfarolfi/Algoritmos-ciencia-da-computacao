#include <stdio.h>
// NAO PODE USAR ESPAÇO NO MACRO (entre o nome e o parenteses do parametro)
#define MAIOR(x, y) x > y ? x : y
#define minusculo(char) char >= 'a' && char <= 'z'

int main() {
  int x, y;
  char a = 'b';

  printf ("%d\n", MAIOR (10, 20));
  
  if (minusculo(a)){
    printf ("Eh minusculo");
  }else {
    printf ("Nao eh minusculo");
  }
  return 0;
}