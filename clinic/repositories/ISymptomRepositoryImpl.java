package clinic.repositories;

import clinic.data.IDBImpl;
import clinic.data.interfaces.IDB;
import clinic.entities.Symptom;
import clinic.repositories.interfaces.ISymptomRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ISymptomRepositoryImpl implements ISymptomRepository {
    private final IDB db = new IDBImpl();


    @Override
    public boolean addSymptom(Symptom symptom) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO symptom(title) VALUES (?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, symptom.getTitle());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
    public List<Symptom> getAllSymptoms() {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "select * from symptom";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Symptom> symptoms = new LinkedList<>();
            while (resultSet.next()) {
                Symptom symptom = new Symptom(resultSet.getString("Title"));
                symptoms.add(symptom);
            }
            return symptoms;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
