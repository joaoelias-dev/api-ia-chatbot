package com.joaoe.ia_chatbot.shared.timeConversion;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtils {

    private DateTimeUtils() {
    }
    
    /**
     * Converte um LocalDateTime para Instant, baseado no timezone da empresa.
     *
     * @param localDateTime LocalDateTime sem fuso horário
     * @param timeZoneId    Ex: "America/Sao_Paulo", "UTC", "Europe/Lisbon"
     * @return Instant correspondente
     */
    public static Instant convertLocalDateTimeToInstant(LocalDateTime localDateTime, String timeZoneId) {
        if (localDateTime == null || timeZoneId == null) {
            throw new IllegalArgumentException("localDateTime or timeZoneId can not be null.");
        }

        ZoneId zoneId = ZoneId.of(timeZoneId);
        return localDateTime.atZone(zoneId).toInstant();
    }
}
