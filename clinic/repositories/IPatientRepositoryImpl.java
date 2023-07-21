package clinic.repositories;


import clinic.data.IDBImpl;
import clinic.data.interfaces.IDB;
import clinic.entities.Patient;
import clinic.repositories.interfaces.IPatientRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class IPatientRepositoryImpl implements IPatientRepository {
    private final IDB db=new IDBImpl();


    @Override
    public boolean addPatient(Patient patient) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO patient(name,surname,age) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, patient.getName());
            st.setString(2, patient.getSurname());
            st.setInt(3, patient.getAge());

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
    public Patient getPatient(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, age FROM patient WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("age"));

                return patient;
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
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        Connection connection = null;
        try {
            connection = db.getConnection();
            String sql = "select * from patient";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Patient> patients = new LinkedList<>();
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"));
                patients.add(patient);
            }
            return patients;
        }
        catch (SQLException throwables) {
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
