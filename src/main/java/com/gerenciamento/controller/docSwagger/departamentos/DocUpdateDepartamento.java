package com.gerenciamento.controller.docSwagger.departamentos;

import com.gerenciamento.exception.dto.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Atualizar Departamento", description = "Recurso para atualizar Departamento")
@Tag(name = "Departamentos")
@ApiResponses(value = {
        @ApiResponse(responseCode = "202", description = "Departamento atualizado com sucesso",
                content = @Content()),
        @ApiResponse(responseCode = "404", description = "Departamento não encontrado",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ErrorDto.class))),
})
public @interface DocUpdateDepartamento {
}
