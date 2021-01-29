#include <stdio.h>

int main() {
  
  for (int i = 1; i < 20; i++){
    if (i % 2 == 0 && i % 4 == 0){
      printf ("%d eh divisivel por 2 e 4 !\n", i);
      break;
    } else printf ("%d nao eh !\n", i);
  }
  return 0;
}