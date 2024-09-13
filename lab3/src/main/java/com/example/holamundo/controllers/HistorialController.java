package com.example.holamundo.controllers;

import com.example.holamundo.entity.Employee;
import com.example.holamundo.repository.JobRepository;
import com.example.holamundo.repository.employeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/historial")
public class HistorialController {


    final employeeRepository employeeRepository;
    final JobRepository jobRepository;



    public HistorialController(employeeRepository employeeRepository,
                               JobRepository jobRepository) {

        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    //Vista principal: /employee
    @GetMapping({"/",""})
    public String listahist(Model model, @RequestParam(required = false) String zona) {
        model.addAttribute("listaEmpleados", employeeRepository.findAll());

        return "historial/lista";
    }

    @GetMapping("/info/{id}")
    public String editarEmpleados(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Busqueda invalida"));
        model.addAttribute("listaTrabajadores", jobRepository.findAll());

        model.addAttribute("employee",employee);
        return "empleado/formulario";
    }

    /*@PostMapping("/update")
    public String actualizacionEmpleado(@ModelAttribute Employee employee,Model model){
        employeeRepository.save(employee);
        return "redirect:/employee/";
    }*/

    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Employee> optEmployee = employeeRepository.findById(id);

    if (optEmployee.isPresent()) {
        try {
            employeeRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Se borró el empleado."); // Successful deletion
        } catch (Exception e) {
            attr.addFlashAttribute("msg", "No se pudo borrar al empleado."); // Deletion failed due to a constraint
        }
    } else {
        attr.addFlashAttribute("msg", "No se encontró al empleado para borrar."); // Employee not found
    }

        return "redirect:/employee";

    }



}
