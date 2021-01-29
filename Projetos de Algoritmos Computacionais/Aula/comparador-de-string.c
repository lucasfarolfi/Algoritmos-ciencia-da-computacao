#include <stdio.h>
#include <stdbool.h>

bool ComparaString (char string1[], char string2[]){
  int i = 0;
  while ((string1[i] == string2[i]) && (string1[i] != '\0') && (string2[i] != '\0')){
    i++;
  }
  if (string1[i] == '\0' && string2[i] == '\0'){
    return 1;
  } else {
    return 0;
  }
}

int main() {
  char palavra1[10], palavra2[10];
  bool comparacao;

  printf ("Digite uma palavra: ");
  scanf ("%s", &palavra1);
  printf ("Digite outra palavra: ");
  scanf ("%s", &palavra2);

  comparacao = ComparaString (palavra1, palavra2);

  if (comparacao == 1){
    printf ("As duas palavras sao iguais !!!");
  } else if (comparacao == 0){
    printf ("As palavras sao diferentes");
  }
  return 0;
}