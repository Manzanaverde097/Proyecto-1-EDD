**PROYECTO 1 – SOPA DE LETRAS CON BÚSQUEDA EN GRAFOS (DFS/BFS)**

---

**Descripción general**  
Este proyecto consiste en una aplicación que resuelve sopas de letras representadas mediante grafos no dirigidos. El sistema permite cargar un tablero 4x4 y un diccionario desde un archivo `.txt`, y luego busca las palabras válidas utilizando algoritmos de búsqueda *Depth-First Search (DFS)* y *Breadth-First Search (BFS)*.  
La aplicación está diseñada con una interfaz gráfica amigable usando Java Swing, e implementa estructuras de datos propias para manejar listas, vértices y grafos sin el uso de librerías externas para algoritmos.

---

**Funcionalidades**
- Carga de archivo `.txt`: El usuario selecciona un archivo que contiene un diccionario de palabras y el tablero 4x4.
- Visualización de datos cargados: Se muestra el contenido del diccionario y del tablero en pantalla.
- Búsqueda de palabras (DFS o BFS): El sistema permite buscar qué palabras del diccionario están en el tablero, según las reglas de adyacencia.
- Buscar palabra específica: El usuario puede ingresar una palabra y el sistema indicará si está en el tablero. Si no está en el diccionario pero sí en el tablero, se añade automáticamente.
- Medición de tiempo: El tiempo que tarda en encontrar todas las palabras se muestra en milisegundos.
- Visualización del árbol BFS: Para búsquedas individuales con BFS, se genera un árbol visual del recorrido usando GraphStream.
- Guardar diccionario actualizado: El usuario puede guardar los cambios realizados sobre el diccionario original.

---
Pasos para jugar
1 Aparecera una ventana que dira salir, como jugar(una guia) y el empezar juego
2 Al darle a empezar juego, cargue el txt, y volvera a aparecer en la ventana anterior, dele de nuevo a empezar juego y ahi le saldra el modo bfs y dfs disponible
3. puede agregar palabras nuevas al diccionario, anadiendolar en el menu de juego, y tambien podra ver el recorrido

**Lógica y estructura técnica**
- Modelo de grafo: Cada letra del tablero es un vértice en un grafo no dirigido, conectado a sus letras adyacentes (incluyendo diagonales).
- Restricciones aplicadas:  
  - Las letras no se repiten en la misma palabra.  
  - Las palabras válidas deben tener al menos 3 letras.  
  - Deben estar presentes en el diccionario cargado.
- Estructuras de datos: Se utilizan clases propias para la implementación de listas, nodos, vértices y grafos.
- Algoritmos: Implementación desde cero de DFS y BFS respetando las reglas del juego.
- Interfaz gráfica: Desarrollada con Java Swing, evitando entradas y salidas por consola.

---

**Requisitos técnicos**
- Lenguaje: Java 17+
- IDE recomendado: NetBeans
- Librerías externas permitidas: Solo para visualización del árbol BFS (GraphStream)
- Restricciones importantes:  
  - No se permite usar librerías para grafos o estructuras de datos.  
  - No se permiten programas sin interfaz gráfica.  
  - El código debe estar documentado con Javadoc.  
