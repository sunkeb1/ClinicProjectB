package clinic.controllers;

import clinic.repositories.IAddedSymptomsRepositoryImpl;
import clinic.repositories.interfaces.IAddedSymptomsRepository;

import java.util.List;

public class AddedSymptomController {
    IAddedSymptomsRepository addedSymptomsRepository = new IAddedSymptomsRepositoryImpl();

    public String addedSymptom(int id, String symptom) {
        boolean created = addedSymptomsRepository.addAddedSymptoms(id, symptom);

        return (created ? "Symptom was added!" : "Failed");
    }

    public String removeAddedSymptom(int id, String symptom) {
        boolean created = addedSymptomsRepository.returnAddedSymptom(id, symptom);

        return (created ? "Symptom was removed!" : "Failed");
    }

    public String getAddedSymptomsByPatientId(int patientId) {
        List<String> symptoms = addedSymptomsRepository.showAddedSymptoms(patientId);
        return symptoms.toString();
    }
}
