from OpenGL.GLUT import *
from OpenGL.GLU import *
from OpenGL.GL import *
from math import pi, sin, cos

quadro = 0

# Retorna os pontos com base nos vertices e no raio
def retorna_pontos(i, j, qtd_va, qtd_vb, r):
	t = ((pi * i)/(qtd_va - 1)) - (pi/2) # Theta
	phi = (2 * pi * j)/(qtd_vb - 1) # Phi

    # Pontos
	x = r*cos(t) * cos(phi)
	y = (r*sin(t)) ** 2
	z = r*cos(t) * sin(phi)

	return (x, y, z)

# Função que contém a lógica e os métodos do desenho do parabolóide
def paraboloide(qtd_v_topo, qtd_v_base, raio):

    # Itera na quantidade de pontos do topo
	for i in range(0, qtd_v_topo):

		glBegin(GL_POINTS) # Liga os pontos em retângulos
		for j in range(0, qtd_v_base): # Itera nos vertices da base

			glColor3fv((1.0, 1.0, 1.0))

			p_atual = retorna_pontos(i, j, qtd_v_topo, qtd_v_base, raio)
			glVertex3f(p_atual[0], p_atual[1], p_atual[2])

			p_proximo = retorna_pontos(i+1, j+1, qtd_v_topo, qtd_v_base, raio)
			glVertex3f(p_proximo[0], p_proximo[1], p_proximo[2])

		glEnd()

	
# Função principal renderizada pelo Glut
def desenho():
    global quadro
    qtd_vertices_base = 40
    qtd_vertices_topo = 80
    raio = 1

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glPushMatrix()
    glRotatef(50+quadro, 1.0, 0, 0) 

    # Desenha o paraboloide
    paraboloide(qtd_vertices_topo, qtd_vertices_base, raio)

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
glutCreateWindow("Paraboloide circular")
glutDisplayFunc(desenho)
glEnable(GL_MULTISAMPLE)
glEnable(GL_DEPTH_TEST)
glClearColor(0, 0, 0, 1)
gluPerspective(45.0, 800.0/800.0, 0.1, 100.0)
glTranslatef(0.0,0.0,-4)
glutTimerFunc(10,timer,1)
glutMainLoop()