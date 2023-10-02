package System;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Controller {

    private static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Student> studentData = new ArrayList<>();


    /*Condition*/
    public static final Integer MAX_ID_LENGHT = 10;
    public static final Integer MIN_ID_MIN = 1;
    public static final Integer MAX_COLLEGE_LENGHT = 200;
    public static final Integer MIN_DATE_ATTEND = 1900;
    public static final double MAX_AVERAGE_POINT = 10;
    public static final Integer MIN_AVERAGE_POINT = 1;
    public static final Integer MAX_NAME_LENGHT = 100;
    public static final String MIN_DATE_HUMAN = "1900";
    public static final Integer MAX_ADDRESS_LENGHT = 300;
    public static final Double MAX_HEIGHT = 300.0;
    public static final Double MIN_HEIGHT = 50.0;
    public static final Double MAX_WEIGHT = 1000.0;
    public static final Double MIN_WEIGHT = 5.0;
    public static final Double MAX_GRADE = 100.0;
    private static final AtomicInteger count = new AtomicInteger(0);

    public Controller() {

    }

    /*Method of Validate*/
    private static boolean validateName(String name) {
        if (name.length() < MAX_NAME_LENGHT && name.length() > 0) {
            return true;
        }
        System.out.println("Name must be not null and less than " + MAX_NAME_LENGHT + " characters !!");
        return inputNameStudent() == null;
    }

    private static boolean validateDate(String date) throws Exception {
        if (date == null || date.matches(MIN_DATE_HUMAN)) {
            System.out.println("Date must be not null and after " + MIN_DATE_HUMAN);
        }
        return true;
    }

    private static boolean validateAddress(String address) {
        if (address.length() > 0 && address.length() < MAX_ADDRESS_LENGHT) {
            return true;

        }
        System.out.println("Address must be less than " + MAX_ADDRESS_LENGHT + " characters");
        return inputAdress() == null;
    }

    private static boolean validateHeight(double height) throws Exception {
        if (height > MIN_HEIGHT && height < MAX_HEIGHT) {
            return true;

        }
        System.out.println("Height must be between " + MIN_HEIGHT + " and " + MAX_HEIGHT + " centimeters");
        return inputHeight() == null;

    }

    private static boolean validateWeight(double weight) throws Exception {
        if (weight > MIN_WEIGHT && weight < MAX_WEIGHT) {
            return true;

        }
        System.out.println("Weight must be between " + MIN_WEIGHT + " and " + MAX_WEIGHT + " kg");
        return inputWeight() == null;

    }

    public static boolean validateID(String idStudent) {
        if (idStudent.length() >= MIN_ID_MIN && idStudent.length() <= MAX_ID_LENGHT) {

            return true;
        }
        System.out.println("ID student must be not null and less than 10 character");
        return inputIdStudent() == null;

    }

    public static boolean validateCollege(String college) {
        if (college.length() > 0 && college.length() < MAX_COLLEGE_LENGHT) {
            return true;

        }
        System.out.println("College must be not null and less than 200 character");
        return inputCollege() == null;

    }

    public static boolean validateCourse(Integer course) throws Exception {
        if (course > 0 && course > MIN_DATE_ATTEND) {
            return true;

        }
        System.out.println("Course must be start from 1990 and not null");
        return inputCourse() == null;

    }

    public static boolean validateAverage(Double average) throws Exception {
        if (average >= MIN_AVERAGE_POINT && average <= MAX_AVERAGE_POINT) {
            return true;

        }
        System.out.println("Average must be run from 0  to 10 point");
        return inputAverage() == null;

    }

    /*Method of Create*/
    public static void add() throws Exception {
        int id =count.incrementAndGet() ;
        String name = inputNameStudent();
        String date = inputDate();
        String address = inputAdress();
        Double height = inputHeight();
        Double weight = inputWeight();
        String idStudent = inputIdStudent();
        String college = inputCollege();
        int course = inputCourse();
        Double average = inputAverage();
        studentData.add(new Student(id, name, date, address, height, weight, idStudent, college, course, average));
        ReadAndWrite.write(studentData);
    }

    /*Method of Search*/

    public static void search() {
        System.out.println("Enter Student ID to search: ");
        String searchID = scanner.next();
        for (Student theStudent : studentData) {
            if (Objects.equals(theStudent.getIdStudent(), searchID) || Objects.equals(theStudent.getName(), searchID) ) {
                System.out.println("Student Found:");
                System.out.println("Student " + theStudent.getId() + ":");
                System.out.print("ID : " + theStudent.getIdStudent() + " | ");
                System.out.print("Name: " + theStudent.getName() + " | ");
                System.out.print("Date: " + theStudent.getDate() + " | ");
                System.out.print("Address: " + theStudent.getAddress() + " | ");
                System.out.print("Height: " + theStudent.getHeight() + " | ");
                System.out.print("Weight: " + theStudent.getWeight() + " | ");
                System.out.print("College: " + theStudent.getCollege() + " | ");
                System.out.print("Course: " + theStudent.getCourse() + " | ");
                System.out.print("Average: " + theStudent.getAverage() + " | ");
                System.out.print("Ranked Academic: " + theStudent.getRankedAcademic() + " | ");
                System.out.println();
                scanner.nextLine();
                return;
            }
        }
        System.out.println("Student ID not found.");

    }


    /*Method of Edit*/
    public void edit() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to edit: ");
        String id = scanner.nextLine();
        Student student = null;
        int index = -1;
        for (int i = 0; i < studentData.size(); i++) {
            if (studentData.get(i).getIdStudent().equals(id)) {
                student = studentData.get(i);
                index = i;
                break;
            }
        }
        if (student == null) {
            System.out.println("Student ID not found.");
            return;
        }
        System.out.println("Enter new student information:");
        String name = inputNameStudent();
        String date = inputDate();
        String address = inputAdress();
        Double height = inputHeight();
        Double weight = inputWeight();
        String college = inputCollege();
        int course = inputCourse();
        Double average = inputAverage();
        scanner.nextLine();
        student.setName(name);
        student.setDate(date);
        student.setAddress(address);
        student.setHeight(height);
        student.setWeight(weight);
        student.setCollege(college);
        student.setCourse(course);
        student.setAverage(average);
        student.setRankedAcademic();
        studentData.set(index, student);
        System.out.println("Student information updated:");
        showStudent();
    }

    /*Method of Detele*/
    public static void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        Student student = null;
        int index = -1;
        for (int i = 0; i < studentData.size(); i++) {
            if (studentData.get(i).getIdStudent().equals(id)) {
                student = studentData.get(i);
                index = i;
                break;
            }
        }
        if (student == null) {
            System.out.println("Student ID not found.");
            return;
        }
        studentData.remove(index);
        showStudent();
    }

    //
    public static void displayGradePercentage() {

        for (Student student : studentData) {

            double gradePercentage = (student.getAverage() / MAX_GRADE) * 100;
            student.setGradePercentage(gradePercentage);
        }

//        studentData.sort(new Comparator<>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return Double.compare(s2.getGradePercentage(), s1.getGradePercentage());
//            }
//        });

        int countSum = studentData.size();
        System.out.println("Students: " + countSum);
        int[] countByRankedAcademic = new int[RankedAcademic.values().length];
        for (Student student : studentData) {
            RankedAcademic academic = getRankedAcademic(student.getGradePercentage());
            countByRankedAcademic[academic.ordinal()]++;
        }


        for (RankedAcademic academic : RankedAcademic.values()) {
            int count = countByRankedAcademic[academic.ordinal()];
            double percentage = (double) count / studentData.size() * 100;
            System.out.println(academic + ": " + percentage + "% (" + count + " students)");
        }
    }

    private static RankedAcademic getRankedAcademic(double percentage) {
        if (percentage < 3) {
            return RankedAcademic.POOR;
        } else if (percentage < 5) {
            return RankedAcademic.WEAK;
        } else if (percentage < 6.5) {
            return RankedAcademic.AVERAGE;
        } else if (percentage < 7.5) {
            return RankedAcademic.GOOD;
        } else if (percentage < 9) {
            return RankedAcademic.VERY_GOOD;
        } else {
            return RankedAcademic.EXCELLENT;
        }
    }
    public static void displayAveragePercentage() {
        Map<Double, Integer> scoreMap = new HashMap<>();
        int totalStudent = studentData.size();
        for(Student score:studentData) {
            scoreMap.put(score.getAverage(),scoreMap.getOrDefault(score.getAverage(),0)+1);
        }
 
        for (Map.Entry<Double, Integer> entry:scoreMap.entrySet()) {
            Double score = entry.getKey();

            int count = entry.getValue();
            double percentage  =(count*100.0)/totalStudent;
            System.out.println( score+" : "+ count+" : "+percentage+" %" );
        }

    }


