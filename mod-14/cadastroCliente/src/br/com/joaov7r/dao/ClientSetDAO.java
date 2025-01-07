package br.com.joaov7r.dao;

import br.com.joaov7r.domain.Client;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientSetDAO implements IClientDAO{

    private Set<Client> set;

    public ClientSetDAO(){
        this.set = new HashSet<>();
    }

    @Override
    public boolean register(Client client) {
        return this.set.add(client);
    }

    @Override
    public void delete(Long cpf) {
        Client registeredClient = null;
        for (Client client : this.set){
            if(client.getCpf().equals(cpf)){
                registeredClient = client;
                break;
            }
        }

        if (registeredClient != null) {
            this.set.remove(registeredClient);
        }
    }

    @Override
    public void update(Client client) {
        if (this.set.contains(client)) {
            for (Client registeredClient : this.set){
                if (registeredClient.equals(client)) {
                    registeredClient.setName(client.getName());
                    registeredClient.setPhone(client.getPhone());
                    registeredClient.setNumber(client.getNumber());
                    registeredClient.setAddress(client.getAddress());
                    registeredClient.setCity(client.getCity());
                    registeredClient.setState(client.getState());
                    break;
                }
            }
        }
    }

    @Override
    public Client consult(Long cpf) {
        for (Client registeredClient : this.set){
            if (registeredClient.getCpf().equals(cpf)){
                return registeredClient;
            }
        }
        return null;
    }

    @Override
    public Collection<Client> getAll() {
        return this.set;
    }
}
