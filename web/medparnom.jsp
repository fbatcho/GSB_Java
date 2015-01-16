<%-- 
    Document   : departement
    Created on : 17 nov. 2014, 10:30:05
    Author     : sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./styles/styles.css" rel="stylesheet" type="text/css" />
    <link rel="shortcut icon" type="image/x-icon" href="./images/favicon.ico" />
        <title>NOMDUMED</title>
    </head>
    <body>
        <div id="page">
        <div id="entete">
<img src="./images/logo.jpg" id="logoGSB" alt="Laboratoire Galaxy-Swiss Bourdin" title="Laboratoire Galaxy-Swiss Bourdin" />
<h1>    Suivie des Médecinns</h1>
        </div>
        
        <div id="menuGauche">
     <div id="infosUtil">
     </div>
            <ul id="menuList">
         <li>Rechercher les medecins:<br></li>
      
            <li class="smenu"><a href="Control?uc=departement">Par département</a></li>
        <li class="smenu"><a href="Control?uc=specialite">Par spécialité</a></li>
        <li class="smenu"><a href="Control?uc=nom">Par nom</a></li>
        </ul>
       
     </div>
        <div id="contenu">
            <div class="encadre">
        
        <table class="listeLegere">
        
        <th>Nom</th>
            <th>Prénom</th>
            <th>Adresse</th>
            <th>spécialité</th>
            <th>Telephone</th>
        <c:forEach var="med" items="${meds}">
            <tr ><td>${med.nom}</td>
                <td>${med.prenom}</td> 
           <td> ${med.adresse}</td>
            
            <td> ${med.spe}</td>
             <td>${med.tel}</td>
            </tr>
        </c:forEach>
        </table>
            </div>   
    
    </body>
</html>