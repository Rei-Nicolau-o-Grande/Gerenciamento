package com.gerenciamento.controller.docSwagger.departamentos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Criar Departamento", description = "Recurso para criar Departamento")
@Tag(name = "Departamentos")
@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Departamento criado com sucesso",
                content = @Content()),
})
public @interface DocCreateDepartamento {
}
