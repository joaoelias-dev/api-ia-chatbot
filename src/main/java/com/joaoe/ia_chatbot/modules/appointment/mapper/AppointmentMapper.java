package com.joaoe.ia_chatbot.modules.appointment.mapper;

import com.joaoe.ia_chatbot.modules.appointment.dto.request.CreateAppointmentRequest;
import com.joaoe.ia_chatbot.modules.appointment.dto.response.CreateAppointmentResponse;
import com.joaoe.ia_chatbot.modules.appointment.model.Appointment;
import com.joaoe.ia_chatbot.modules.appointment.model.AppointmentsStatus;
import com.joaoe.ia_chatbot.modules.user.model.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public static Appointment toAppointment(CreateAppointmentRequest createAppointmentRequest, UserAccount userAccount, AppointmentsStatus status){
        return Appointment.builder()
            .description(createAppointmentRequest.getDescription())
            .starts(createAppointmentRequest.getStarts())
            .ends(createAppointmentRequest.getEnds())
            .userAccount(userAccount)
            .status(status)
            .title(createAppointmentRequest.getTitle())
            .build();
    }

    public static CreateAppointmentResponse toCreateAppointmentResponse(Appointment appointment){
        return CreateAppointmentResponse.builder()
            .description(appointment.getDescription())
            .ends(appointment.getEnds())
            .starts(appointment.getStarts())
            .status(appointment.getStatus().getStatus())
            .title(appointment.getTitle())
            .userAccount(appointment.getUserAccount().getUsername())
            .uuid(appointment.getUuid())
            .build();
    }
}
