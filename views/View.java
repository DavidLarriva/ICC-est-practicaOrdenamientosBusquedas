
package views;
import java.util.Scanner;

import models.Person;
public class View {

    Scanner sc = new Scanner(System.in);

    public int showMenu() {

        System.out.println(" MENU ");
        System.out.println("Opcion 1: Ingresar Personas ");
        System.out.println("Opcion 2: ");
        System.out.println("Opcion 100: Regresar");
        System.out.println();
        System.out.println("Ingrese una opcion ");

        int  opcion = sc.nextInt();
        return opcion;



    }

    public Person inputPerson() {
        String name = inputName();
        int age = inputAge();

        

        return new Person(name,age);

        

    }

    private int inputAge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la edad ");
        int age = sc.nextInt();
        return age;
    }

    private String inputName() {
        System.out.println("Ingrese el nombre de la persona");
        String name = sc.nextLine();
        return name;
    }

    public int selectSortingMethod(){
        System.out.println("Select sorting criterion: ");
        System.out.println("1:  Name");
        System.out.println("2:  Age");

        int  opcion = sc.nextInt();
        return opcion;



    }

    public int selectSearchCriterion(){
        System.out.println("Select search criterion: ");
        System.out.println("1:  Name");
        System.out.println("2:  Age");
        int   opcion = sc.nextInt();
        return opcion;

    }

    public void displayPersons(Person[] personsList) {
        for (Person person : personsList) {
            System.out.println(person.toString());
        }
    }

    public void displaySearchResult(Person person) {

    }



    public int crearYvalidarNumero (String mensaje) {
        System.out.println(mensaje);
        Scanner sc = new Scanner(System.in);
        boolean numeroValido = false;
        int numero =0;

    while(!numeroValido) {
        if(sc.hasNextInt()) {
            numero = sc.nextInt();

            if (numero > 0){
                numeroValido = true;
            }else {
                System.out.println("Error el numero debe ser mayor a 0");
            }
        } else {
            System.out.println("Error no puedes ingresar ni letras ni simbolos");
            sc.next();
        }

        

    }

    return numero;


        



    }

    public void showMessage(String string) {
        System.out.println(string);
    }




    
}
