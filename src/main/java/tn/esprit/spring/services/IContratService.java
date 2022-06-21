package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Mission;


public interface IContratService {


    public List<Contrat> getAllContrats();

    public int ajouterContrat(Contrat contrat);
    Contrat getContrat(int contratId);
    public void deleteContraById(int contratId);







}
