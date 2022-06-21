package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {


    @Autowired
    ContratRepository contratRepository;


    public List<Contrat> getAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public int ajouterContrat(Contrat contrat) {
        contratRepository.save(contrat);
        return contrat.getReference();
    }

    @Override
    public Contrat getContrat(int contratId) {
        return contratRepository.findById(contratId).get();
    }

    @Override
    public void deleteContraById(int contratId) {
        contratRepository.delete(contratRepository.findById(contratId).get());

    }

}
