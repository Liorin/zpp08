/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author maciek
 */
@Entity
public class eeAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private eeUser owner;
    @OneToMany(fetch = FetchType.LAZY)
    private List<eeProject> projects = new ArrayList<eeProject>();

    public eeAccount() {
    }

    public eeAccount(eeAccount account) {
        this.id = account.getId();
        this.owner = null;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public eeUser getOwner() {
        return owner;
    }

    public void setOwner(eeUser owner) {
        this.owner = owner;
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
        if (!(object instanceof eeAccount)) {
            return false;
        }
        eeAccount other = (eeAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eeserver.persistence.eeAccount[id=" + id + "]";
    }

}
