#include <stdio.h>

int salario_func (int qtdfuncionarios);

int main() {

  float salarioempresa;

  for (int i=1; i <= 10; i++){
    int qtdfuncionarios = 0;
    float salariototal = 0;

    printf ("\nDigite a quantidade de funcionarios no departamento %d: ", i);
    scanf ("%d", &qtdfuncionarios);

    salariototal = salario_func (qtdfuncionarios);
    printf ("\nA soma dos salarios no departamento %d equivale a R$ %.2f !!!\n ", i, salariototal);  

    salarioempresa +=salariototal;
  }
  printf ("\nLogo a soma de todos os salarios da empresa eh de R$ %f", salarioempresa);

  return 0;
}
int salario_func (int qtdfuncionarios){
  float maiorsalario = 0, salariototal = 0;

  for (int i = 1; i <= qtdfuncionarios;i++){
    int matricula;
    float salario = 0, salariomaior = 0;

    printf ("\nDigite a matricula do funcionario %d: ", i);
    scanf ("%d", &matricula);

    printf ("\nDigite o salario do funcionario %d: ", i);
    scanf ("%f", &salario);
    salariototal += salario;

    if (salario > maiorsalario){
      maiorsalario = salario;
    }
  }
  printf ("\nO maior dos salarios deste departamento eh de R$ %.2f !!!\n ", maiorsalario);

  return salariototal; 
}
