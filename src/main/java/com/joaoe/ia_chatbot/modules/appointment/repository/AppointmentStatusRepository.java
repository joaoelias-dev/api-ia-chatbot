package com.joaoe.ia_chatbot.modules.appointment.repository;

import com.joaoe.ia_chatbot.modules.appointment.model.AppointmentsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentStatusRepository extends JpaRepository<AppointmentsStatus, Long> {

    public Optional<AppointmentsStatus> findByStatus(String status);
}
