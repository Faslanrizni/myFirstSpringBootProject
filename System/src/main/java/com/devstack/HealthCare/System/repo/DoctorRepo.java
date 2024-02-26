package com.devstack.HealthCare.System.repo;

import com.devstack.HealthCare.System.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface  DoctorRepo extends JpaRepository<Doctor, Long> {

    public List<Doctor>findAllByName(String name);
}
