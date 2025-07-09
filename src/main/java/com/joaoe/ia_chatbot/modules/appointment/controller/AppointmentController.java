package com.joaoe.ia_chatbot.modules.appointment.controller;

import com.joaoe.ia_chatbot.modules.appointment.dto.request.CreateAppointmentRequest;
import com.joaoe.ia_chatbot.modules.appointment.dto.response.CreateAppointmentResponse;
import com.joaoe.ia_chatbot.modules.appointment.mapper.AppointmentMapper;
import com.joaoe.ia_chatbot.modules.appointment.model.Appointment;
import com.joaoe.ia_chatbot.modules.appointment.model.AppointmentsStatus;
import com.joaoe.ia_chatbot.modules.appointment.service.AppointmentService;
import com.joaoe.ia_chatbot.modules.appointment.service.AppointmentStatusService;
import com.joaoe.ia_chatbot.modules.user.model.UserAccount;
import com.joaoe.ia_chatbot.modules.user.service.UserAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final UserAccountService userAccountService;
    private final AppointmentStatusService appointmentsStatusService;
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<CreateAppointmentResponse> createAppointment(@RequestBody @Valid CreateAppointmentRequest createAppointmentRequest){

        UserAccount userAccount = userAccountService.findByUUID(createAppointmentRequest.getUserAccount());

        AppointmentsStatus appointmentsStatus = appointmentsStatusService.findByStatus(createAppointmentRequest.getStatus());

        Appointment appointment = AppointmentMapper.toAppointment(createAppointmentRequest, userAccount, appointmentsStatus);

        appointment = appointmentService.createAppointment(appointment);

        CreateAppointmentResponse createAppointmentResponse = AppointmentMapper.toCreateAppointmentResponse(appointment);

        return ResponseEntity.status(HttpStatus.CREATED).body(createAppointmentResponse);
    }
}
