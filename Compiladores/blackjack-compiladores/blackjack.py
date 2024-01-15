import ply.lex as lex
import ply.yacc as yacc
import random as random

# --- TOKENS --- #
tokens = [
    'INT', 'ID', 'PLUS', 'MINUS', 'DIVIDE', 'MULTIPLY', 'EQUALS'
]

# --- OPERAÇÕES --- # 
t_PLUS = r'\+'
t_MINUS = r'\-'
t_MULTIPLY = r'\*'
t_DIVIDE = r'\/'
t_EQUALS = r'\='

# --- CARACTERES IGNORADOS --- #
t_ignore = r''

# --- EXPRESSÕES REGULARES DOS TOKENS --- #
def t_INT(t):
    r'\d+'
    t.value = int(t.value)
    return t

def t_ID(t): # Variáveis
    r'[a-zA-Z][a-zA-Z_0-9]*'
    t.type = 'ID'
    return t

def t_error(t):
    print("Illegal characters!")
    t.lexer.skip(1)

# Recebe o analisador lexico responsável por ler os tokens
lexer = lex.lex() 

# Determina a ordem das operações aritméticas e remove os warnings de shift/reduce conflicts do terminal
precedence = (
    ('left', 'PLUS', 'MINUS'),
    ('left', 'MULTIPLY', 'DIVIDE')
)

# --- Funções de REGRAS GRAMATICAIS --- #
# Obs: Se a sintaxe passada pelo analisador não se identificar com as regras abaixo, a função p_error é acionada
def p_print(p):
    '''
    print : E
          | empty
    '''
    print(run(p[1])) # Função que roda o cálculo

def p_E(p):
    '''
    E : R EQUALS S
    '''
    
    # print('---------------')
    # print(f'E: {p[3]}')
    # print('---------------')
    p[0] = ('=', p[1], p[3])

def p_R(p):
    '''
    R : ID
    '''
    p[0] = p[1]

def p_S(p):
    '''
    S : L MINUS F
    '''
    # p2 = Operador
    # p1 = Primeira expressao
    # p3 = Segunda expressão

    # print('---------------')
    # print(f'S: {p[2]}, {p[1]}, {p[3]}')
    # print('---------------')
    p[0] = (p[2], p[1], p[3])

# --------
def p_F(p):
    '''
    F : F PLUS L
    '''
    p[0] = (p[2], p[1], p[3])

def p_F_L(p):
    '''
    F : L
    '''
    p[0] = p[1]

def p_L(p):
    '''
    L : INT
    '''
    p[0] = p[1]

# Quando caracteres inválidos são digitados
def p_error(p):
    print('Syntax error found!')

def p_empty(p):
    '''
    empty :
    '''
    p[0] = None

# Útil para enviar as frases para executar no analisador
parser = yacc.yacc()

env = {} # Guarda as variáveis

# Função que roda as operações feitas no analisador
def run(p):
    global env

    # Se for uma tupla, então é uma expressão
    if type(p) == tuple: 

        #print(f'RUN: {p}')
        if p[0] == '+':
            return run(p[1]) + run(p[2])
        elif p[0] == '-':
            return run(p[1]) - run(p[2])
        elif p[0] == '=':
            env[p[1]] = run(p[2]) # env['nome_variavel'] = numero
            #print(env)
    else: # Se não for uma tupla de uma expressão, retorne apenas o valor existente
        return p


def main():
    buying_cards = True # Indica se o jogador quer comprar mais cartas ou não
    dealer_cards = []
    player_cards = []
    total_points = 21

    change_total_points = input('Deseja mudar o total de 21 pontos de cartas? (s/n): ')

    if change_total_points == 's': # Se quer alterar o valor 21 do total de pontos
        total_points_value = input('Digite um novo valor de pontos totais: ')

        if total_points_value.isdigit():
            total_points = int(total_points_value)
            print(f'Regra definida para {total_points} pontos totais')
        else:
            print('Erro: Opção inválida. Portanto a regra continuará sendo 21 pontos totais')

    elif change_total_points == 'n':  # Se não quer alterar o valor 21 do total de pontos
        print('Regra permanecida como 21 pontos totais')
    else:  # Em caso de caracteres diferentes de s/n
        print('Erro: Opção inválida. Portanto a regra continuará sendo 21 pontos totais')

    # Compra cartas para o Dealer até sua pontuação estiver perto do total
    while sum(dealer_cards) < total_points - 4:
        dealer_cards.append(random.randint(2, 11))

    print("Cartas do Dealer: ", dealer_cards)       

    # Monta a sentença do cálculo da diferença entre o total e os pontos do Dealer
    d_expression = f'dealer={total_points}-'
    for i in range(len(dealer_cards)):
        if i == 0:
            d_expression += f'{dealer_cards[i]}'
        else:
            d_expression += f'+{dealer_cards[i]}'

    # Envia a sentença para o analisador
    parser.parse(d_expression)

    # Sorteia uma primeira carta para o Player antes do jogo começar
    player_cards.append(random.randint(2, 11))

    while buying_cards:
        print("\nSuas cartas: ", player_cards) 
        option = input('Deseja comprar mais cartas? (s/n): ')

        if option == 's':
            player_cards.append(random.randint(2, 11))
        elif option == 'n':
            buying_cards = False
            
            # Monta a sentença do cálculo da diferença entre o total e os pontos do Player
            p_expression = f'player={total_points}-'
            for i in range(len(player_cards)):
                if i == 0:
                    p_expression += f'{player_cards[i]}'
                    #print(f'p_expression: {p_expression}')
                else:
                    p_expression += f'+{player_cards[i]}'
                    #print(f'p_expression: {p_expression}')

            parser.parse(p_expression) # Envia a sentença para o analisador

            #print(f'ENV: {env}')
            print('\n------------------------------------------')
            print('Resultado:\n')

            # Verifica o possível resultado do jogo e exibe ao jogador
            if env['dealer'] < 0 and env['player'] < 0:
                print(f'A pontuação de ambos foi maior que {total_points}. Ocorreu um empate!!!')
            elif env['dealer'] < 0 and env['player'] >= 0:
                print(f'A pontuação do Dealer foi maior que {total_points}. Você ganhou!!!')
            elif env['dealer'] >= 0 and env['player'] < 0:
                print(f'A sua pontuação foi maior que {total_points}. Você perdeu!!!')
            
            elif env['dealer'] < env['player']:
                print('A pontuação do dealer foi maior. Você perdeu!!!')
            elif env['dealer'] > env['player']:
                print('Sua pontuação foi maior que a do Dealer. Você ganhou!!!')
            elif env['dealer'] == env['player']:
                print('A pontuação de ambos é igual. Ocorreu um empate!!!')

            print('------------------------------------------')
            print('Total de cartas:\n')
            print(f'Pontuação do Dealer: {sum(dealer_cards)}')
            print(f'Sua pontuação: {sum(player_cards)}')
            print('------------------------------------------')
        else:
            print('Erro: Digite uma opção válida')

main()