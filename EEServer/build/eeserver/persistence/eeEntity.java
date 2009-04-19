/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author maciek
 */
@Entity
public abstract class eeEntity implements Serializable {
    /**
     *  Node Types
     */
    public static final int Task = 1;
    public static final int Functionality = 2;
    public static final int SubTask = 3;
    public static final int Project = 4;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @OneToMany(mappedBy = "parent")
    protected List<eeNode> child;
    protected Integer taskType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<eeNode> getChild() {
        return child;
    }

    public void setChild(List<eeNode> child) {
        this.child = child;
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
        if (!(object instanceof eeEntity)) {
            return false;
        }
        eeEntity other = (eeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eeserver.persistence.eeEntity[id=" + id + "]";
    }

}
