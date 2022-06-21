package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.ITimesheetService;

@RestController
public class RestControllerContrat {

    @Autowired
    IContratService icontratservice;




    @PostMapping("/addContrat")
    @ResponseBody
    public int addContrat(@RequestBody Contrat cont) {
        icontratservice.ajouterContrat(cont);
        return cont.getReference();
    }

    @GetMapping(value = "/getAllContrats")
    @ResponseBody
    public List<Contrat> getAllContrat() {
        return icontratservice.getAllContrats();
    }

    @DeleteMapping("/deleteContrat")
    @ResponseBody
    public void deleteContratById(@PathVariable("contratId") int contratId) {
        icontratservice.deleteContraById(contratId);
    }

    @GetMapping(value = "/getContratById/{contratId}")
    @ResponseBody
    public Contrat getContratById(@PathVariable("contratId") int contratId) {
        return icontratservice.getContrat(contratId);
    }

}