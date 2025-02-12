package com.Technosignia.Azown.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Technosignia.Azown.Entity.Broker;

@Repository
public interface BrokerRepository extends JpaRepository<Broker, Long> {

}
