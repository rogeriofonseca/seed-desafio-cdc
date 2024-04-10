package br.com.virtualbooks.tabernabooks.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FieldErrorOutputDto {
    private String field;
    private String message;
}
