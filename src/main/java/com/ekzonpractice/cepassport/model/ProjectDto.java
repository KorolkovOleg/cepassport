package com.ekzonpractice.cepassport.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    @NotBlank(message = "Название проекта не может быть пустым")
    @Size(min = 3, max = 100, message = "Название проекта должно быть от 3 до 100 символов")
    private String name;

    @NotBlank(message = "Статус проекта не может быть пустым")
    private String status;

    private String documents; // Документы могут быть пустыми
}
