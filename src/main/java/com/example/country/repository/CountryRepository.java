package com.example.country.repository;

import org.springframework.stereotype.Repository;

import com.example.country.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
