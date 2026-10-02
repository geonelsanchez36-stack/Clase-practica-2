# Clase-practica-2
# Clase-practica-2
# Clase Práctica 2 — Listas Enlazadas en Java

Este proyecto lo hice para dar respuesta a la **Clase Práctica 2** de Estructura de Datos. La idea era implementar desde cero una **lista enlazada simple** en Java y resolver los tres ejercicios que nos pidieron:

1. Quitar los elementos repetidos de una lista.
2. Rotar una posición a la derecha los elementos.
3. Concatenar dos listas.

Todo está hecho con **genéricos**, así que la lista funciona con cualquier tipo de dato (String, Integer, lo que sea).

---

## 🧩 ¿Qué contiene el proyecto?

Tengo cuatro archivos en Java, cada uno con su responsabilidad:
├── Nodo.java → el nodo de la lista
├── ListInterface.java → la interfaz con las operaciones básicas
├── LinkedList.java → la lista enlazada como tal
└── Main.java → donde pruebo todo


## 📄 Explicación de cada clase

### `Nodo.java`

Es la pieza más pequeña de todo. Un nodo guarda dos cosas:

- `info` → el valor que le metemos (por eso es genérico, `E`).
- `next` → la referencia al siguiente nodo.

Tiene sus getters y setters normales (`getInfo`, `setInfo`, `getNext`, `setNext`) y un constructor que recibe el valor y deja `next` en `null`.

---

### `ListInterface.java`

Es una interfaz genérica que define lo mínimo que debe tener una lista. Nada del otro mundo, solo cuatro métodos:

- `add(E valor)` → mete un elemento al final.
- `isEmpty()` → dice si la lista está vacía.
- `get(int index)` → devuelve el elemento en esa posición.
- `remove(int index)` → saca el elemento en esa posición y lo devuelve.

---

### `LinkedList.java`

Aquí está el corazón del proyecto. La clase implementa la interfaz y guarda dos cosas:

- `cabeza` → el primer nodo de la lista.
- `size` → cuántos elementos hay.

#### Métodos básicos

- **`add(E valor)`** → recorre hasta el final y engancha el nuevo nodo. Si la lista está vacía, el nuevo pasa a ser la cabeza.
- **`addFirst(E valor)`** → mete el nuevo nodo al inicio, apuntando a la antigua cabeza.
- **`isEmpty()`** → simplemente revisa si `cabeza == null`.
- **`get(int index)`** → valida que el índice esté dentro del rango y recorre hasta esa posición.
- **`remove(int index)`** → si es el primero, muevo la cabeza. Si no, recorro hasta el anterior y salto el nodo a eliminar.

#### Los tres métodos de la práctica ⭐

**1. `eliminarRepetidos()`**

Recorro la lista con un nodo `actual`, y por cada uno reviso el resto con `aux`. Si encuentro un valor igual (`equals`), salto ese nodo enganchando `anterior.setNext(aux.getNext())` y bajo el `size`. Así solo queda la primera aparición de cada valor.

Ejemplo:
Antes: Geonel → Edgar → Leonardo → Jorge → Jorge
Después: Geonel → Edgar → Leonardo → Jorge


**2. `rotarPosicionDerecha()`**

La idea es que el último pase a ser el primero. Busco el penúltimo y el último nodo, corto el enlace del penúltimo (`setNext(null)`), hago que el último apunte a la cabeza, y actualizo `cabeza = ultimo`.

Ejemplo:
Antes: Geonel->Edgar->Leonardo->Jorge
Después: Jorge->Geonel->Edgar->Leonardo

**3. `concatenarListas(LinkedList<E> lista)`**

Devuelve una **lista nueva** con los elementos de la actual seguidos de los de la lista que le paso. No modifico ninguna de las dos originales, solo voy agregando todo a una lista auxiliar y la retorno.

Ejemplo:
Lista1: Jorge->Geonel->Edgar->Leonardo 
Lista2:Adrian->Juan->Alejandro 
Resultado: Jorge->Geonel->Edgar->Leonardo->Adrian->Juan Alejandro 
