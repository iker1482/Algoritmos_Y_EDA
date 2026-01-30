Este proyecto fue elaborado por: Iker, Jorge y Juan Pablo

Los archivos del protecto son los siguientes:


<img width="183" height="165" alt="Captura de pantalla 2025-08-23 a la(s) 8 07 31 p m" src="https://github.com/user-attachments/assets/53d2229e-2b2a-4696-a78a-b478f1b64a8c" />


1.  EE_Doble define las estructuras enlazadas que basicamente contiene nodos que tienen la direccion de su sucesor y su predecesor
- Los metodos que creamos especialmente para este proyecto es el de inserta ordenado, este metodo recorre toda la lista y ve donde es pertinente introducir el nuevo paciente mediante el uso de compare to tomando el parametro prioridad para hacer la comparaciòn 
2.  Excepcion es solo una excepcion que manda la lista cuando esta vacia y se quiere hacer algo relacionado a un nodo inexistente 
3. IteradoEE recorre los nodos dobles de la lista
4. Nodo Arbol tiene las funciones de tener un nodo a la izquierda y otro a la derecha 
5. Nodo D es un nodo doble utilizado en la lista enlazada que tiene direccion de su predecesor y suceso en la lista 
6. Paciente es una clase basica que define a los pacientes por su nombre y urgencia aqui suponemos que el nombre es un identificador unico en la practica podriamos tambien crearle un id unico a cada paciente sobre todo para las operaciones de busqueda
7. ST_Arbol Define un Arbol binario para el uso de pacientes en la cual se establecen la variable de raiz que es el primer nodo del arbol desde el cual se construye todo, la lógica que sigue el arbol es que los pacientes con menor prioridad se van a la izquierda y los de mayor prioridad se van a la derecha. 
8. ST_Lista utiliza la lista EE_D Para crear el sistema y ajusta los metodos a sus preferencias
    -- Para actualizar un paciente es necesario especificar su nueva prioridad, el paciente al cual estas ajustando su prioridad
10. prueba la implementacion del sistema de triaje en ambos metodos


Para ejecutar el codigo es necesario que:
 Descargar los archivos
1. Para probar la ejecucion necesitas verificar que las dependencias del archivo esten en el ordenador ademas de excel para poder leer los csv
2. Correr las clases de las cuales depende que son Arbol, NodoArbol
3. ejecutar St_pruebas y y tener sus dependencias instaladas
4. revisar los archivos csv para ver la ejecucion
5. Abrir todos los csv.
6. Abrir gráficas y actualizar datos de cada csv (que están ligados en gráficas)



Discusion del desempeño del proyecto:

Nos dimos cuenta que aunque los dos metodos tienen sus caracteristicas distintas el metodo de la lista fue claramente mejor en las operaciones de cambio y atender debido a la naturaleza de su estructura. Cuando el arbol atiende debe de cambiar su raiz y un poco su estructura, mientras que la lista solo quita el enlace del primero al sigueinte nodo y apunta el puntero de primero al segundo. En la operacion agregar fueron muy similares ambas soluciones, nos dio mucha curiosidad si el Heap es mejor solucion debido a que buscando vimos que trabaja como una cola que es justo lo que se necesita en un sistema de triaje

En cuanto a la elaboración del proyecto, dedicamos unos 6 días consecutivos cada quien invirtiéndole aproximádamente 1 hora diaria. Nos repartimos el trabajo equitativamente, con Jorge haciendo la lista, iker y Juan Pablo el árbol, Jorge el readme, Juan Pablo las gráficas e Iker las pruebas como tal. Fue provechoso trabajar en equipo porque aprendimos a usar Visual Studio, GitHub e implementación eficiente de pruebas. También tuvimos las herramientas necesarias para evaluar la ejecución del proyecto. 

Una reserva es que, si bien aprendimos mucho, nos fue complicado acostumbrarnos a esta implementación. Un grave problema fue que nunca habíamos trabajado con árboles binarios.

Graficas: Eje x cant pacientes, Eje y tiempo en milisegundos(decidimos usar milisegundos para ver cambios mas tacitos en las graficas)

<img width="1103" height="745" alt="Captura de pantalla 2025-08-23 a la(s) 6 36 43 p m" src="https://github.com/user-attachments/assets/e2d81687-8183-4490-80d9-8b4ad80628e0" />
<img width="1060" height="756" alt="Captura de pantalla 2025-08-23 a la(s) 6 36 30 p m" src="https://github.com/user-attachments/assets/74f88c48-cea0-41f0-8467-40666b98a48f" />
<img width="1052" height="740" alt="Captura de pantalla 2025-08-23 a la(s) 6 36 17 p m" src="https://github.com/user-attachments/assets/9c973608-385f-4674-818b-f344aa4e71a7" />
<img width="1102" height="746" alt="Captura de pantalla 2025-08-23 a la(s) 6 36 06 p m" src="https://github.com/user-attachments/assets/79418a37-a894-4b55-98f1-098827be33dd" />
<img width="1096" height="780" alt="Captura de pantalla 2025-08-23 a la(s) 6 35 53 p m" src="https://github.com/user-attachments/assets/12f01cef-50a3-46fe-882b-3b106c025965" />
<img width="1050" height="778" alt="Captura de pantalla 2025-08-23 a la(s) 6 35 41 p m" src="https://github.com/user-