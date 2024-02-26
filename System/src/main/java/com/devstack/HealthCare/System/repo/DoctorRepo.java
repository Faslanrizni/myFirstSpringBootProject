package com.devstack.HealthCare.System.repo;

import com.devstack.HealthCare.System.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
