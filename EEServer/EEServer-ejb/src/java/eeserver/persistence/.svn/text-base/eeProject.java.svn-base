/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author maciek
 */
@Entity
@NamedQueries({
@NamedQuery(
    name = "findAllProjects",
    query = "SELECT proj FROM eeProject proj"
),
@NamedQuery(
    name = "findAllNotSuspended",
    query = "SELECT proj FROM eeProject proj WHERE proj.suspended=false"
)})
public class eeProject extends eeEntity implements  Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne(fetch = FetchType.EAGER)
    private eeAccount account;
    private Boolean suspended;
    private String name;
    private String description;
    private Date deadline;

    public eeProject(eeProject project) {
        this.name = project.getName();
        this.description = project.getDescription();
        this.deadline = project.getDeadline();
        this.account = new eeAccount(project.getAccount());
    }

    public eeProject() {
    }

    public eeAccount getAccount() {
        return account;
    }

    public void setAccount(eeAccount account) {
        this.account = account;
    }

    public void removeNode(eeNode node) {
        getChild().remove(node);
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public eeProject(eeAccount account, String name, String description) {
        this.account = account;
        this.name = name;
        this.description = description;
    }

    public eeProject(eeAccount account) {
        this.account = account;
        this.suspended = false;
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
        if (!(object instanceof eeProject)) {
            return false;
        }
        eeProject other = (eeProject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eeserver.persistence.eeProject[id=" + id + "]";
    }
}
