import java.util.HashMap;
import java.security.MessageDigest;

public class Teacher {
    private String name;
    private String email;
    private String password;

    public Teacher(String name, String email, String password) {
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

    public static Teacher registerTeacher(String name, String email, String password) {
        Teacher teacher = new Teacher(name, email, password);
        // Save the teacher to a database
        return teacher;
    }

    public static Teacher loginTeacher(String email, String password) {
        // Retrieve the teacher from the database by email
        Teacher teacher = null;
        // ...

        if (teacher != null && teacher.isPasswordCorrect(password)) {
            return teacher;
        } else {
            return null;
        }
    }
}
