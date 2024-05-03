package com.jhons.proyectoFinalviernes.controller;

import com.jhons.proyectoFinalviernes.entity.Producto;
import com.jhons.proyectoFinalviernes.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @RequestMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        List<Producto> listaProductos = service.listAll();
        modelo.addAttribute("listaProductos", listaProductos);
        return "index";//esta indicando el html
    }

    @RequestMapping("/nuevo")
    public String mostrarFormulaDeRegistro(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "nuevo_producto";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        service.save(producto);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable(name = "id") Long id) {
        ModelAndView modelo = new ModelAndView("editar_producto");

        //aparte de mandarle ese producto boya mandarlo
        Producto producto = service.get(id);
        modelo.addObject("producto", producto);
        return modelo;
    }
}
