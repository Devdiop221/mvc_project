package model.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MdecinDAO;
import model.Medecin;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Traitement
 */
public class Traitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Traitement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Medecin medecin = new Medecin();
		String code, nom , prenom, grade, specialite, sexe;
		int age;
		code = request.getParameter("code");
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		grade = request.getParameter("grade");
		specialite = request.getParameter("specialite");
		sexe = request.getParameter("sexe");
		age = Integer.parseInt(request.getParameter("age"));
		PrintWriter out=response.getWriter();
		
		
		medecin.setCode(code);
		medecin.setNom(nom);
		medecin.setPrenom(prenom);
		medecin.setGrade(grade);
		medecin.setSpecialite(specialite);
		medecin.setSexe(sexe);
		medecin.setAge(age);
		
		int status=MdecinDAO.save(medecin);
		if(status>0){
		out.print("<p>Record saved successfully!</p>");
		request.getRequestDispatcher("index.html").include(request, response);
		}else{
		out.println("Sorry! unable to save record");
		}
		out.close();
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
