package com.tim04.school.facturing.service.client;

import com.tim04.school.facturing.persistence.client.Client;
import com.tim04.school.facturing.persistence.client.ClientRepository;
import com.tim04.school.facturing.persistence.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public void save(String name, String regDate, int cif, String adress, String contactPerson, Long userID) {
        Client theClient = new Client();
        theClient.setName(name);
        theClient.setRegDate(regDate);
        theClient.setCif(cif);
        theClient.setAdress(adress);
        theClient.setContactPerson(contactPerson);
        theClient.setUserID(userID);
        clientRepository.save(theClient);
    }
/*    @Transactional(readOnly = true)
    public List<Client> findAll(){
       return clientRepository.findAll();
    }*/

    @Transactional(readOnly = true)
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Client getClient(){
        return clientRepository.findByName("bog");
    }

    @Transactional
    public void save(Client client) {
         clientRepository.save(client);
    }
}