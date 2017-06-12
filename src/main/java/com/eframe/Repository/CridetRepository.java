package com.eframe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Cridet;

public interface CridetRepository extends JpaRepository<Cridet, String> {

}
