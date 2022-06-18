import sdl2
from OpenGL.GL import *
from OpenGL.GLU import *

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
    # glBegin(GL_QUADS)
    # i = 0
    # for face in faces:
    #     # glColor3fv(cores[i])
    #     for vertex in face:
    #        glColor3fv(cores[vertex])
    #        glVertex3fv(vertices[vertex])
    #     i = i+1
    # glEnd()

    glColor3f(0,0.5,0)
    glBegin(GL_LINES)
    for linha in linhas:
        for vertice in linha:
            glVertex3fv(vertices[vertice])
    glEnd()

a = 0

def desenhaDoisCubos():
    # Cubo da Esquerda
    glPushMatrix()
    glTranslatef(-2,0,0)
    glRotatef(-a,0,0,1)
    Cubo()
    glPopMatrix()
    # Cubo da Direita
    glPushMatrix()
    glTranslatef(2,0,0)
    glRotatef(a,1,0,0)
    Cubo()
    glPopMatrix()


def desenha():
    global a
    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT)
    glPushMatrix()
    glTranslatef(0,-2,0)
    desenhaDoisCubos()
    glPopMatrix()
    glPushMatrix()
    glTranslatef(0,2,0)
    desenhaDoisCubos()
    glPopMatrix()
    a += 1

WINDOW_WIDTH = 800
WINDOW_HEIGHT = 600

sdl2.SDL_Init(sdl2.SDL_INIT_EVERYTHING)
sdl2.SDL_GL_SetAttribute(sdl2.SDL_GL_CONTEXT_MAJOR_VERSION, 2)
sdl2.SDL_GL_SetAttribute(sdl2.SDL_GL_CONTEXT_MINOR_VERSION, 1)
sdl2.SDL_GL_SetAttribute(sdl2.SDL_GL_CONTEXT_PROFILE_MASK,sdl2.SDL_GL_CONTEXT_PROFILE_CORE)
sdl2.SDL_GL_SetAttribute(sdl2.SDL_GL_DOUBLEBUFFER, 1)
sdl2.SDL_GL_SetAttribute(sdl2.SDL_GL_DEPTH_SIZE, 24)
sdl2.SDL_GL_SetSwapInterval(1)
window = sdl2.SDL_CreateWindow(b"Cubo", sdl2.SDL_WINDOWPOS_CENTERED, sdl2.SDL_WINDOWPOS_CENTERED, WINDOW_WIDTH, WINDOW_HEIGHT, sdl2.SDL_WINDOW_OPENGL | sdl2.SDL_WINDOW_SHOWN)
if not window:
    sys.stderr.write("Error: Could not create window\n")
    exit(1)
glcontext = sdl2.SDL_GL_CreateContext(window)
glEnable(GL_MULTISAMPLE)
glEnable(GL_DEPTH_TEST)
glClearColor(0.,0.,0.,1.)
print(glGetString(GL_VERSION))
gluPerspective(45,800.0/600.0,0.1,100.0)
glTranslatef(0.0,0.0,-20)

running = True
event = sdl2.SDL_Event()
while running:
    while sdl2.SDL_PollEvent(ctypes.byref(event)) != 0: # Pega o evento atual
        if event.type == sdl2.SDL_QUIT: # Sair
            running = False
        if event.type == sdl2.events.SDL_KEYDOWN: # Teclado pressionado
            print("SDL_KEYDOWN")
            if event.key.keysym.sym == sdl2.SDLK_ESCAPE: # Tecla ESC
                running = False
        if (event.type == sdl2.SDL_MOUSEMOTION): # Mouse mexendo
            print("SDL_MOUSEMOTION")
        if (event.type == sdl2.SDL_MOUSEBUTTONDOWN): # Mouse clicando
            print("SDL_MOUSEBUTTONDOWN")
    desenha()
    sdl2.SDL_GL_SwapWindow(window)