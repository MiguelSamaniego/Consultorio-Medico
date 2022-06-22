/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.consultoriomedico.beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author pcuser
 */
//public class BasicView implements Serializable {
@Named//("dtBasicView")
@ViewScoped
public class BasicView {

    private List<Product> products;

    @Inject
    private ProductService service;

    @PostConstruct
    public void init() {
        products = service.getProducts(10);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ProductService service) {
        this.service = service;
    }
    
    
}
//}
