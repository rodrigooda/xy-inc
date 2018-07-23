package com.oda.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oda.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}