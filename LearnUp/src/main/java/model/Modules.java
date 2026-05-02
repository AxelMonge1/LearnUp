/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author axelm
 */
public class Modules {
    private String moduleTitle;
    private Integer durationMinutes;
    private List<Resources> resources;

    public Modules() {
    }

    public Modules(String moduleTitle, Integer durationMinutes, List<Resources> resources) {
        this.moduleTitle = moduleTitle;
        this.durationMinutes = durationMinutes;
        this.resources = resources;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public List<Resources> getResources() {
        return resources;
    }
}
