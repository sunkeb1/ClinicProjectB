package clinic.repositories;

import clinic.data.IDBImpl;
import clinic.data.interfaces.IDB;
import clinic.entities.AddedSymptoms;
import clinic.repositories.interfaces.IAddedSymptomsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IAddedSymptomsRepositoryImpl implements IAddedSymptomsRepository {
    private final IDB db=new IDBImpl();

    @Override
    public boolean addAddedSymptoms(int patientId, String symptomTitle) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "insert into addedsymptoms (patient_id, symptom_title) values (?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, patientId);
            st.setString(2, symptomTitle);

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean returnAddedSymptom(int patientId, String symptomTitle) {
        Connection con = null;
        AddedSymptoms addedSymptom = null;
        try {
            con = db.getConnection();
            String sql = "select * from addedsymptoms where patient_id = ? and symptom_title = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, patientId);
            st.setString(2, symptomTitle);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                addedSymptom = new AddedSymptoms(rs.getInt("patient_id"), rs.getString("symptom_title"));
            }
            if (addedSymptom != null) {
                sql = "delete from addedsymptoms where patient_id = ? and symptom_title = ?";
                st = con.prepareStatement(sql);
                st.setInt(1, patientId);
                st.setString(2, symptomTitle);

                st.execute();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<String> showAddedSymptoms(int patientId) {
        Connection con = null;
        List<String> addedSymptoms = new ArrayList<>();
        try {
            con = db.getConnection();
            String sql = "select symptom_title from addedsymptoms where patient_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, patientId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String symptomTitle = rs.getString("symptom_title");
                addedSymptoms.add(symptomTitle);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return addedSymptoms;
    }}



