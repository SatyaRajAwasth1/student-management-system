package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class StudentData {
    File file;
    FileWriter writeFile;
    FileReader readFile;
    BufferedWriter bfrWriteFile;
    BufferedReader bfrReadFile;

    public void writeData(String[] data) {

        try {
            file=new File("student-data.txt");
            if(file.createNewFile()) {

                System.out.println("new file 'student-data.txt' created succesfully");
            }else {

                System.out.println("task being done in existing file student-data.txt");
            }

            writeFile=new FileWriter(file,true);
            bfrWriteFile=new BufferedWriter(writeFile);
            String tempData=stringConverter(data);
            bfrWriteFile.write(tempData);
            bfrWriteFile.close();


        }catch(Exception e){

            System.out.println("Couldn't write file , something wrong happened "+e);
        }
    }

    String stringConverter(String[] data) {
        return data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+"\n";
    }

    public ArrayList<String> readAllStudentData() {
        ArrayList<String> data=new ArrayList<String>();
        try {
            file=new File("student-data.txt");
            readFile=new FileReader(file);
            bfrReadFile=new BufferedReader(readFile);
            String tempData=" ";
            while((tempData=bfrReadFile.readLine())!=null) {

                data.add(tempData);
            }
            return data;
        }catch(Exception e) {

            System.out.println("Error during reading file");
            return null;
        }

    }


    public String readIndividualData(Integer ID) {
        try {
            file=new File("studen-data.txt");
            readFile=new FileReader(file);
            bfrReadFile=new BufferedReader(readFile);
            String tempData=" ";
            while((tempData=bfrReadFile.readLine())!=null) {
                String [] splitData=tempData.split(",");
                if(splitData[0]==ID.toString()||splitData[0].equals(ID.toString())) {
                    return tempData;
                }
            }
            return null;
        }catch(Exception e) {

            System.out.println("something wrong happened, cannot read file");
            return null;
        }
    }
    public void updateData(String[] data) {

        String userdata=readIndividualData(Integer.valueOf(data[0]));
        if(userdata.length()==0) {

            System.out.println("User not found for user ID");
            return;
        }
        String [] userDetailData=userdata.split(",");
        userDetailData[1]=data[1];
        userDetailData[2]=data[2];
        userDetailData[3]=data[3];
        writeData(userDetailData);
    }
    public void deleteDataFile() {

        try {

            file=new File("student-data.txt");
            if(file.delete()) {

                System.out.println("student-data.txt deleted..");
            }else {
                System.out.println("file still exists");
            }

        }catch(Exception e){

            System.out.println("something else happened, can't delete file");
        }
    }





}