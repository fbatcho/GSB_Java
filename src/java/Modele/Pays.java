package Modele;

import java.util.Collection;
import java.util.HashSet;
import Modele.Dep;
import java.util.TreeSet;

/**
 *
 * @author sio
 */
public class Pays {

    private Collection<Dep> lesDeps = new HashSet<Dep>();
    private Collection<Spe> lesSpes = new HashSet<Spe>();

    public Pays() {
        lesDeps = DAO.getLesDeps();
        lesSpes = DAO.getLesSpes();
        Collection<Med> lesMeds= new HashSet<Med>();
         lesMeds= DAO.getLesMeds();
        for (Med unMed : lesMeds) {
                for(Dep unDep : lesDeps){
                    if(unMed.getDep().equals(unDep.getNum())){
                        unDep.addMed(unMed);
                    }
                }
                for(Spe uneSpe : lesSpes){
                    if(uneSpe.getNum().equals(unMed.getSpe())){
                        uneSpe.addMed(unMed);
                    }
                }
        }
    }

    public Collection getLesDeps() {
        return this.lesDeps;
    }

    public Dep getLeDep(String numDep) {
        for (Dep d : lesDeps) {
            if (d.getNum().equals(numDep)) {
                return d;
            }
        }
        return null;
    }
    public Collection getLesSpes() {
        return this.lesSpes;
    }
    public Spe getLeSpe(String numSpe) {
        for (Spe s : lesSpes) {
            if (s.getNum().equals(numSpe)) {
                return s;
            }
        }
        return null;
    }

    public Collection<Med> getMedNom(String n) {
        Collection<Med> medn = new TreeSet<Med>();
        Collection<Dep> deps = this.getLesDeps();
        for (Dep dep : deps) {
            Collection<Med> meds = dep.getLesMeds();
            for (Med med : meds) {
                if (med.getNom().startsWith(n)) {
                    medn.add(med);
                }
            }
        }
        return medn;
    }
}
