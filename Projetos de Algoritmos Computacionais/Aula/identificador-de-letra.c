#include <stdio.h>

void Alfabetico (char palavra){
  if (palavra >= 'a' && palavra <= 'z' || palavra >= 'A' && palavra <= 'Z'){
    printf ("\n%c eh letra!!!", palavra);
  } else printf ("\n%c nao eh letra!!!", palavra);

}

int main() {
  char palavra[20];
  int i=0;

  printf ("Digite uma palavra: ");
  scanf ("%s", &palavra);

  while (palavra[i] != '\0'){
    Alfabetico (palavra[i]);
    i++;
  }
  return 0;
}