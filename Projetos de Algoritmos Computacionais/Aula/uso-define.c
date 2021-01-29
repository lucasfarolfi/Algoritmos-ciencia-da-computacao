#include <stdio.h>
#define alunos 1000 // define a quantidade de alunos em 1000 para qualquer função do programa

void TurmasEscola1 (int t1){
  printf ("Na primeira escola serao %d turmas de %d alunos. ", t1, alunos/t1);
}
void TurmasEscola2 (int t2){
  printf ("Na segunda escola serao %d turmas de %d alunos.", t2, alunos/t2);
}

int main() {
  int qtd_turmas1 = 20, qtd_turmas2 = 25;

  printf ("Duas escolas fornecerao 1000 vagas de alunos. ");
  TurmasEscola1 (qtd_turmas1);
  TurmasEscola2 (qtd_turmas2);

  return 0;
}