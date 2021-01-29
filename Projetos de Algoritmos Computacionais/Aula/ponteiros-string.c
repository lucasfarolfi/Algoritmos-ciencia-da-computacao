#include <stdio.h>

void CopiaColaString (char *ctrlc, char *ctrlv){
  while (*ctrlc != '\0'){
    *ctrlv = *ctrlc;
    ++ctrlc;
    ++ctrlv; 
  }
  *ctrlv = '\0';
}

int main() {
  char string1 [] = "Ola mundo !!!";
  char string2 [16];

  CopiaColaString (string1, string2);

  printf ("%s", string2);
  return 0;
}