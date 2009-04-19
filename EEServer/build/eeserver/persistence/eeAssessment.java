/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
/**
 *
 * @author maciek
 */
@Entity
public class eeAssessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private eeUser whoEstimated;
    @ManyToOne
    private eeNode what;
    private Date datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public eeNode getWhat() {
        return what;
    }

    public void setWhat(eeNode what) {
        this.what = what;
    }

    public eeUser getWhoEstimated() {
        return whoEstimated;
    }

    public void setWhoEstimated(eeUser whoEstimated) {
        this.whoEstimated = whoEstimated;
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
        if (!(object instanceof eeAssessment)) {
            return false;
        }
        eeAssessment other = (eeAssessment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eeserver.persistence.eeAssessment[id=" + id + "]";
    }

}
