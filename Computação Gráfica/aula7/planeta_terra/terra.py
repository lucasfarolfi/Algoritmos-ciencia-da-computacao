from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
from math import cos, sin, pi
import sys
import png

# Botão ESCAPE equivale a esta string
ESCAPE = b'\033'

# Number of the glut window.
window = 0

# Rotações da câmera em volta do cubo
xrot = yrot = zrot = 0.0
dx = 0.1
dy = 0
dz = 0

# --- CONFIGURAÇÕES DO OPENGL --- #

# Carrega as imagens como texturas das figuras
def LoadTextures():
    global texture
    texture = [ glGenTextures(1) ]

    glBindTexture(GL_TEXTURE_2D, texture[0])
    reader = png.Reader(filename='mapa.png')
    w, h, pixels, metadata = reader.read_flat()
    if(metadata['alpha']):
        modo = GL_RGBA
    else:
        modo = GL_RGB
    glPixelStorei(GL_UNPACK_ALIGNMENT,1)
    glTexImage2D(GL_TEXTURE_2D, 0, modo, w, h, 0, modo, GL_UNSIGNED_BYTE, pixels.tolist())
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT)
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT)
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST)
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST)
    glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_DECAL)
    

# Inicia o OpenGL carregando as texturas
def InitGL(Width, Height):             
    LoadTextures()
    glEnable(GL_TEXTURE_2D)
    glClearColor(0.0, 0.0, 0.0, 0.0) 
    glClearDepth(1.0)
    glDepthFunc(GL_LESS)               
    glEnable(GL_DEPTH_TEST)            
    glShadeModel(GL_SMOOTH)            
    glMatrixMode(GL_PROJECTION)
    gluPerspective(45.0, float(Width)/float(Height), 0.1, 100.0)
    glMatrixMode(GL_MODELVIEW)

# Muda de tamanho
def ReSizeGLScene(Width, Height):
    if Height == 0:                        
        Height = 1
    glViewport(0, 0, Width, Height)      
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    gluPerspective(45.0, float(Width)/float(Height), 0.1, 100.0)
    glMatrixMode(GL_MODELVIEW)

# --- CÓDIGO DO DESENHO --- #

# Calcula pontos e coordenadas de uma esfera
def retorna_pontos_e_coordenadas(i, j, r, n):
    th = ((pi * i)/(n - 1)) - (pi/2)
    phi = ( pi * 2 * j)/(n - 1)

    x = r*cos(th) * cos(phi)
    y = r*sin(th)
    z = r*cos(th) * sin(phi)
    s = phi /(2 * pi)
    t = (th + (pi/2)) /pi

    return (x, y, z, s, t)

# Desenha no OpenGL a figura
def DrawGLScene():
    global xrot, yrot, zrot, texture
    n = 50 # Quantidade de vértices da esfera

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)    
    glLoadIdentity()                   
    glClearColor(0.,0.,0.,1.0)            
    glTranslatef(0.0,0.0,-8.0)
    glRotatef(xrot,1.0,0.0,0.0)          
    glRotatef(yrot,0.0,1.0,0.0)           
    glRotatef(zrot,0.0,0.0,1.0) 
    
    glBindTexture(GL_TEXTURE_2D, texture[0])
    
    # Itera no vértice da esfera
    for i in range(n):

        # Liga o vertice atual nos outros
        glBegin(GL_QUAD_STRIP)
        for j in range(n):   
            r = 2

            # Calcula x, y e z iniciais
            x, y, z, s, t = retorna_pontos_e_coordenadas(i, j, r, n)

            # Define os vértices e coordenadas do desenho
            glTexCoord2f(s, t)
            glVertex3f(x,y,z)

            # Calcula os próximos x, y e z
            x2, y2, z2, s2, t2 = retorna_pontos_e_coordenadas(i+1, j, r, n)
            
            glTexCoord2f(s2, t2)
            glVertex3f(x2,y2,z2)
        glEnd()
    
    # Velocidade inicial da rotação dos eixos X, Y e Z
    xrot = xrot + 0.1                # X rotation
    yrot = yrot + 0.1                 # Y rotation
    zrot = zrot + 0.1                 # Z rotation

    glutSwapBuffers() # Troca de desenho ao carregar o proximo frame

# Rotaciona o cubo de acordo com a tecla ou fecha a janela ao apertar ESCAPE
def keyPressed(tecla, x, y):
    global dx, dy, dz
    if tecla == ESCAPE:
        glutLeaveMainLoop()
    elif tecla == b'x' or tecla == b'X':
        dx = 1.0
        dy = 0
        dz = 0   
    elif tecla == b'y' or tecla == b'Y':
        dx = 0
        dy = 1.0
        dz = 0   
    elif tecla == b'z' or tecla == b'Z':
        dx = 0
        dy = 0
        dz = 1.0

# Manipula os valores da rotação do cubo e faz um log das teclas pressionadas
def teclaEspecialPressionada(tecla, x, y):
    global xrot, yrot, zrot, dx, dy, dz
    if tecla == GLUT_KEY_LEFT:
        print ("ESQUERDA")
        xrot -= dx                # X rotation
        yrot -= dy                 # Y rotation
        zrot -= dz                     
    elif tecla == GLUT_KEY_RIGHT:
        print ("DIREITA")
        xrot += dx                # X rotation
        yrot += dy                 # Y rotation
        zrot += dz                     
    elif tecla == GLUT_KEY_UP:
        print ("CIMA")
    elif tecla == GLUT_KEY_DOWN:
        print ("BAIXO")

# Programa Base
def main():
    glutInit(sys.argv)
    glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH)    
    glutInitWindowSize(640, 480)
    glutInitWindowPosition(0, 0)
    glutCreateWindow("Planeta terra")
    glutDisplayFunc(DrawGLScene)
    glutIdleFunc(DrawGLScene)
    glutReshapeFunc(ReSizeGLScene)
    glutKeyboardFunc(keyPressed)
    glutSpecialFunc(teclaEspecialPressionada)
    InitGL(640, 480)
    glutMainLoop()


main()