package com.example.spring_web_data.autore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record AutorePayload(
        @NotEmpty(message = "Il nome è Obbligatorio")
        @Size(min = 3, max = 15, message = "Il nome deve essere compreso tra i 3 e i 15 caratteri")
        String nome,
        @NotEmpty(message = "Il cognome è Obbligatorio")
        @Size(min = 3, max = 15, message = "Il cognome deve essere compreso tra i 3 e i 15 caratteri")
        String cognome,
        @NotEmpty(message = "L'email è obbligatoria")
        @Email(message = "Inserisci un'email valida")
        String email,
        @NotEmpty(message = "La data di nascita è obbligatoria")
        String dataDiNascita) {

}
