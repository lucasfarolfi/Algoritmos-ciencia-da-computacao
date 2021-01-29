#include <stdio.h>

int fibonacci (int n){//função que calcula a soma de um número com o anterior recursivamente
  if (n < 2){
    return 1;
  }
  else{
    return fibonacci (n-1) + fibonacci (n-2);
  }
}

int main(void) {
  int num;

  scanf ("%d", &num);
 
  for (int i=0; i < num;i++){
    printf ("%d ", fibonacci(i));
  }
  return 0;
}