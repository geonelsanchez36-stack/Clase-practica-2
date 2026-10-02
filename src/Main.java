public class Main {

    static void main() {

        LinkedList<String>lista=new LinkedList<>();
        lista.add("Geonel");
        lista.add("Edgar");
        lista.add("Leonardo");
        lista.add("Jorge");
        lista.add("Jorge");

        //Eliminar repetidos

        //Antes de eliminar repetidos
        System.out.println("Lista con elementos repetidos: ");
        for (int i = 0; i < lista.getSize() ; i++) {
            System.out.print(lista.get(i)+" ");
        }
        System.out.println();
        System.out.println();

        //Despes de eliminar repetidos
        System.out.println("Lista sin elementos repetidos:");
        lista.eliminarRepetidos();
        for (int i = 0; i <lista.getSize() ; i++) {
            System.out.print(lista.get(i)+" ");
        }
        System.out.println();

        //Rotar Posicion derecha de los elementos
        System.out.println();
        System.out.println("Posicion derecha rotada:");
        lista.rotarPosicionDerecha();
        for (int i = 0; i <lista.getSize() ; i++) {
            System.out.print(lista.get(i)+" ");
        }
        System.out.println();

        //Concatenar dos listas
        LinkedList<String>lista2=new LinkedList<>();
        lista2.add("Adrian");
        lista2.add("Juan");
        lista2.add("Alejandro");

        System.out.println();

        //Concatenando lista con lista2

        System.out.println("Lista 1: ");
        for (int i = 0; i < lista.getSize(); i++) {
            System.out.print(lista.get(i)+" ");
        }
        System.out.println();
        System.out.println("Lista 2: ");
        for (int i = 0; i <lista2.getSize() ; i++) {
            System.out.print(lista2.get(i)+" ");
        }
        System.out.println();
        System.out.println("Listas concatenadas: ");
        lista=lista.concatenarListas(lista2);

        for (int i = 0; i <lista.getSize() ; i++) {
            System.out.print(lista.get(i)+" ");
        }


    }

}