package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    public static Collection<Dep> getLesDeps() {
        try {
            Connection con;
            java.sql.Statement req;

            con = Connect.get();

            req = con.createStatement();
            ResultSet rs = req.executeQuery("SELECT DISTINCT departement FROM medecin");
            Collection<Dep> lesDeps = new TreeSet<Dep>();

            while (rs.next()) {

                Collection<Med> lesMeds = new TreeSet<Med>();

                Dep d = new Dep(rs.getString("departement"), lesMeds);
                lesDeps.add(d);
            }
            rs.close();
            req.close();
            return lesDeps;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static Collection<Spe> getLesSpes() {
        try {
            Connection con;
            java.sql.Statement req;
            con = Connect.get();

            req = con.createStatement();
            ResultSet rs = req.executeQuery("SELECT DISTINCT specialiteComplementaire FROM medecin");
            Collection<Spe> lesSpes = new TreeSet<Spe>();
            while (rs.next()) {
                if (rs.getString("specialiteComplementaire") != null) {

                    Collection<Med> lesMeds = new TreeSet<Med>();
                    Spe s = new Spe(rs.getString("specialiteComplementaire"), lesMeds);
                    lesSpes.add(s);
                }

            }
            rs.close();
            req.close();
            return lesSpes;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static Collection<Med> getLesMeds() {
        try {
            Connection con;
            java.sql.Statement req;
            con = Connect.get();

            req = con.createStatement();
            ResultSet rs = req.executeQuery("SELECT * FROM medecin");
            Collection<Med> lesMeds = new TreeSet<Med>();
            while (rs.next()) {
                Med m = new Med(rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"),
                        rs.getString("tel"), rs.getString("specialiteComplementaire"), 
                        rs.getString("id"), rs.getString("departement"));
                lesMeds.add(m);

            }
            rs.close();
            req.close();
            return lesMeds;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
