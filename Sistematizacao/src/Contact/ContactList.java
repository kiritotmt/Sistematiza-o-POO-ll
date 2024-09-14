package Contact;

public class ContactList {
    private Node head;

    public ContactList() {
        head = null;
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Contato adicionado com sucesso!");
    }

    public Contact searchContact(String nameOrPhone) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(nameOrPhone) ||
                current.contact.getPhoneNumber().equals(nameOrPhone)) {
                return current.contact;
            }
            current = current.next;
        }
        return null; // Contato não encontrado
    }

    public boolean removeContact(String nameOrPhone) {
        if (head == null) return false;

        if (head.contact.getName().equalsIgnoreCase(nameOrPhone) || 
            head.contact.getPhoneNumber().equals(nameOrPhone)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.contact.getName().equalsIgnoreCase(nameOrPhone) || 
                current.next.contact.getPhoneNumber().equals(nameOrPhone)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false; // Contato não encontrado
    }

    public void listContacts() {
        if (head == null) {
            System.out.println("Nenhum contato na lista.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
    }
}