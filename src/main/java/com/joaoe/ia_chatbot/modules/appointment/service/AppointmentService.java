package com.joaoe.ia_chatbot.modules.appointment.service;

import com.joaoe.ia_chatbot.modules.appointment.exception.AppointmentValidation;
import com.joaoe.ia_chatbot.modules.appointment.model.Appointment;
import com.joaoe.ia_chatbot.modules.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment){

        if(appointment.getTitle().isBlank()){
            throw new AppointmentValidation("Title can not be blank");
        }

        if(appointment.getStarts().isAfter(appointment.getEnds())){
            throw new AppointmentValidation("Start date can not greater than end date");
        }

        if(appointment.getStatus() == null){
            throw new AppointmentValidation("Appointment status is null");
        }

        if(appointment.getUserAccount() == null){
            throw new AppointmentValidation("Invalid user account!");
        }

        return appointmentRepository.save(appointment);
    }
}
