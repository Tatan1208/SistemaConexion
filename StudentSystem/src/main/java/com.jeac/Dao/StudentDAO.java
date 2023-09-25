package com.jeac.Dao;
import java.util.List;
import java.util.ArrayList;
import java.util.ResultSet;
import java.sql.Connection;


public class StudentDAO{
    public List <Student>(){
        List<Student> students = new ArrayList<>();

        PreparedStatement ps; //Encapsula la conexion
        ResultSet rs;//guarda la conexion
        Connection con = getConnection;
        String sql = "SELECT * FROM students  ORDER BY id_students";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));

            }

        }catch (Exception ex){
            System.out.println("Syntax Error" + ex.getMessage() );
        }finally {
            con.close();
        }

        return students;
    }
}