package clinic.repositories.interfaces;

import java.util.List;

public interface IAddedSymptomsRepository {
    List<String> showAddedSymptoms(int patientId);

    boolean addAddedSymptoms(int studentId, String symptomTitle);

    boolean returnAddedSymptom(int id, String title);
}
