package clinic;


import clinic.controllers.AddedSymptomController;
import clinic.controllers.PatientController;
import clinic.controllers.SymptomsController;
import clinic.entities.Patient;
import clinic.entities.Symptom;
import clinic.repositories.IPatientRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class Clinic {
    private final PatientController patientController = new PatientController();
    private final SymptomsController symptomsController = new SymptomsController();
    private final AddedSymptomController addedSymptomController = new AddedSymptomController();
    private final IPatientRepositoryImpl patientRepository = new IPatientRepositoryImpl();
    private final Scanner sc = new Scanner(System.in);

    public void command() {
        System.out.println("Clinic System");
        System.out.println("Command line");
        System.out.println("1 - add patient");
        System.out.println("2 - add symptom");
        System.out.println("3 - show patients");
        System.out.println("4 - show symptoms");
        System.out.println("5 - give a symptom to patient");
        System.out.println("6 - remove symptom from patient");
        System.out.println("7 - show patient's symptoms");
        System.out.println("8 - exit app");
    }

    public void addPatients() {
        System.out.println("Please enter name: ");
        String name = sc.next();
        System.out.println("Please enter surname: ");
        String surname = sc.next();
        System.out.println("Please enter age: ");
        Integer age = sc.nextInt();

        String response = patientController.addPatient(name, surname, age);
        System.out.println(response);
    }

    public void addSymptom() {
        System.out.println("Please enter symptom: ");
        String symptom = sc.next();

        String response = symptomsController.addSymptom(symptom);
        System.out.println(response);
    }

    public List<Patient> showPatients() {
        List<Patient> patients = patientController.getAllPatients();
        return patients;

    }

    public List<Symptom> showSymptoms() {
        List<Symptom> symptoms = symptomsController.getAllSymptoms();
        return symptoms;
    }

    public void giveSymptom() {
        for (Patient patient : showPatients()) {
            System.out.println(patient);
        }
        System.out.println("Choose the id of a patient: ");
        int id = sc.nextInt();
        System.out.println("Choose the symptom that you want to add: ");
        for (Symptom symptom : showSymptoms()) {
            System.out.println(symptom);
        }
        String symptom = sc.next();
        String returned = addedSymptomController.addedSymptom(id, symptom);
        System.out.println(returned);
    }

    public void removeSymptom() {
        for (Patient patient : showPatients()) {
            System.out.println(patient);
        }
        System.out.println("Choose the id of a patient: ");
        int id = sc.nextInt();
        System.out.println("Choose the symptom which you want to remove: ");
        showPatientsSymptoms();
        String symptom = sc.next();
        String addedSymptomsByPatientId = addedSymptomController.removeAddedSymptom(id, symptom);
        System.out.println(addedSymptomsByPatientId);
    }

    public void showPatientsSymptoms() {
        for (Patient patient : showPatients()) {
            System.out.println(patient);
        }
        System.out.println("Please enter patient's id: ");
        int id = sc.nextInt();
        String response = addedSymptomController.getAddedSymptomsByPatientId(id);
        System.out.println(patientController.getPatient(id));
        System.out.println(response);
    }

    public void closeApp() {
        System.out.println("app closing...");
        System.exit(0);
    }
}
