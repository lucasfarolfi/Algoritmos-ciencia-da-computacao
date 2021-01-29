#include <stdio.h>

int main(void) {
  // O \a executa e da um beep
  // O \0 é um caractere nulo que termina a string
  // O \n pula linha
  // O \b volta o cursor pra uma linha atrás
  // O \r volta o cursor para a primeira linha
  // O \t da um tab no caractere que vem após
  // O \" serve para aparecer aspas dentro do printf
  
  printf("\"Hello World\"\a");
  return 0;
}