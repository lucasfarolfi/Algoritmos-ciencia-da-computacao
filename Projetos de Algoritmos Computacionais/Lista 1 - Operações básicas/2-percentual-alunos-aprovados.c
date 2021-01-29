#include <stdio.h>
#include <math.h>

float calculopercent (float alunost, float alunosap);

int main() {
  int alunost, alunosap;
  float percentrep;

  printf ("Digite o numero de alunos: ");
  scanf ("%d", &alunost);
  printf ("Digite o numero de alunos aprovados: ");
  scanf ("%d", &alunosap);

  percentrep = calculopercent (alunost, alunosap);
  printf ("A porcentagem de reprovados é de %.f %%", percentrep);

  return 0;
}
float calculopercent (float alunost, float alunosap){
  float percentapr, percentrep;

  percentapr = (100 * alunosap)/(alunost);
  percentrep = 100 - percentapr;
  
  return percentrep;
}
