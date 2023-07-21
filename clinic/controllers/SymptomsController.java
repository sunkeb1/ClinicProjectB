package clinic.controllers;

import clinic.entities.Symptom;
import clinic.repositories.ISymptomRepositoryImpl;
import clinic.repositories.interfaces.ISymptomRepository;

import java.util.List;

public class SymptomsController {
    ISymptomRepository symptomRepository = new ISymptomRepositoryImpl();

    public List<Symptom> getAllSymptoms() {

        return symptomRepository.getAllSymptoms();
    }

    public String addSymptom(String title) {
        Symptom symptom = new Symptom(title);

        boolean created = symptomRepository.addSymptom(symptom);

        return (created ? "Symptom was created!" : "Symptom creation was failed!");
    }
}
