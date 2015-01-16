/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author sio
 */
public class Spe implements Comparable<Spe> {

    private String num;
    private Collection<Med> lesMeds = new TreeSet<Med>();

    public Spe(String num, Collection lesMeds) {
        this.num = num;
        this.lesMeds = lesMeds;
    }

    public String getNum() {
        return this.num;
    }

    public Collection<Med> getLesMeds() {
        return lesMeds;
    }

    public void addMed(Med m) {
        lesMeds.add(m);
    }

    @Override
    public int compareTo(Spe s) {
        return num.compareTo(s.num);

    }

}
