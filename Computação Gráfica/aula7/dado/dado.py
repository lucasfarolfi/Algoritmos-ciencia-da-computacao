from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
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

# Carrega as imagens como texturas das figuras
def LoadTextures():
    global texture
    texture = [ glGenTextures(1) ]

    glBindTexture(GL_TEXTURE_2D, texture[0])
    reader = png.Reader(filename='dado.png')
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
    glClearColor(0.0, 0.0, 0.0, 1.0) 
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

# Desenha no OpenGL a figura
def DrawGLScene():
    global xrot, yrot, zrot, texture

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)    
    glLoadIdentity()                   
    glClearColor(0.5,0.5,0.5,1.0)            
    glTranslatef(0.0,0.0,-5.0)
    glRotatef(xrot,1.0,0.0,0.0)          
    glRotatef(yrot,0.0,1.0,0.0)           
    glRotatef(zrot,0.0,0.0,1.0) 
    
    glBindTexture(GL_TEXTURE_2D, texture[0])
    glBegin(GL_QUADS)              
    
    # Face frontal
    glTexCoord2f(0.0, 0.0); glVertex3f(-1.0, -1.0,  1.0)    
    glTexCoord2f(0.0, 1/2); glVertex3f( 1.0, -1.0,  1.0)   
    glTexCoord2f(1/3, 1/2); glVertex3f( 1.0,  1.0,  1.0)   
    glTexCoord2f(1/3, 0.0); glVertex3f(-1.0,  1.0,  1.0)  

    # Face de tras
    glTexCoord2f(2/3, 1.0); glVertex3f(-1.0, -1.0, -1.0)
    glTexCoord2f(1.0, 1.0); glVertex3f(-1.0,  1.0, -1.0)
    glTexCoord2f(1.0, 1/2); glVertex3f( 1.0,  1.0, -1.0)
    glTexCoord2f(2/3, 1/2); glVertex3f( 1.0, -1.0, -1.0)
    
    # Face do teto
    glTexCoord2f(1/3, 1/2); glVertex3f(-1.0,  1.0, -1.0)
    glTexCoord2f(2/3, 1/2); glVertex3f(-1.0,  1.0,  1.0)
    glTexCoord2f(2/3, 1); glVertex3f( 1.0,  1.0,  1.0)
    glTexCoord2f(1/3, 1); glVertex3f( 1.0,  1.0, -1.0) 

    # Face da base     
    glTexCoord2f(1/3, 1/2); glVertex3f(-1.0, -1.0, -1.0)
    glTexCoord2f(2/3, 1/2); glVertex3f( 1.0, -1.0, -1.0)
    glTexCoord2f(2/3, 0); glVertex3f( 1.0, -1.0,  1.0)
    glTexCoord2f(1/3, 0); glVertex3f(-1.0, -1.0,  1.0)   
    
    # Face da direita
    glTexCoord2f(0.0, 1.0); glVertex3f( 1.0, -1.0, -1.0)
    glTexCoord2f(1/3, 1.0); glVertex3f( 1.0,  1.0, -1.0)
    glTexCoord2f(1/3, 1/2); glVertex3f( 1.0,  1.0,  1.0)
    glTexCoord2f(0.0, 1/2); glVertex3f( 1.0, -1.0,  1.0)  
    
    # Face da esquerda
    glTexCoord2f(2/3, 1/2); glVertex3f(-1.0, -1.0, -1.0)
    glTexCoord2f(1.0, 1/2); glVertex3f(-1.0, -1.0,  1.0)
    glTexCoord2f(1.0, 0.0); glVertex3f(-1.0,  1.0,  1.0)
    glTexCoord2f(2/3, 0.0); glVertex3f(-1.0,  1.0, -1.0)  
    
    glEnd() # Fecha o desenho
    
    # Velocidade inicial da rotação dos eixos X, Y e Z
    xrot = xrot + 0.01                
    yrot = yrot + 0.01                 
    zrot = zrot + 0.01                 

    # Troca de desenho ao carregar o proximo frame
    glutSwapBuffers() 

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
        zrot -= dz                   # Z rotation  
    elif tecla == GLUT_KEY_RIGHT:
        print ("DIREITA")
        xrot += dx                # X rotation
        yrot += dy                 # Y rotation
        zrot += dz                    # Z rotation 
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
    glutCreateWindow("Dado")
    glutDisplayFunc(DrawGLScene)
    glutIdleFunc(DrawGLScene)
    glutReshapeFunc(ReSizeGLScene)
    glutKeyboardFunc(keyPressed)
    glutSpecialFunc(teclaEspecialPressionada)
    InitGL(640, 480)
    glutMainLoop()


main()