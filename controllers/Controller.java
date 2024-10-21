package controllers;
import views.View;

import java.util.Scanner;

import models.Person;
public class Controller {

    Scanner sc =  new Scanner(System.in);


    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    private Person[] personas;
    
    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;

    }

    public void start() {
        int option = 0;
        do{
            option = view.showMenu();
            switch(option) {
                case 1:
                    inputPersons();
                    break;

                case 2:
                    addPersons();
                    break;

                case 3:
                    sortPersons();

                default:
                System.out.println("Opcion incorretca..");
            }

        }while(option!=0);
    }


    private void sortPersons() {
        int sortingOption = view.selectSortingMethod();
    }

    public void inputPersons() {
        
        int numeroPersonas = view.crearYvalidarNumero("Ingrese el numero de personas: ");
        personas = new Person[numeroPersonas];
        for(int i=0; i < numeroPersonas;i++) {
            personas[i] = view.inputPerson();
        }
    }
    
    public void addPersons() {
        if (personas == null) {
            view.showMessage("No existe ingrese las personas por primera vez");
            inputPersons();
        }else{System.out.println("");
        int numeroPersonas = view.crearYvalidarNumero("Ingrese el numero de personas a adicionar: ");
        Person[] personasTotales = new Person[personas.length + numeroPersonas];

        for(int i=0; i<personas.length;i++) {
            personasTotales[i] = personas[i];
        }

        for(int i=numeroPersonas; i < personasTotales.length;i++) {
            personas[i] = view.inputPerson();
        }

        personas = personasTotales;}

        


    }


    
}
