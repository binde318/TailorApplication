package com.binde.tailorapplication.repository;

import com.binde.tailorapplication.entity.Designer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesignerRepository extends JpaRepository<Designer,String> {

    Optional<Designer> findByEmail(String email);
}
