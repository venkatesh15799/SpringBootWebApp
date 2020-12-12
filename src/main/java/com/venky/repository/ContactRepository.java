package com.venky.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.entity.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact,Serializable> {
public List<Contact> findByActiveSw(String activeSw);


}
