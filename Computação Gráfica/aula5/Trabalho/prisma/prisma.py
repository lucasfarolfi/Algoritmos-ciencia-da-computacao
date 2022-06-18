from OpenGL.GLUT import *
from OpenGL.GLU import *
from OpenGL.GL import *
from math import pi, sin, cos

cores = ( (1,0,0),(1,1,0),(0,1,0),(0,1,1),(0,0,1),(1,0,1),(0.5,1,1),(1,0,0.5) )
quadro = 0

# Desenha bases
def desenha_base(r, qtd_v_base, t, eixo_z):
    v_base = [] # Array que guarda os vértices

    glBegin(GL_TRIANGLE_FAN) # Desenha um poligono a partir de triangulos
    for v in range(0, qtd_v_base): # Itera nos vértices da base
        glColor3f(0.3,0.3,0.3)
        x = r * cos(v * t)
        y = r * sin(v * t)
        v_base.append((x, y)) # Armazena o ponto do plano na lista
        glVertex3f(x, y, eixo_z) # Liga os vértices, formando uma base poligonal
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

        glColor3fv(cores[(i)%len(cores)])
        
        # Liga os pontos
        glVertex3f(xa_atual, ya_atual, altura_b1)
        glVertex3f(xa_proximo, ya_proximo, altura_b1)
        glVertex3f(xb_atual, yb_atual, altura_b2)
        glVertex3f(xb_proximo, yb_proximo, altura_b2)
    glEnd()

# Função que contém a lógica e os métodos do desenho do prisma
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
    
# Função principal que é renderizada pelo Glut
def desenha_prisma():
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
    glutTimerFunc(10,timer,1)

# PROGRAMA PRINCIPAL
glutInit(sys.argv)
glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA | GLUT_DEPTH | GLUT_MULTISAMPLE)
glutInitWindowSize(800,800)
glutCreateWindow("Prisma")
glutDisplayFunc(desenha_prisma)
glEnable(GL_MULTISAMPLE)
glEnable(GL_DEPTH_TEST)
glClearColor(0., 0., 0., 1.)
gluPerspective(45.0, 800.0/800.0, 0.1, 100.0)
glTranslatef(0.0,0.0,-8)
glutTimerFunc(10,timer,1)
glutMainLoop()