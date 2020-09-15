import java.io.*;
import java.util.ArrayList;

public class Ahmad_StudentRecord {
    public static  void main(String[] args) throws IOException {
        // Creating the file in the specified path
        File file = new File("C:\\Users\\Ahmadee\\IdeaProjects\\Amad_StudentRecord\\record.csv");

        ArrayList<StudentRecord> studRec = new ArrayList<>();
        studRec.add(new StudentRecord((byte) 1, "Abubakar", "U13CO1006", 4.6));
        studRec.add(new StudentRecord((byte) 2, "Hamza", "U15CO1083", 3.6));
        studRec.add(new StudentRecord((byte) 3, "Akinwumi", "U14EE2013", 4.0));


        FileWriter fileWriter = new FileWriter(file);
        fileWriter.append("id, name, GPA, matricNumber\n");
        for(StudentRecord std: studRec){
            fileWriter.append(String.valueOf(std.getId()));
            fileWriter.append(",");
            fileWriter.append(std.getName());
            fileWriter.append(",");
            fileWriter.append(String.valueOf(std.getGPA()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(std.getMatricNumber()));
            fileWriter.append("\n");
        }
        fileWriter.flush();
        fileWriter.close();

    }
}


// class to be serialize
class StudentRecord implements Serializable{
    int id;
    String name, matricNumber;
    double GPA;

    public StudentRecord(int id, String name, String matricNumber, double GPA){
        this.id = id;
        this.name = name;
        this.matricNumber = matricNumber;
        this.GPA = GPA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}