#include <stdio.h>

int qtd_func (int qtdfuncionarios);

int main() {
  int qtdfuncionarios;
  float salariototal;

  printf ("Digite a quantidade de funcionarios: ");
  scanf ("%d", &qtdfuncionarios);

  salariototal = qtd_func (qtdfuncionarios);

  printf ("A soma de todos os salarios equivale a R$ %.2f !!!", salariototal);

  return 0;
}
int qtd_func (int qtdfuncionarios){
  int qtdfuncionarias = 0, salariototal = 0;

  for (int i = 1; i <= qtdfuncionarios;i++){
    int sexo = 0, salario = 0;

    printf ("\nDigite o sexo do funcionario %d(1-Masc/2-Fem): ", i);
    scanf ("%d", &sexo);
    if (sexo == 1){
      qtdfuncionarias += 1;
    }
    printf ("\nDigite o salario do funcionario %d: \n", i);
    scanf ("%d", &salario);
    salariototal += salario;
  }
  return salariototal; 
}
