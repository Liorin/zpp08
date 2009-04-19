/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import java.sql.Date;
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
public class eeNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private eeUser sender;
    @ManyToOne
    private eeNode task;
    private String content;
    private Date datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public eeUser getSender() {
        return sender;
    }

    public void setSender(eeUser sender) {
        this.sender = sender;
    }

    public eeNode getTask() {
        return task;
    }

    public void setTask(eeNode task) {
        this.task = task;
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
        if (!(object instanceof eeNote)) {
            return false;
        }
        eeNote other = (eeNote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eeserver.persistence.eeNote[id=" + id + "]";
    }

}
