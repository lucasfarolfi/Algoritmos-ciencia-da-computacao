#include <iostream>
using namespace std;

int main() {

  //Tamanho de cada array (conjunto) e opção do menu
  int tam_A = 4, tam_B = 5, indice_intersec = 0, indice_diferenca = 0, opcao; 

  //Conjunto A, B, intersecção e diferença
  int A[] = {5,2,8,4}, B[] = {9,4,5,6,7}, intersec[tam_A + tam_B], diferenca[tam_A + tam_B];

  //Serve como ponto de parada do programa nos laços de repetição
  bool elementoIgual = true;

  //Menu
  cout << "\nDigite qual operação deseja.\n1. A - B\n2. B - A\n\nOpção: ";
  cin >> opcao;

  //Compara o conjunto A com o conjunto B para achar a intersecção
  for(int i = 0; i < tam_A; i++){   
    for(int j = 0; j < tam_B; j++){
      
      //Se algum elemento de A é igual ao de B, este elemento será passado de A para a intersecção
      if(A[i] == B[j]){ 
        intersec[indice_intersec] = A[i];
        indice_intersec++; 
      }
    }
  }

  //Escolha das opções
  switch(opcao){

    // A - B
    case 1:

      //Compara o conjunto A com a intersecção
      for(int i = 0; i < tam_A; i++){ 
        for(int j = 0; j < indice_intersec; j++){ 

          //Se for igual, o elementoIgual irá para falso
          if(A[i] == intersec[j]){
            elementoIgual = false;   
          }
        }

        //Se o elemento do conjunto A não estiver na intersecção, então o vetor diferença receberá o valor do conjunto A
        if(elementoIgual == true){
          diferenca[indice_diferenca] = A[i];
          indice_diferenca++;   
        }

        //Reseta o elementoIgual
        elementoIgual = true;
      }
      break;

    // B - A
    case 2: 

      //Compara o conjunto B com a intersecção
      for(int i = 0; i < tam_B; i++){ 
        for(int j = 0; j < indice_intersec; j++){ 
          
          //Se for igual, o elementoIgual irá para falso
          if(B[i] == intersec[j]) {
            elementoIgual = false;
          }
        }

        //Se o elemento do conjunto B não estiver na intersecção, então o vetor diferença receberá o valor do conjunto B
        if(elementoIgual == true){
          diferenca[indice_diferenca] = B[i];
          indice_diferenca++; 
        }

        //Reseta o elementoIgual
        elementoIgual = true;    
      }
      break;
    
    default:
      break;
  }
  
  //Saída: A – B ou B - A
  for(int i = 0; i < indice_diferenca; i++){
    
    if(i == 0){

      if(opcao == 1)  cout << "\nA - B = { " << diferenca[i] << ", ";
      else if(opcao == 2) cout << "\nB - A = { " << diferenca[i] << ", ";
    }
    else if(i == indice_diferenca - 1){
      cout << diferenca[i] << " }";
    }
    else{
      cout << diferenca[i] << ", ";
    }
  }

}//fim main