package service;

import java.util.ArrayList;

import repository.StudentData;

public class StudentService implements StudentInterface{

    @Override
    public void createStudent(String[] data) {
        StudentData getdata=new StudentData();
        getdata.writeData(data);
    }

    @Override
    public ArrayList<String> readAllStudentData() {
        StudentData readData=new StudentData();
        return readData.readAllStudentData();
    }

    @Override
    public String readIndividualStudentData(Integer ID) {
        StudentData readIndividual=new StudentData();
        return readIndividual.readIndividualData(ID);
    }

    @Override
    public void updateStudentData(String[] data) {
        StudentData updatedata=new StudentData();
        updatedata.updateData(data);

    }

    @Override
    public void deleteStudentData(String[] data) {
        StudentData delete=new StudentData();
        delete.deleteDataFile();
    }



}
