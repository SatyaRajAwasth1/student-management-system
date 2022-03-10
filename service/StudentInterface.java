package service;

import java.util.ArrayList;

public interface StudentInterface {
    public void createStudent(String [] data);
    public ArrayList<String> readAllStudentData();
    public String readIndividualStudentData(Integer ID);
    public void updateStudentData(String [] data);
    public void deleteStudentData(String [] data);
}