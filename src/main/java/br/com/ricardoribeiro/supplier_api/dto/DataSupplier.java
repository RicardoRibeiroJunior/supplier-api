package br.com.ricardoribeiro.supplier_api.dto;

import br.com.ricardoribeiro.supplier_api.domain.Supplier;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataSupplier(

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
        public DataSupplier(Supplier supplier) {

                this(
                        supplier.getId(),
                        supplier.getName(),
                        supplier.getCnpj(),
                        supplier.getBranch(),
                        supplier.getPhone(),
                        new DataAddress(supplier.getAddress())
                );

        }
}
