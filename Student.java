import java.util.HashMap;
import java.security.MessageDigest;

public class Student {
    private String name;
    private String email;
    private String password;

    public Student(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = hashPassword(password);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPasswordCorrect(String password) {
        return hashPassword(password).equals(this.password);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            return new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Student registerStudent(String name, String email, String password) {
        Student student = new Student(name, email, password);
        // Save the student to a database
        return student;
    }

    public static Student loginStudent(String email, String password) {
        // Retrieve the student from the database by email
        Student student = null;
        // ...

        if (student != null && student.isPasswordCorrect(password)) {
            return student;
        } else {
            return null;
        }
    }
}
