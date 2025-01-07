package br.com.joaov7r.dao;

import br.com.joaov7r.domain.Client;

import java.util.Collection;

public interface IClientDAO {

    public boolean register(Client client);

    public void delete(Long cpf);

    public void update(Client client);

    public Client consult(Long cpf);

    public Collection<Client> getAll();
}
