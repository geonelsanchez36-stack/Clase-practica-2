import java.util.Objects;

public class LinkedList<E> implements ListInterface<E> {

    private Nodo<E> cabeza;
    private int size;

    public LinkedList(){
        cabeza=null;
        size=0;
    }

    public int getSize() {
        return size;
    }


    @Override
    public void add(E valor) {
        Nodo<E> nuevo=new Nodo<>(valor);
        if (isEmpty()){
            cabeza=nuevo;
        }else {
            Nodo<E>cursor=cabeza;
            while (cursor.getNext() != null){
                cursor=cursor.getNext();
            }
            cursor.setNext(nuevo);
        }
        size++;
    }

    public void addFirst(E valor){
        Nodo<E>nuevo=new Nodo<>(valor);
        if (isEmpty()){
            cabeza=nuevo;
        }else {
            nuevo.setNext(cabeza);
            cabeza=nuevo;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return cabeza==null;
    }

    @Override
    public E get(int index) {
        Nodo<E>cursor=cabeza;
        if (index >=0 && index < size){
            for (int i = 0; i < index; i++) {
                cursor=cursor.getNext();
            }
            return cursor.getInfo();
        }else {
            throw new UnsupportedOperationException("Indice fuera de rango");
        }
    }

    @Override
    public E remove(int index) {
        Nodo<E>cursor=cabeza;
        if (index >= 0 && index < size){
            Nodo<E> aux;
            if (index == 0){
                aux=cabeza;
                cabeza=cabeza.getNext();
            }else {
                for (int i = 0; i <index - 1  ; i++) {
                    cursor=cursor.getNext();
                }
                aux =cursor.getNext();
                cursor.setNext(aux.getNext());
            }
            size--;
            return aux.getInfo();
        }else {
            throw new UnsupportedOperationException("Indice fuera de rango");
        }
    }

    public void eliminarRepetidos(){
        Nodo<E> actual=cabeza;

        while (actual != null){
            Nodo<E>anterior=actual;
            Nodo<E>aux=actual.getNext();

            while (aux != null){

                if (actual.getInfo().equals(aux.getInfo())){
                    anterior.setNext(aux.getNext());
                    size--;

                    aux=anterior.getNext();
                }else {
                    anterior=aux;
                    aux=aux.getNext();
                }
            }
            actual=actual.getNext();
        }

    }

    public void invertirLista(){
       Nodo<E> anterior=null;
       Nodo<E>actual=cabeza;
       Nodo<E>siguiente;

       while (actual != null){
           siguiente=actual.getNext();
           actual.setNext(anterior);
           anterior=actual;
           actual=siguiente;
       }
       cabeza=anterior;
    }

    public LinkedList<E> concatenarListas(LinkedList<E> lista){
        LinkedList<E> aux=new LinkedList<>();

        Nodo<E> cursor=cabeza;
        while (cursor !=null){
            aux.add(cursor.getInfo());
            cursor=cursor.getNext();
        }

        cursor=lista.cabeza;
        while (cursor !=null){
            aux.add(cursor.getInfo());
            cursor=cursor.getNext();
        }
        return aux;
    }

    public void rotarPosicionDerecha(){

        if (cabeza ==null || cabeza.getNext()==null){
            return;
        }

        Nodo<E> penultimo=cabeza;
        Nodo<E> ultimo=cabeza.getNext();
        while (ultimo.getNext() != null){
            penultimo=ultimo;
            ultimo=ultimo.getNext();
        }
        penultimo.setNext(null);
        ultimo.setNext(cabeza);
        cabeza=ultimo;
    }
}
