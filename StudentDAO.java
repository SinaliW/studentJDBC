import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getGrade());
            pst.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("grade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void updateStudent(int id, String name, int age, String grade) {
        String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, grade);
            pst.setInt(4, id);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

