package org.crud;

import org.crud.model.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      List<Person> people = new ArrayList<>();


    while (true) {
        showMenu();
        int select = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (select) {

            case 1 -> registerPerson(sc, people);

            case 2 -> listPeople(people);

            case 3 -> updatePerson(sc, people);

            case 4 -> removePerson(sc, people);

            case 0 ->  exit(sc);

            default -> System.out.println("Opção Invalida");

        }


    }


    }
    private static int nextId = 1;

    private static void showMenu(){
        System.out.println("1-Cadastrar pessoa");
        System.out.println("2-Listar todas as pessoas");
        System.out.println("3-Atualizar a lista");
        System.out.println("4-Remover pessoa");
        System.out.println("0-Sair");
        System.out.print("Selecione a opção desejada: ");
    }
    private static void registerPerson(Scanner sc, List<Person> people){
        System.out.println("Para cadastrar uma nova pessoa insira as seguintes informações");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Idade: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Email: ");
        String email = sc.nextLine();

        try{
            people.add(new Person(name, age, email, nextId++));
            System.out.println("Pessoa cadastrada com sucesso!");
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }

    }
    private static void listPeople(List<Person> people){
        if (!people.isEmpty()) {
            for (Person p : people) {
                System.out.println(p);
            }
        } else  {
            System.out.println("Nenhuma pessoa encontrada");
        }
    }
    private static void updatePerson(Scanner sc, List<Person> people){

        if (!people.isEmpty()) {
            System.out.print("Digite o ID da pessoa para atualizar seu cadastro: ");
            int id = Integer.parseInt(sc.nextLine());

            Person personFound = findById(people, id);

            if (personFound == null) {
                System.out.println("Pessoa não encontrada");
                return;
            }

            try {
                System.out.println("Insira o novo nome da pessoa: ");
                personFound.setName(sc.nextLine());

                System.out.println("Insira a novo idade da pessoa: ");
                personFound.setAge(Integer.parseInt(sc.nextLine()));

                System.out.println("Insira o novo email da pessoa: ");
                personFound.setEmail(sc.nextLine());

                System.out.println("Dados atualizados com sucesso");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao atualizar: " + e.getMessage());
            }
        } else {
        System.out.println("A lista está vazia");
    }
    }

    private static void removePerson(Scanner sc, List<Person> people){
        if (!people.isEmpty()) {

            System.out.print("Insira o ID da pessoa que deseja remover: ");
            int idToRemove = Integer.parseInt(sc.nextLine());

            Person personFound = findById(people, idToRemove);

            if (personFound == null) {
                System.out.println("A pessoa não foi encontrada");
                return;
            }

            people.remove(personFound);
            System.out.println("Pessoa removida com sucesso");

        } else {
            System.out.println("A lista está vazia");
        }
    }

    private static Person findById(List<Person> people, int id){
        for (Person p : people) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    private static void exit(Scanner sc){
        System.out.println("Finalizando o programa");
        sc.close();
        System.exit(0);
    }

}