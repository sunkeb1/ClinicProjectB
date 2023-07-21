package clinic.repositories.interfaces;


import clinic.entities.Patient;

import java.util.List;

public interface IPatientRepository {
    boolean addPatient(Patient patient);

    Patient getPatient(int id);

    List<Patient> getAllPatients();
}
