/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import java.io.Serializable;

public class Row implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int quantity;
    private boolean editable;

    public Row(int id, String name, int quantity) {
	this.id = id;
	this.name = name;
	this.quantity = quantity;
    }

    // getters & setters
    // hasCode & equals

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getQuantity() {
	return quantity;
    }

    public void setQuantity(int quantity) {
	this.quantity = quantity;
    }

    public boolean isEditable() {
	return editable;
    }

    public void setEditable(boolean editable) {
	this.editable = editable;
    }

    @Override
    public int hashCode() {
	return id;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
	return "Row [id=" + id + ", name=" + name + ", quantity=" + quantity + ", editable=" + editable + "]";
    }
}