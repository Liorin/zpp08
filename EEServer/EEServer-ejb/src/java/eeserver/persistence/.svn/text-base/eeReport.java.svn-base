/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author maciek
 */
@Entity
public class eeReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private eeUser whoReported;
    @ManyToOne
    private eeEntity concern;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public eeEntity getConcern() {
        return concern;
    }

    public void setConcern(eeEntity concern) {
        this.concern = concern;
    }

    public eeUser getWhoReported() {
        return whoReported;
    }

    public void setWhoReported(eeUser whoReported) {
        this.whoReported = whoReported;
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
        if (!(object instanceof eeReport)) {
            return false;
        }
        eeReport other = (eeReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eeserver.persistence.eeReport[id=" + id + "]";
    }

}
