/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import java.util.*;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author maciek
 */
@Entity
@NamedQueries({
@NamedQuery(
    name = "findAllProjects",
    query = "SELECT proj FROM eeProject proj"
)})
public class eeProject extends eeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne(fetch = FetchType.EAGER)
    eeAccount account;

    public eeAccount getAccount() {
        return account;
    }

    public void setAccount(eeAccount account) {
        this.account = account;
    }

    public void removeNode(eeNode node) {
        getChild().remove(node);
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
