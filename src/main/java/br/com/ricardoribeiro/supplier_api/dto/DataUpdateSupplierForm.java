package br.com.ricardoribeiro.supplier_api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataUpdateSupplierForm(

        @NotNull(message = "O campo nome é obrigatório.")
        Long id,

        @NotBlank(message = "O campo nome é obrigatório.")
        String name,

        @NotBlank(message = "O campo nome é obrigatório.")
        String cnpj,

        @NotBlank(message = "O campo nome é obrigatório.")
        String branch,

        @NotBlank(message = "O campo nome é obrigatório.")
        String phone,

        @NotNull
        @Valid
        DataAddress addressForm


    ) {
}
