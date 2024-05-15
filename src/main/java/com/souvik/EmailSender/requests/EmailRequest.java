package com.souvik.EmailSender.requests;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequest {

    private String sendTo;
    private String subject;
    private String message;
}
