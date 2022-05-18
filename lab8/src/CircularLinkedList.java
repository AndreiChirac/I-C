/**
 * Clasa care reprezinta o Lista Circulara!
 * CircularLinkedList implementeaza o lista circulara cu toate operatiile
 * aferente:
 * - adaugarea unui nod
 * - stergerea unui nod
 * - verificarea existentei unui nod in lista
 */
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * adauga un nod in lista
     * @param value reprezinta valoarea aferenta nodului care trebuie inserat
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * cauta existenta unui valori in lista
     * @param searchValue reprezinta valoarea cautata in lista
     * @return true/false daca valorea a fost sau nu gasita
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * stergerea unui nod din lista
     * @param valueToDelete valoarea aferenta nodului care trebuie eliminat
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * ofera urmatorul nod pe baza unui nod dat
     * @param currentNode nodul curent
     * @return nodul urmator
     */
    public Node getNextNode(Node currentNode) {
        return currentNode.nextNode;
    }
}