package br.com.joaov7r.dao;

import br.com.joaov7r.domain.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientMapDAO implements IClientDAO {

    private Map<Long, Client> map;

    public ClientMapDAO(){
        this.map = new HashMap<>();
    }

    @Override
    public boolean register(Client cliente) {
        if (this.map.containsKey(cliente.getCpf())){
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void delete(Long cpf) {
    Client registeredClient = this.map.get(cpf);
    if(registeredClient != null) {
        this.map.remove(registeredClient.getCpf(), registeredClient);
        }
    }

    @Override
    public void update(Client client) {
        Client registeredClient = this.map.get(client.getCpf());
        if (registeredClient != null){
            registeredClient.setName(client.getName());
            registeredClient.setPhone(client.getPhone());
            registeredClient.setNumber(client.getNumber());
            registeredClient.setAddress(client.getAddress());
            registeredClient.setCity(client.getCity());
            registeredClient.setState(client.getState());
        }
    }

    @Override
    public Client consult(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Client> getAll() {
        return this.map.values();
    }
}
