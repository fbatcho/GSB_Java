package Controller;

import java.io.IOException;

import java.util.Collection;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modele.Dep;
import Modele.Med;
import Modele.Pays;
import Modele.Spe;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;

public class Control extends HttpServlet {

    private Pays p;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        p = new Pays();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String page = null;
        if(request.getParameter("uc") != null) {
            String uc =request.getParameter("uc");
        switch (uc) {

            case "nom" : 
                page = "nom.jsp";
                    break;
            case "departement":
                Collection<Dep> lesDeps = p.getLesDeps();
                request.setAttribute("deps", lesDeps);
                page = "departement.jsp";
                break;

            case "medecin":
               Dep d = p.getLeDep(request.getParameter("dep"));
                    Collection <Med> lesMeds = d.getLesMeds();
                    request.setAttribute("dep", d);
                    request.setAttribute("meds", lesMeds); 
               
                page = "medecin.jsp";
                break;
                case "medparnom" :
                    String n = request.getParameter("nom");
                    Collection<Med> medn = p.getMedNom(n);
                    request.setAttribute("meds", medn);
                    page = "medparnom.jsp";
                    break;
                case "specialité":
                   Collection<Spe> lesSpes = p.getLesSpes();
                request.setAttribute("spes", lesSpes);
                page = "specialite.jsp";
                
                    break;
                     case "medparspe":
               Spe s = p.getLeSpe(request.getParameter("spe"));
                    Collection <Med> lesMed = s.getLesMeds();
                    request.setAttribute("spe", s);
                    request.setAttribute("meds", lesMed); 
               
                page = "medparspe.jsp";
        }
        }
        else{
                page = "index.jsp";
                }

        request.getRequestDispatcher(page).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
