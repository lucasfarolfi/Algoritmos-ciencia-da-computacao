#include <stdio.h>

void ConcatenaString (char string1[], int T1, char string2[], int T2, char stringFinal[]){
  for (int i=0; i < T1; i++){
    stringFinal[i] = string1[i];
  }
  for (int j=0; j <= T2; j++){
    stringFinal[T1+j] = string2[j];
  }
  for (int k=0; k < 9; k++) printf ("%c", stringFinal[k]);
}

int main(void) {
  char palavra1[] = {'o','l','a','_'},
       palavra2[] = {'m','u','n','d','o'}, palavraF[9];

  ConcatenaString (palavra1, 4, palavra2, 5, palavraF);

  return 0;
}