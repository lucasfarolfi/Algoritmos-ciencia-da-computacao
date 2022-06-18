from OpenGL.GLUT import *
from OpenGL.GLU import *
from OpenGL.GL import *

# Pontos do cubo no plano cartesiano
vertices = (
    ( 1,-1,-1),
    ( 1, 1,-1),
    (-1, 1,-1),
    (-1,-1,-1),
    ( 1,-1, 1),
    ( 1, 1, 1),
    (-1,-1, 1),
    (-1, 1, 1),
)

linhas = (
    (0,1),
    (0,3),
    (0,4),
    (2,1),
    (2,3),
    (2,7),
    (6,3),
    (6,4),
    (6,7),
    (5,1),
    (5,4),
    (5,7),
)

faces = (
    (0,1,2,3),
    (3,2,7,6),
    (6,7,5,4),
    (4,5,1,0),
    (1,5,7,2),
    (4,0,3,6)
)

cores = ( (1,0,0),(1,1,0),(0,1,0),(0,1,1),(0,0,1),(1,0,1),(0.5,1,1),(1,0,0.5) )

def Cubo():
    glBegin(GL_QUADS) # Liga os pontos na forma de quadrilátero 
    i = 0
    for face in faces: # Itera na face do cubo
        glColor3fv(cores[i]) # Pinta a face atual
        for vertex in face: # Itera pelos pontos da face
           # glColor3fv(cores[vertex])

           # Desenha um ponto de uma coordenada do array vértice que a posição
           # seja o vértice atual da iteração da face
           glVertex3fv(vertices[vertex]) 
        i = i+1
    glEnd()

    glColor3f(0,0.5,0) # Background
    glBegin(GL_LINES) # Desenha as linhas ligando os vértices do cubo
    for linha in linhas: # Itera no array de linhas
        for vertice in linha: # Pega um vértice por linha
            glVertex3fv(vertices[vertice]) # Liga os 4 pontos na tupla atual de vértices
    glEnd()

a = 0

def desenhaDoisCubos():
    # Cubo da Esquerda
    glPushMatrix() # Faz uma cópia desta posição atual
    glTranslatef(-2,0,0) # Muda a posição do cubo na tela
    glRotatef(-a,0,0,1) # Gira o cubo no eixo x
    Cubo() # Desenha o cubo
    glPopMatrix() # Apaga ela para que volte para a origem anterior
    # Cubo da Direita
    glPushMatrix()
    glTranslatef(2,0,0)
    glRotatef(a,0,1,0)
    Cubo()
    glPopMatrix()


def desenha():
    global a
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT) # Apaga a tela
    glPushMatrix()
    glTranslatef(0,-2,0)
    desenhaDoisCubos() # Desenha 2 cubos em baixo
    glPopMatrix()
    glPushMatrix()
    glTranslatef(0,2,0) # Desenha 2 cubos em cima
    desenhaDoisCubos()
    glPopMatrix()
    glutSwapBuffers() # Troca os frames apenas quando o próximo frame for desenhado
    a += 1
 
def timer(i):
    glutPostRedisplay()
    glutTimerFunc(50,timer,1)

def mouse(botao, estado, x, y):
    print(botao, estado, x, y)

def mouseMove(x, y):
    print("-->", x, y)


# PROGRAMA PRINCIPAL
glutInit(sys.argv)
glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA | GLUT_DEPTH | GLUT_MULTISAMPLE)
glutInitWindowSize(800,600)
glutCreateWindow("CUBO")
glutDisplayFunc(desenha) # Desenha o que está na função
#glutMotionFunc(mouseMove)
glutPassiveMotionFunc(mouseMove)
glutMouseFunc(mouse)
glEnable(GL_MULTISAMPLE)
glEnable(GL_DEPTH_TEST)
glClearColor(0.,0.,0.,1.)
gluPerspective(45,800.0/600.0,0.1,100.0) # Proporção da janela da tela
glTranslatef(0.0,0.0,-20) # Origem do desenho
glutTimerFunc(50,timer,1) # Manipula os frames por segundo
glutMainLoop()