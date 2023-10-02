package System;

import java.io.*;
import java.util.ArrayList;

import static System.Controller.studentData;

public class ReadAndWrite {
    private static final String STUDENT_FILE = "student.txt";
    public static void write(ArrayList<Student> studentData) {
        try{
            FileWriter fileWriter = new FileWriter(STUDENT_FILE,true);
            BufferedWriter buffWriter  =new BufferedWriter(fileWriter);
            for(Student student : studentData) {
                buffWriter.write(student.toString());
                buffWriter.newLine();
            }
            buffWriter.close();
            fileWriter.close();
        }catch (Exception exc) {
            System.out.println("File have some error to save !");
        }
    }
    public static ArrayList<Student> read(String STUDENT_FILE) {
        try (FileReader fileReader = new FileReader(STUDENT_FILE);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Student student = parseStudent(line);
                if (student != null) {
                    studentData.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentData;
    }
    public static Student parseStudent(String line) {
        line = line.trim();

        if (!line.startsWith("idStudent=")) {
            return null;
        }
        Student student = new Student();

        String[] fields = line.split(", ");
        for (String field : fields) {
            int equalIndex = field.indexOf('=');
            if (equalIndex != -1) {
                String key = field.substring(0, equalIndex).trim();
                String value = field.substring(equalIndex + 1).trim();
                switch (key) {
                    case "idStudent" -> student.setIdStudent(value);
                    case "college" -> student.setCollege(value);
                    case "course" -> student.setCourse(Integer.parseInt(value));
                    case "average" -> student.setAverage(Double.parseDouble(value));
                    case "rankedAcademic" -> student.setRankedAcademic();
                    case "id" -> student.setId(Integer.parseInt(value));
                    case "name" -> student.setName(value);
                    case "date" -> student.setDate(value);
                    case "address" -> student.setAddress(value);
                    case "height" -> student.setHeight(Double.parseDouble(value));
                    case "weight" -> student.setWeight(Double.parseDouble(value));
                    default -> {
                    }
                }
            }
        }


        return student;
    }
}
