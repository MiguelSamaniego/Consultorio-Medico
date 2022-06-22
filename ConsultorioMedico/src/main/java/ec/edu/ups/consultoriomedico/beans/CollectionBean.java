/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class CollectionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Set<Row> list = new HashSet<Row>();
    private int id;
    private String name;
    private int quantity;

    public CollectionBean() {
	this.list.add(new Row(1, "Uno", 1));
	this.list.add(new Row(2, "Dos", 2));
	this.list.add(new Row(3, "Tres", 3));
	this.list.add(new Row(4, "Cuatro", 4));
	this.list.add(new Row(5, "Cinco", 5));
    }

    public String add() {
        System.out.println("prueba de ROw");
	//this.list.add(new Row(id, name, quantity));
	return null;
    }

    public String delete(Row t) {
	this.list.remove(t);
	return null;
    }

    public String edit(Row t) {
	t.setEditable(true);
	return null;
    }

    public String save(Row t) {
	t.setEditable(false);
	return null;
    }

    public Row[] getList() {
	return list.toArray(new Row[0]);
    }

    public void setList(Set<Row> list) {
	this.list = list;
    }

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
}