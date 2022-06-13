package com.example.demo.controllers;

import com.example.demo.models.ProyectoModel;
import com.example.demo.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping ("api/proyecto")
public class ProyectoController {
    @Autowired
    ProyectoService proyectoService;

    @GetMapping()
    public ArrayList<ProyectoModel> obtenerProyectos(){
        return proyectoService.obtenerProyectos();
    }

    @PostMapping()
    public ProyectoModel guardarProyecto(@RequestBody ProyectoModel proyecto){
        return this.proyectoService.guardarProyecto(proyecto);
    }

    @GetMapping( path = "/{id}")
    public Optional<ProyectoModel> obtenerProyectoPorId(@PathVariable("id") Long id){
        return this.proyectoService.obtenerPorId(id);
    }

    @GetMapping( path = "/query")
    public ArrayList<ProyectoModel> obtenerProyectoPorNombre(@RequestParam("nombre") String nombre){
        return this.proyectoService.obtenerPorNombre(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.proyectoService.eliminarProyecto(id);
            if(ok){
                return "Se elimino el usuario con el id " + id;
            } else {
                return "No pudo eliminar el usuario con el id " + id;
            }
    }
}
