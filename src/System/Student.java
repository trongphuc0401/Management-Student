package System;

public class Student extends Human {

    private String idStudent;
    private String college;
    private Integer course;
    private Double average;
    private RankedAcademic rankedAcademic;
    private double gradePercentage;

    public Student() {

    }

    public Student(int id, String name, String date, String address, Double height, double weight, String idStudent, String college, Integer course, double average) throws Exception {
        super(id, name, date, address, height, weight);
        this.idStudent = idStudent;
        this.college = college;
        this.course = course;
        this.average = average;
    }

    /* Ranked Academic */
    public RankedAcademic getRankedAcademic() {
        Double score = this.getAverage();
        if (score < 3) {
            return RankedAcademic.POOR;
        } else if (score < 5) {
            return RankedAcademic.WEAK;
        } else if (score < 6.5) {
            return RankedAcademic.AVERAGE;
        } else if (score < 7.5) {
            return RankedAcademic.GOOD;
        } else if (score < 9) {
            return RankedAcademic.VERY_GOOD;
        } else {
            return RankedAcademic.EXCELLENT;
        }

    }


    public void setRankedAcademic() {
        RankedAcademic rankedAcademic = getRankedAcademic();
        this.rankedAcademic = rankedAcademic;
    }

    public void setGradePercentage(double gradePercentage) {
        this.gradePercentage = gradePercentage;
    }

    public double getGradePercentage() {
        return gradePercentage;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }


    @Override
    public String toString() {
        return
                "idStudent=" + idStudent +
                        ", college=" + college +
                        ", course=" + course +
                        ", average=" + average +
                        ", rankedAcademic=" + getRankedAcademic() +", "+
                        super.toString();
    }
}
