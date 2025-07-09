package com.joaoe.ia_chatbot.modules.appointment.repository;

import com.joaoe.ia_chatbot.modules.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
