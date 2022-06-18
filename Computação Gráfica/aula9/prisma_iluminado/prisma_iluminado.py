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
def desenha_base(r, qtd_v_base, t, eixo_z):
    v_base = [] # Array que guarda os vértices

    glBegin(GL_TRIANGLE_FAN) # Desenha um poligono a partir de triangulos
    for v in range(0, qtd_v_base): # Itera nos vértices da base
        x = r * cos(v * t)
        y = r * sin(v * t)
        v_base.append((x, y)) # Armazena o ponto do plano na lista
        glVertex3f(x, y, eixo_z) # Liga os vértices, formando uma base poligonal
    
    # Calcula as coordenadas das sombras
    s = (v_base[0][0], v_base[0][1], eixo_z)
    t = (v_base[1][0], v_base[1][1], eixo_z)
    u = (v_base[2][0], v_base[2][1], eixo_z)

    glNormal3fv(calculaNormalFace( (s,t,u) )) # Gera a sombra

    glEnd()

    return v_base

# Liga as paredes nas bases
def desenha_paredes(v_a, v_b, qtd_v_base, altura_b1, altura_b2):

    glBegin(GL_QUAD_STRIP) # Liga os vértices das bases com retângulos
    for i in range(0, qtd_v_base): # Itera nos vértices
        xa_atual = v_a[i][0]; ya_atual = v_a[i][1]
        xb_atual = v_b[i][0]; yb_atual = v_b[i][1]

        xa_proximo = v_a[(i+1)%qtd_v_base][0]; ya_proximo = v_a[(i+1)%qtd_v_base][1]
        xb_proximo = v_b[(i+1)%qtd_v_base][0]; yb_proximo = v_b[(i+1)%qtd_v_base][1]
        
        # Calcula as coordenadas das sombras
        s = (xa_atual, ya_atual, altura_b1)
        t = (xb_atual, yb_atual, altura_b2)
        u = (xb_proximo, yb_proximo, altura_b1)
        
        glNormal3fv(calculaNormalFace( (s,t,u) )) # Gera a sombra

        # Liga os pontos
        glVertex3f(xa_atual, ya_atual, altura_b1)
        glVertex3f(xa_proximo, ya_proximo, altura_b1)
        glVertex3f(xb_atual, yb_atual, altura_b2)
        glVertex3f(xb_proximo, yb_proximo, altura_b2)
    glEnd()

def prisma(raio, qtd_v_base):
    # Divide uma volta no círculo pelos pontos do vértice da base
    t = (2*pi) / qtd_v_base

    # Lista contendo os vértices da base e teto
    altura_b1 = 0.0
    altura_b2 = 2.0

    # Desenha a base e o teto do prisma
    vertices_a = desenha_base(raio, qtd_v_base, t, altura_b1) # Base do prisma
    vertices_b = desenha_base(raio, qtd_v_base, t, altura_b2) # Teto do prisma

    # Desenha as paredes do prisma ligada pela base
    desenha_paredes(vertices_a, vertices_b, qtd_v_base, altura_b1, altura_b2)

# Função responsável pelas figuras desenhadas na tela
def desenho():
    global quadro
    r = 1
    qtd_vertice_base = 5

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glPushMatrix()
    glRotatef(50.0+quadro, 1.0, 1.0, 1.0) 

    # Desenha o prisma
    prisma(r, qtd_vertice_base)

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
    glutCreateWindow("Prisma iluminado")
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