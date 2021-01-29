#include <stdio.h>
struct lista{
  int valor;
  struct lista *proximo;//variavel ponteiro da struct lista
};

struct lista *RetornaLista (struct lista *gancho, int valor){//função ponteiro
  while (gancho != 0){
    if (gancho->valor == valor){//se o valor do gancho for igual ao valor digitado pelo usuario, é retornado gancho
      return (gancho);
    }
    else{
      gancho = gancho->proximo;//Senão, pula pro proximo gancho
    }
  }
  return 0;// Caso não achar o valor do usuário, é retornado nulo
} 


int main() {
  struct lista m1, m2, m3;
  struct lista *resultado, *gancho = &m1;
  int valor;

  m1.valor = 1;
  m2.valor = 2;
  m3.valor = 3;

  m1.proximo = &m2;
  m2.proximo = &m3;
  m3.proximo = 0;

  printf ("Digite o valor da pesquisa: ");
  scanf ("%d", &valor);

  resultado = RetornaLista (gancho, valor); //passa o ponteiro gancho e o valor para a função. Recebe o resultado na variavel *resultado

  if (resultado == 0){
    printf ("Valor nao encontrado");
  }
  else {
    printf ("Pesquisa %d encontrada", resultado->valor);//pega o valor do resultado
  }
  return 0;
}