package clinic;

import clinic.entities.Patient;
import clinic.entities.Symptom;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Clinic cl = new Clinic();

        cl.command();
        while (true) {
            System.out.println("Enter your choice: ");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    cl.addPatients();
                    break;
                case 2:
                    cl.addSymptom();
                    break;
                case 3:
                    for (Patient patient : cl.showPatients()) {
                        System.out.println(patient);
                    }
                    break;
                case 4:
                    for (Symptom symptom : cl.showSymptoms()) {
                        System.out.println(symptom);
                    }
                    break;
                case 5:
                    cl.giveSymptom();
                    break;
                case 6:
                    cl.removeSymptom();
                    break;
                case 7:
                    cl.showPatientsSymptoms();
                    break;
                case 8:
                    cl.closeApp();

                default:
                    System.out.println("Wrong number!");
            }
        }
    }
}