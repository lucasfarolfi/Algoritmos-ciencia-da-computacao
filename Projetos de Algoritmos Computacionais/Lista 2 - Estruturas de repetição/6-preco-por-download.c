#include <stdio.h>

float total_downloads (int qtddownloads);

int main() {
  float precoMB, downtotal = 0, precofinal = 0, downfinal=0;
  int qtddownloads;

  printf ("Quanto custa cada MByte ?: ");
  scanf ("%f", &precoMB);
  
  do{
    printf ("Digite a quantidade de downloads: ");
    scanf ("%d", &qtddownloads);
    downtotal = total_downloads (qtddownloads);
    downfinal += downtotal;
  } while (qtddownloads != 0);
  
  precofinal = downfinal * precoMB;
  printf ("O valor total pago pelos usuarios sera de R$ %.2f", precofinal);

  return 0;
}
float total_downloads (int qtddownloads){
  float tamanhodown = 0, downtotal = 0;
  int down_ate2mb = 0;

  for (int i=0; i < qtddownloads; i++){
    printf ("Digite o tamanho do download: ");
    scanf ("%f", &tamanhodown);
    
    if (tamanhodown <= 2){
      down_ate2mb += 1;
    }
    downtotal += tamanhodown;
  }
  printf ("Total de download(s) menor que 2MB: %d\n", down_ate2mb);
  return downtotal;
}