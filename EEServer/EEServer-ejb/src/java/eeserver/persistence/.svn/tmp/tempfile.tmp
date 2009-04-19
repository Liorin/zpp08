/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
/**
 *
 * @author maciek
 */
@Entity
@NamedQueries({
@NamedQuery(
    name = "findUserByLogin",
    query = "SELECT u FROM eeUser u WHERE u.login = :login"
)})
public class eeUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String email;
    private String adress;
    private String nip;
    private Long password;
    @OneToOne(mappedBy="owner")
    private eeAccount account;
    @OneToMany(mappedBy="whoEstimated", fetch = FetchType.LAZY)
    private List<eeAssessment> assessments = new ArrayList<eeAssessment>();
    @OneToMany(mappedBy="sender", fetch = FetchType.LAZY)
    private List<eeNote> notes = new ArrayList<eeNote>();
    @OneToMany(mappedBy="whoReported", fetch = FetchType.LAZY)
    private List<eeReport> reports = new ArrayList<eeReport>();
    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
    private List<eeNode> nodes = new ArrayList<eeNode>();
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<eeResponsibility> responsibilities = new ArrayList<eeResponsibility>();

    public eeUser() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public eeUser(String name, String surname, String login, String email, String adress, String nip, Long password, eeAccount account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.adress = adress;
        this.nip = nip;
        this.password = password;
        this.account = account;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public eeAccount getAccount() {
        return account;
    }

    public void setAccount(eeAccount account) {
        this.account = account;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public List<eeResponsibility> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<eeResponsibility> responsibilities) {
        this.responsibilities = responsibilities;
    }
    
    public List<eeAssessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<eeAssessment> assessments) {
        this.assessments = assessments;
    }

    public List<eeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<eeNode> nodes) {
        this.nodes = nodes;
    }

    public List<eeNote> getNotes() {
        return notes;
    }

    public void setNotes(List<eeNote> notes) {
        this.notes = notes;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public List<eeReport> getReports() {
        return reports;
    }

    public void setReports(List<eeReport> reports) {
        this.reports = reports;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void addNode(eeNode node) {
        if(!this.getNodes().contains(node)) {
            this.getNodes().add(node);
        }
    }

    public void addReport(eeReport report) {
        if (!this.getReports().contains(report)) {
            this.getReports().add(report);
        }

    }

    public void addNote(eeNote note) {
        if (!this.getNotes().contains(note)) {
            this.getNotes().add(note);
        }
    }

    public void addAssessment(eeAssessment assessment) {
        if (!this.getAssessments().contains(assessment)) {
            this.getAssessments().add(assessment);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof eeUser)) {
            return false;
        }
        eeUser other = (eeUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eeserver.persistence.eeUser[id=" + id + "]";
    }

}
