/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eeserver.persistence;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import java.sql.Date;
/**
 *
 * @author maciek
 */
@Entity
public class eeNode extends eeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Constants
     */
    private static final int InProgress = 1;
    private static final int Opened = 2;
    private static final int Closed = 3;
    private static final int Assigned = 4;

    private Integer priority;
    private Integer type;
    private Date timelimit;
    @OneToMany(mappedBy = "node", fetch = FetchType.LAZY)
    private Collection<eeStatusHistory> status;
    @ManyToOne(optional = true)
    private eeProject project;
    @ManyToOne
    private eeUser creator;
    @ManyToOne
    private eeEntity parent;
    private Integer currentStatus;
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    private List<eeNote> notes = new ArrayList<eeNote>();
    @OneToMany(mappedBy = "concern", fetch = FetchType.LAZY)
    private List<eeReport> reports = new ArrayList<eeReport>();
    @ManyToMany
    @JoinTable(
               name="relations",
               joinColumns=
                       @JoinColumn(name="after_id", referencedColumnName="id"),
               inverseJoinColumns=
                       @JoinColumn(name="before_id", referencedColumnName="id")
    )
    private List<eeNode> comesAfter = new ArrayList<eeNode>();

    @ManyToMany(mappedBy="comesAfter")
    private List<eeNode> comesBefore = new ArrayList<eeNode>();

    public eeNode() {
    }

    public eeNode(eeEntity parent, Integer priority, Date timelimit,
            Integer type, Integer taskType, Integer currentStatus) {
        this.priority = priority;
        this.parent = parent;
        this.timelimit = timelimit;
        this.taskType = taskType;
        this.type = type;
        this.currentStatus = currentStatus;
    }

    public List<eeNode> getComesAfter() {
        return comesAfter;
    }

    public void setComesAfter(List<eeNode> comesAfter) {
        this.comesAfter = comesAfter;
    }

    public eeUser getCreator() {
        return creator;
    }

    public void setCreator(eeUser creator) {
        this.creator = creator;
    }

    public List<eeNode> getComeAfter() {
        return comesAfter;
    }

    public void setComeAfter(List<eeNode> comeAfter) {
        this.comesAfter = comeAfter;
    }

    public List<eeNode> getComesBefore() {
        return comesBefore;
    }

    public void setComesBefore(List<eeNode> comesBefore) {
        this.comesBefore = comesBefore;
    }

    public Integer getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<eeNote> getNotes() {
        return notes;
    }

    public void setNotes(List<eeNote> notes) {
        this.notes = notes;
    }

    public eeProject getProject() {
        return project;
    }

    public void setProject(eeProject project) {
        this.project = project;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Collection<eeStatusHistory> getStatus() {
        return status;
    }

    public void setStatus(Collection<eeStatusHistory> status) {
        this.status = status;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }



    public Date getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(Date timelimit) {
        this.timelimit = timelimit;
    }

    public List<eeReport> getReports() {
        return reports;
    }

    public void setReports(List<eeReport> reports) {
        this.reports = reports;
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
        if (!(object instanceof eeNode)) {
            return false;
        }
        eeNode other = (eeNode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eeserver.persistence.eeNode[id=" + id + "]";
    }
}