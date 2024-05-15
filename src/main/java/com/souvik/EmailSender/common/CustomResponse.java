package com.souvik.EmailSender.common;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomResponse {

    private String message;
    private HttpStatus httpStatus;
    private Boolean success = false;

}
