package clinic.controllers;



import clinic.entities.Patient;
import clinic.repositories.IPatientRepositoryImpl;
import clinic.repositories.interfaces.IPatientRepository;

import java.util.List;

public class PatientController {
     IPatientRepository patientRepository=new IPatientRepositoryImpl();

     public String getPatient(int id) {
         Patient patient = patientRepository.getPatient(id);

         return (patient == null ? "Patient was not found!" : patient.toString());
     }

    public List<Patient> getAllPatients() {

        return patientRepository.getAllPatients();
    }

    public String addPatient(String name, String surname, Integer age) {
        Patient patient = new Patient(name, surname, age);

        boolean created = patientRepository.addPatient(patient);

        return (created ? "Patient was created!" : "Patient creation was failed!");
    }
}
