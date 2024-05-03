package com.jhons.proyectoFinalviernes.service;

import com.jhons.proyectoFinalviernes.entity.Producto;
import com.jhons.proyectoFinalviernes.repository.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepo repository;
    public List<Producto> listAll() {
        return repository.findAll();
    }
    //metodo para guardar
    public Producto save(Producto producto) {
        Producto nuevoProducto = repository.save(producto);
        return nuevoProducto;
    }
    //metodo pra obtener producto
    public Producto get(Long id) {
        return repository.findById(id).get();
    }
    public void delete(Long id){
        repository.deleteById(id);
    }


}