public static void showStudent() {
    for (Student theStudent : studentData) {
        System.out.println("\nStudent " + theStudent.getId() + ":");
        System.out.print("ID : " + theStudent.getIdStudent() + " | ");
        System.out.print("Name: " + theStudent.getName() + " | ");
        System.out.print("Date: " + theStudent.getDate() + " | ");
        System.out.print("Address: " + theStudent.getAddress() + " | ");
        System.out.print("Height: " + theStudent.getHeight() + " | ");
        System.out.print("Weight: " + theStudent.getWeight() + " | ");
        System.out.print("College: " + theStudent.getCollege() + " | ");
        System.out.print("Course: " + theStudent.getCourse() + " | ");
        System.out.print("Average: " + theStudent.getAverage() + " | ");
        System.out.print("Ranked Academic: " + theStudent.getRankedAcademic() + " | ");
        System.out.println();
    }
}

    /*Method of Input*/


    private static String inputNameStudent() {
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        validateName(name);
        return name;
    }

    private static String inputDate() throws Exception {
        System.out.println("Please enter your birthday (dd/MM/yyyy): ");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = scanner.nextLine();

        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            if (!validateDate(date)) {
                return inputDate();
            }
        } catch (ParseException ex) {
            System.out.println("Invalid date format. Date should be in the format dd/MM/yyyy.");
            return inputDate();
        }
        return date;
    }


    private static String inputAdress() {
        System.out.println("Please enter your address: ");
        String address = scanner.nextLine();
        validateAddress(address);
        return address;
    }

    private static Double inputHeight() throws Exception {
        System.out.println("Please enter your Height (cm): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.print("Invalid! Height cannot be empty. ");
            return inputHeight();
        }
        try {
            Double height = Double.parseDouble(input);
            validateHeight(height);
            return height;
        } catch (NumberFormatException ex) {
            System.out.print("Invalid! Enter Height again: ");
            return inputHeight();
        }

    }


    private static Double inputWeight() throws Exception {
        System.out.println("Please enter your Weight (kg): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.print("Invalid! Weight cannot be empty. ");
            return inputWeight();
        }

        try {
            Double weight = Double.parseDouble(input);
            validateWeight(weight);
            return weight;

        } catch (NumberFormatException ex) {
            System.out.print("Invalid! Enter Weight again: ");
            return inputWeight();
        }

    }


    private static String inputIdStudent() {
        System.out.println("Please enter ID: ");
        String idStudent = scanner.nextLine();
        if (idStudent.isEmpty()) {
            System.out.println("Invalid! ID cannot be empty.");
            return inputIdStudent();
        }
        try {
            validateID(idStudent);
            return idStudent;
        } catch (Exception ex) {
            System.out.println("Invalid! Enter ID again.");
            return inputIdStudent();
        }

    }


    private static String inputCollege() {
        System.out.println("Please enter your college: ");
        String college = scanner.nextLine();
        if (college.isEmpty()) {
            System.out.println("Invalid! College cannot be empty.");
            return inputCollege();
        }
        try {
            validateCollege(college);
            return college;
        } catch (Exception ex) {
            System.out.println("Invalid! Enter College again. ");
            return inputCollege();
        }

    }

    private static Integer inputCourse() throws Exception {
        System.out.println("Please enter your course (2021): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.print("Invalid! Course cannot be empty. ");
            return inputCourse();
        }
        try {
            Integer course = Integer.parseInt(input);
            validateCourse(course);
            return course;
        } catch (NumberFormatException ex) {
            System.out.print("Invalid! Enter  Course again: ");
            return inputCourse();
        }
    }


    private static Double inputAverage() throws Exception {
        System.out.println("Please enter your average point: ");
        Double average = Double.parseDouble(scanner.nextLine());
        try {
            validateAverage(average);
            return average;
        } catch (NumberFormatException ex) {
            System.out.print("Invalid! Enter average point again: ");
            return inputAverage();
        }


    }
}
