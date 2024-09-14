package Contact;

import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Remover Contato");
            System.out.println("4. Listar Contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    System.out.print("Nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    contactList.addContact(new Contact(name, phone, email));
                    break;
                case 2:
                    System.out.print("Nome ou Telefone: ");
                    String searchKey = scanner.nextLine();
                    Contact foundContact = contactList.searchContact(searchKey);
                    if (foundContact != null) {
                        System.out.println("Contato encontrado: " + foundContact);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Nome ou Telefone do contato a remover: ");
                    String removeKey = scanner.nextLine();
                    if (contactList.removeContact(removeKey)) {
                        System.out.println("Contato removido com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 4:
                    contactList.listContacts();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 5);

        scanner.close();
    }
}