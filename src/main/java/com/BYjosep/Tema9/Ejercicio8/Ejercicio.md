# 📚 Gestión de Diccionario

Este programa permite gestionar un diccionario utilizando la estructura `Map`. El usuario podrá añadir, modificar, eliminar, consultar y mostrar palabras con sus definiciones.

---
```Java
##  Menú del Programa


***********************
* GESTIÓN DICCIONARIO *
***********************
1. Añadir palabra
2. Modificar palabra
3. Eliminar palabra
4. Consultar palabra
5. Mostrar diccionario
---------------------
0. Salir
````

---

## ✅ Funcionalidades a Implementar
    
- [x] ### Opción 1: Añadir palabra

 - [x] Solicitar palabra
 - [x] Solicitar definición
 - [x]  Verificar si la palabra ya existe
 - [x]  Si no existe, añadir al diccionario
 - [x]  Si ya existe, mostrar mensaje de error



- [x]  ### Opción 2: Modificar palabra


 - [x] Solicitar palabra a modificar
 - [x] Verificar existencia
 - [x] Si existe, pedir nueva definición y actualizar
 - [x] Si no existe, mostrar mensaje de error
    

- [X] ### Opción 3: Eliminar palabra

- [x] Solicitar palabra a eliminar
- [x] Verificar si existe
- [x] Si existe, eliminar del diccionario
- [x] Si no existe, mostrar mensaje de error
    

- [x] ### Opción 4: Consultar palabra

- [x] Solicitar palabra a consultar
- [x] Mostrar la definición si existe
- [x] Mostrar mensaje si no existe
   

- [x] ### Opción 5: Mostrar diccionario

- [x] Recorrer todas las entradas del `Map` 
- [x] Mostrar palabra y su definición formateadas
  

### Opción 0: Salir

- [x]  Terminar la ejecución del programa
    

### Extras opcionales

-  Validar que las entradas no estén vacías
    
-  Ignorar mayúsculas/minúsculas al consultar
    
-  Añadir confirmación al eliminar palabras
    

---


## 🧪 Ejemplo de ejecución

```Java
***********************
* GESTIÓN DICCIONARIO *
***********************
1. Añadir palabra
2. Modificar palabra
3. Eliminar palabra
4. Consultar palabra
5. Mostrar diccionario
---------------------
0. Salir
Elige una opción: 1
Introduce palabra: casa
Introduce definición: Lugar donde vives

Elige una opción: 4
Introduce palabra a consultar: casa
Definición: Lugar donde vives

Elige una opción: 5
Diccionario completo:
- casa: Lugar donde vives

Elige una opción: 0
Saliendo del programa...
```
