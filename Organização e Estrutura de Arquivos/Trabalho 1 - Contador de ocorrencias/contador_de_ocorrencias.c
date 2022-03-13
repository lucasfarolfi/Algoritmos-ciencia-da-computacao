#include <stdio.h>

//Comandos de execução no MingW GNU:
/*
    gcc -o contador_de_ocorrencias contador_de_ocorrencias.c
    ./contador_de_ocorrencias teste.txt
*/

int main(int argc, char** argv){
    FILE *input; //Entrada e saída de arquivo
    int c, countUpper = 0, countLower = 0, countNumbers = 0, countSpace = 0 ,countEndl = 0;

    if(argc != 2){  // Se for diferente de "argc = ./contador_de_ocorrencias [arquivo de leitura]"
        fprintf(stderr, "Erro no comando.\n");
        fprintf(stderr, "Correto: %s [Arquivo de leitura].\n", argv[0]); //argv[0] = ./contador_de_ocorrencias
        return 1; //Fecha o programa com erro
    }

    input = fopen(argv[1], "r"); //Abre o arquivo de input
    if(!input){ //Se o arquivo não existir ou o nome estiver errado
        fprintf(stderr, "O arquivo %s não pode ser aberto.\n", argv[1]); 
        return 1;
    }

    c = fgetc(input); // Lê o arquivo de input
    while(c != EOF){ // Percorre todos os caracteres do arquivo até o fim
        if(c >= 'A' && c <= 'Z') countUpper++;

        if(c >= 'a' && c <= 'z') countLower++;
        
        if(c >= '0' && c <= '9') countNumbers++;
        
        if(c == ' ') countSpace++;
        
        if(c == '\n') countEndl++;
        
        c = fgetc(input);
    }
    
    fclose(input);
    printf("Letras maiusculas: %d\nLetras minusculas: %d\nNumeros: %d\nEspacos: %d\nQuebra de linha: %d", countUpper, countLower, countNumbers, countSpace, countEndl);
    
    return 0;
}