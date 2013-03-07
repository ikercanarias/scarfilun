package com.scarfilun.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PERM_ACTIONS")
public class PermissionActionEntity extends AbstractEntity{

    private String name;
    private Integer mask;

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "MASK", nullable = false)
    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    @Override
    public String toString() {
        return "PermissionActionEntity{" +
                "name='" + name + '\'' +
                ", mask=" + mask +
                '}';
    }
}
