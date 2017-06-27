package com.eframe.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.eframe.model.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, String> {
}