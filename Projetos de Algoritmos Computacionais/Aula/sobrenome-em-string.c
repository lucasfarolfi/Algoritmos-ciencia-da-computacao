#include <stdio.h>

int main() {
  char linhas[100]; // array que fica a frase
  char nome; // array que pega a frase do getchar
  int i=0; // contador

  do{
    nome = getchar ();
    linhas[i] = nome;
    i++;//O "i" serve para pular linha no array linha
  } while (nome != '\n'); //\n é a função do enter

  linhas[i-1] = '\0'; // Substitui o ultimo espaço do i, que seria o '\n' pelo '\0'

  printf ("Ola %s, eh um prazer ve-lo !!!\n", linhas);

  return 0;
}