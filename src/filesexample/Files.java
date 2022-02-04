package filesexample;

import java.io.*;

public class Files {

    File file;

    public Files() {
    }

    public void writeFile(Student student) throws IOException {
        file = new File("Student.txt");
        BufferedWriter writer;
        if (!file.exists()) writer = new BufferedWriter(new FileWriter(file));
        else writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(student.getName() + "%" + student.getLastname() + "%" + student.getAge() + "%" + student.getCode());
        writer.newLine();
        writer.close();
    }

    public String readFile(String path) throws IOException {
        StringBuilder show = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String read = reader.readLine();
        int count = 1;
        while (read != null) {
            show.append(count).append(".  ").append(read).append("\n");
            count++;
            read = reader.readLine();
        }
        reader.close();
        return show.toString();
    }

    public int numberStudents(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String read = reader.readLine();
        int count = 0;
        while (read != null) {
            count++;
            read = reader.readLine();
        }
        reader.close();
        return count;
    }
}
