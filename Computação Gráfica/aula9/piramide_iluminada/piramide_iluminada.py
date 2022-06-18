from OpenGL.GLUT import *
from OpenGL.GLU import *
from OpenGL.GL import *
from math import sqrt, sin, cos, pi
import sys

quadro = 0

def calculaNormalFace(face):
    x = 0
    y = 1
    z = 2
    v0 = face[0]
    v1 = face[1]
    v2 = face[2]
    U = (v2[x]-v0[x], v2[y]-v0[y], v2[z]-v0[z])
    V = (v1[x]-v0[x], v1[y]-v0[y], v1[z]-v0[z])
    N = ((U[y]*V[z]-U[z]*V[y]),(U[z]*V[x]-U[x]*V[z]),(U[x]*V[y]-U[y]*V[x]))
    NLength = sqrt(N[x]*N[x]+N[y]*N[y]+N[z]*N[z])
    return (N[x]/NLength, N[y]/NLength, N[z]/NLength)
    
# Desenha bases
def desenha_base(r, qtd_v_base, eixo_z):
    v_base = [] # Array que guarda os vértices

    glBegin(GL_TRIANGLE_FAN) # Desenha um poligono a partir de triangulos
    for v in range(0, qtd_v_base): # Itera nos vértices da base
        alpha = 2 * pi * (v/qtd_v_base)

        x = r * cos(alpha)
        y = r * sin(alpha)
        v_base.append((x, y)) # Armazena o ponto do plano na lista
        glVertex3f(x, y, eixo_z) # Liga os vértices, formando uma base poligonal
    
    # Calcula as coordenadas das sombras
    s = (v_base[0][0], v_base[0][1], eixo_z)
    t = (v_base[1][0], v_base[1][1], eixo_z)
    u = (v_base[2][0], v_base[2][1], eixo_z)
    glNormal3fv(calculaNormalFace( (s,t,u) )) # Gera a sombra

    glEnd()

# Liga as paredes nas bases
def desenha_paredes(r, qtd_v_base, h_base, h_topo):

    glBegin(GL_TRIANGLES) # Liga os vértices das bases com retângulos
    for i in range(0, qtd_v_base): # Itera nos vértices
        alpha_atual = 2 * pi * (i/qtd_v_base)
        x_atual = r * cos(alpha_atual); y_atual = r * sin(alpha_atual)

        alpha_prox = 2 * pi * ((i+1)/qtd_v_base)
        x_proximo = r * cos(alpha_prox); y_proximo = r * sin(alpha_prox)
        
        # Calcula as coordenadas das sombras
        s = (0., 0., h_base)
        t = (x_atual, y_atual, h_topo)
        u = (x_proximo, y_proximo, h_topo)
        
        glNormal3fv(calculaNormalFace( (s,t,u) )) # Gera a sombra

        # Liga os pontos
        glVertex3f(0., 0., h_base)
        glVertex3f(x_atual, y_atual, h_topo)
        glVertex3f(x_proximo, y_proximo, h_topo)
    glEnd()

# Função responsável por desenhar a pirâmide
def piramide(raio, qtd_v_base, h_base, h_topo):

    # Base da pirâmide
    desenha_base(raio, qtd_v_base, h_topo) 
  
    # Paredes da pirâmide
    desenha_paredes(raio, qtd_v_base, h_base, h_topo)

# Função responsável pelas figuras desenhadas na tela
def desenho():
    global quadro
    r = 2
    qtd_vertice_base = 4
    h_base = 0.
    h_topo = 2.5

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glPushMatrix()
    glRotatef(90.0+quadro, 0.1, 0.0, 0.1) 

    # Desenha o prisma
    piramide(r, qtd_vertice_base, h_base, h_topo)

    quadro += 1 # Soma um quadro ao terminar de rodar a função
    glutSwapBuffers()
    glPopMatrix()

def timer(i):
    glutPostRedisplay()
    glutTimerFunc(15,timer,1)

def reshape(w,h):
    glViewport(0,0,w,h)
    glMatrixMode(GL_PROJECTION)
    gluPerspective(45,float(w)/float(h),0.1,50.0)
    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()

    gluLookAt(10,0,0,0,0,0,0,1,0)

def init():
    mat_ambient = (0.4, 0.0, 0.0, 1.0)
    mat_diffuse = (1.0, 0.0, 0.0, 1.0)
    mat_specular = (1.0, 0.5, 0.5, 1.0)
    mat_shininess = (50,)
    light_position = (10, 0, 0)
    glClearColor(0.0,0.0,0.0,0.0)
    glShadeModel(GL_SMOOTH)

    glMaterialfv(GL_FRONT, GL_AMBIENT, mat_ambient)
    glMaterialfv(GL_FRONT, GL_DIFFUSE, mat_diffuse)
    glMaterialfv(GL_FRONT, GL_SPECULAR, mat_specular)
    glMaterialfv(GL_FRONT, GL_SHININESS, mat_shininess)
    glEnable(GL_LIGHTING)
    glEnable(GL_LIGHT0)
    glLightfv(GL_LIGHT0, GL_POSITION, light_position)
    glEnable(GL_DEPTH_TEST)
    glEnable(GL_MULTISAMPLE)

# Programa Base
def main():
    glutInit(sys.argv)
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA | GLUT_DEPTH | GLUT_MULTISAMPLE)
    glutInitWindowSize(800,600)
    glutCreateWindow("Pirâmide iluminada")
    glutReshapeFunc(reshape)
    glutDisplayFunc(desenho)
    glEnable(GL_MULTISAMPLE)
    glEnable(GL_DEPTH_TEST)
    gluPerspective(45,800.0/600.0,0.1,100.0)
    glTranslatef(0.0,0.0,20)
    glutTimerFunc(50,timer,1)
    init()
    glutMainLoop()

main()