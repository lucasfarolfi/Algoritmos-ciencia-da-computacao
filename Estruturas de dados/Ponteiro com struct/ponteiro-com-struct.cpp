#include <iostream>

using namespace std;

//Struct do tipo horário, variáveis horas minutos e segundos.
struct horario{
  int horas;
  int minutos;
  int segundos;
};

int main() {

  //Criação da struct agora do tipo horário, e uma struct depois do tipo ponteiro.
  struct horario agora, *depois;

  //Struct depois recebe o endereço da struct agora.
  depois = &agora;

  //manipula os valores da struct agora
  depois->horas = 20;
  depois->minutos = 30;
  depois->segundos = 40;

  cout << agora.horas << ':' << agora.minutos << ':' << agora.segundos;
}