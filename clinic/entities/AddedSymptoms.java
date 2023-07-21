package clinic.entities;

public class AddedSymptoms {
    private int patientId;
    private String symptomTitle;

    public AddedSymptoms(int patientId, String symptomTitle) {
        setPatientId(patientId);
        setSymptomTitle(symptomTitle);
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getSymptomTitle() {
        return symptomTitle;
    }

    public void setSymptomTitle(String symptomTitle) {
        this.symptomTitle = symptomTitle;
    }

    @Override
    public String toString() {
        return "AddedSymptoms {" +
                "patientId = " + getPatientId() +
                ", symptomTitle = " + getSymptomTitle() +
                '}';
    }
}
