package controllers;

import models.Person;
import views.View;

public class Controller {

    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private Person[] personas;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        view.showMessage("Iniciando el programa...");
    }

    public void start() {
        try {
            int option;
            do {
                option = view.showMenu();
                switch (option) {
                    case 1: inputPersons(); break;
                    case 2: addPerson(); break;
                    case 3: sortPersons(); break;
                    case 4: searchPerson(); break;
                    case 100: view.showMessage("Hasta luego"); break;
                    default: view.showMessage("Opcion invalida ");
                }
            } while (option != 100);
        } catch (Exception e) {
            view.showMessage("Error " + e.getMessage());
        }
    }

    private void sortPersons() {
        if (isPersonListEmpty()) return;
        int sortingOption = view.selectSortingMethod();
        switch (sortingOption) {
            case 1: sortingMethods.sortByNameWithBubble(personas); break;
            case 2: sortingMethods.sortByNameWithSelectionDes(personas); break;
            case 3: sortingMethods.sortByAgeWithInsertion(personas); break;
            case 4: sortingMethods.sortByNameWithInsertion(personas); break;
            default: 
                view.showMessage("Opcion invalida. No se realizara ningun ordenamiento.");
                return;
        }
        view.showMessage("Arreglo ordenado:");
        view.displayPersons(personas);
    }

    public void inputPersons() {
        int numeroPersonas = view.inputInt("Ingrese el numero de personas: ");
        personas = new Person[numeroPersonas];
        for (int i = 0; i < numeroPersonas; i++) {
            view.showMessage("Persona #" + (i + 1));
            personas[i] = view.inputPerson();
        }
    }

    public void addPerson() {
        if (personas == null) {
            view.showMessage("No existe, ingrese las personas por primera vez");
            inputPersons();
        } else {
            int numeroPersonas = view.inputInt("Ingrese el numero de personas a adicionar: ");
            Person[] personasTotales = new Person[personas.length + numeroPersonas];
            System.arraycopy(personas, 0, personasTotales, 0, personas.length);
            for (int i = personas.length; i < personasTotales.length; i++) {
                view.showMessage("Persona #" + (i + 1));
                personasTotales[i] = view.inputPerson();
            }
            personas = personasTotales;
        }
    }

    private void searchPerson() {
        if (isPersonListEmpty()) return;
        int searchOption = view.selectSearchCriterion();
        switch (searchOption) {
            case 1: 
                if (!searchMethods.isSortedByAge(personas)) {
                    view.showMessage("El arreglo no esta ordenado por edad... Ordenando ...");
                    sortingMethods.sortByAgeWithInsertion(personas);
                }
                int age = view.inputAge();
                view.displaySearchResult(searchMethods.binarySearchByAge(personas, age));
                break;
            case 2: 
                if (!searchMethods.isSortedByName(personas)) {
                    view.showMessage("El arreglo no está ordenado por nombre... Ordenando ...");
                    sortingMethods.sortByNameWithBubble(personas);
                }
                String name = view.inputName();
                view.displaySearchResult(searchMethods.binarySearchByName(personas, name));
                break;
            default:
                view.showMessage("Opcion invalida ");
        }
    }

    private boolean isPersonListEmpty() {
        if (personas == null || personas.length == 0) {
            view.showMessage("Lista de Personas vacia ingrese");
            return true;
        }
        return false;
    }
}