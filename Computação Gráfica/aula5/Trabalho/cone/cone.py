from OpenGL.GLUT import *
from OpenGL.GLU import *
from OpenGL.GL import *
from math import pi, sin, cos

cores = ( (1,0,0),(1,1,0),(0,1,0),(0,1,1),(0,0,1),(1,0,1),(0.5,1,1),(1,0,0.5) )
quadro = 0

# Desenha a parte superior do cone
def cone(raio, n):
    glBegin(GL_TRIANGLES) # Cria triângulos quando tiver 3 pontos

    # Itera no numero de triângulos da base 
    # e forma um cone com vários triângulos
    for i in range(0,n): 
	    glColor3fv(cores[(i)%len(cores)])

        # Desenha os 3 vértices para formar um pequeno triângulo
	    glVertex3f(0.0,0.0,-1.0)
	    a = (i/n) * 2 * pi
	    x = raio * cos(a)
	    y = raio * sin(a)
	    glVertex3f(x,y,0.0)
	    a = ((i+1)/n) * 2 * pi
	    x = raio * cos(a)
	    y = raio * sin(a)
	    glVertex3f(x,y,0.0)
    glEnd()

# Base do cone
def base_cone(raio, n):
    # Cria um polígono com vários triangulos interligados
    glBegin(GL_TRIANGLE_FAN) 
    glColor3f(0.3,0.3,0.3)
    glVertex3f(0.0,0.0,0.0)

    # Cria um ponto a mais no centro para ligar os triangulos 
    # para formar um polígono
    for i in range(0,n+1):
	    a = (i/n) * 2 * pi
	    x = raio * cos(a)
	    y = raio * sin(a)
	    glVertex3f(x,y,0.0)
    glEnd()

def desenha_cone():
    global quadro
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    
    glPushMatrix() # Cria uma matriz de translação temporária
    glRotatef(90.0+quadro,-1.0,0.0,0.0) # Animação de rotação da figura
    raio = 1.0
    n = 60 # Lados do polígono da base

    # Desenha o cone
    cone(raio, n)
    base_cone(raio, n)

    glutSwapBuffers() # Troca de frame quando a figura ja estiver desenhada
    quadro += 1 # A cada chamada da função aumenta 1 quadro(frame)
    glPopMatrix()

def timer(i):
    glutPostRedisplay()
    glutTimerFunc(10,timer,1)

# PROGRAMA PRINCIPAL
glutInit(sys.argv)
glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA | GLUT_DEPTH | GLUT_MULTISAMPLE)
glutInitWindowSize(800,800)
glutCreateWindow("Cone")
glutDisplayFunc(desenha_cone)
glEnable(GL_MULTISAMPLE)
glEnable(GL_DEPTH_TEST)
glClearColor(0.,0.,0.,1.)
gluPerspective(45.0, 800.0/600.0, 0.1, 100.0)
glTranslatef(0.0,0.0,-5.0)
glutTimerFunc(10,timer,1)
glutMainLoop()