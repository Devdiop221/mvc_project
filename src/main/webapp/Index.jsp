<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription Medecin</title>
</head>
<body>
<a href="">Liste des Medecins</a> <br>

<h2>Inscription Medecin</h2>
<form method="post" action="Traitement">
		<table>
		
		<tr>
				<td>Code:</td>
				<td><input type="text" name="code"  required/></td>
			</tr>
			<tr>
				<td>Nom:</td>
				<td><input type="text" name="nom"  required/></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><input type="text" name="prenom"  required/></td>
			</tr>
			<tr>
				<td>Grade</td>
				<td><input type="text" name="grade" required/></td>
			</tr>
			<tr>
				<td>Specialite:</td>
				<td><input type="text" name="specialite"  required/></td>
			</tr>
			<tr>
				<td>Sexe:</td>
				<td><input type="text" name="sexe"  required/></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="number" name="age"  required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Valider"/></td>
		
				<td><input type="reset" value="Annuler"/></td>
			</tr>
		</table>
	</form>

</body>
</html>