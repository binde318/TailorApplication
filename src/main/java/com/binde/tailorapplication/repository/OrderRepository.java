package com.binde.tailorapplication.repository;

import com.binde.tailorapplication.entity.Designer;
import com.binde.tailorapplication.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository

public interface OrderRepository extends JpaRepository<Order, String> {


    List<Order> findByCreatedDateBetween(Timestamp start, Timestamp end);
    List<Order> findAllByDesigner(Designer designer);

}
