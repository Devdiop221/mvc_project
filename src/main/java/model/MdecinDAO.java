package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MdecinDAO {
	
	public static Connection getConnection(){
		Connection con=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/bd_hospital?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		}catch(Exception e){System.out.println(e);}
		return con;
		}
	
	public static int save(Medecin m){
		int status=0;
		try{
		Connection con=MdecinDAO.getConnection();
		PreparedStatement md=con.prepareStatement(
		"insert into bd_hospital.hospital(id,code,nom,prenom,grade,specialite,sexe,age) values (?,?,?,?,?,?,?,?)");
		md.setInt(1,m.getId());
		md.setString(2,m.getCode());
		md.setString(3,m.getNom());
		md.setString(4,m.getPrenom());
		md.setString(5,m.getGrade());
		md.setString(6,m.getSpecialite());
		md.setString(7,m.getSexe());
		md.setInt(8,m.getAge());
		status=md.executeUpdate();
		con.close();
		}catch(Exception ex){ex.printStackTrace();}
		return status;
		}
	
	
	public static Medecin getMedecinById(int id){
		Medecin medecin =new Medecin();
		try{
		Connection con=MdecinDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from bd_hospital.hospital where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		medecin.setId(rs.getInt(1));
		medecin.setCode(rs.getString(2));
		medecin.setNom(rs.getString(3));
		medecin.setPrenom(rs.getString(4));
		medecin.setGrade(rs.getString(5));
		medecin.setSpecialite(rs.getString(6));
		medecin.setSexe(rs.getString(7));
		medecin.setAge(rs.getInt(8));
		}
		con.close();
		}catch(Exception ex){ex.printStackTrace();}
		return medecin;
	}
	
	public static List<Medecin> getAllMedecins(){
		List<Medecin> list=new ArrayList<Medecin>();
		try{
		Connection con=MdecinDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from  bd_hospital.hospital");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
		Medecin medecin = new Medecin();
		medecin.setId(rs.getInt(1));
		medecin.setCode(rs.getString(2));
		medecin.setNom(rs.getString(3));
		medecin.setPrenom(rs.getString(4));
		medecin.setGrade(rs.getString(5));
		medecin.setSpecialite(rs.getString(6));
		medecin.setSexe(rs.getString(7));
		medecin.setAge(rs.getInt(8));
		list.add(medecin);
		}
		con.close();
		}catch(Exception e){e.printStackTrace();}
		return list;
		}
		
	
	
	

}
