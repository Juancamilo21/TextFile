package filesexample;

import javax.swing.JOptionPane;
import java.io.IOException;

public class MainFile {

    public static void main(String[] args) throws IOException {
        var option = 0;
        var files = new Files();
        var exit = false;
        Student student;
        do {
            option = Integer.parseInt(captureData("Select an option\n\n1. Write to file\n2. Read file\n3. Number of students\n4. Exit"));
            switch (option) {
                case 1 -> {
                    student = new Student();
                    student.setName(captureData("Enter the name"));
                    student.setLastname(captureData("Enter the lastname"));
                    student.setAge(Integer.parseInt(captureData("Enter the age")));
                    student.setCode(captureData("Enter the code"));
                    files.writeFile(student);
                }
                case 2 -> message(files.readFile("Student.txt"));
                case 3 -> message("Number:  " + files.numberStudents("Student.txt"));
                case 4 -> exit = true;
            }
        } while (!exit);

    }

    private static void message(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    private static String captureData(String text) {
        return JOptionPane.showInputDialog(text);
    }
}
