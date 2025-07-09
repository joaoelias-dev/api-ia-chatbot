package com.joaoe.ia_chatbot.modules.appointment.service;

import com.joaoe.ia_chatbot.modules.appointment.model.AppointmentsStatus;
import com.joaoe.ia_chatbot.modules.appointment.repository.AppointmentStatusRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentStatusService {

    @Autowired
    private AppointmentStatusRepository appointmentStatusRepository;
    public AppointmentsStatus findByStatus(String status){
        return appointmentStatusRepository.findByStatus(status)
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));
    }
}
