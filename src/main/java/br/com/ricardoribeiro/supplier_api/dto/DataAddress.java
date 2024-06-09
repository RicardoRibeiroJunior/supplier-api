package br.com.ricardoribeiro.supplier_api.dto;

import br.com.ricardoribeiro.supplier_api.domain.Address;
import jakarta.validation.constraints.NotBlank;

public record DataAddress(

        @NotBlank(message = "O campo nome é obrigatório.")
        String street,

        @NotBlank(message = "O campo nome é obrigatório.")
        String neighborhood,

        @NotBlank(message = "O campo nome é obrigatório.")
        String cep,

        @NotBlank(message = "O campo nome é obrigatório.")
        String uf,

        @NotBlank(message = "O campo nome é obrigatório.")
        String city,

        String number,
        String complement

) {
        public DataAddress(Address address) {
                this(
                        address.getStreet(),
                        address.getNeighborhood(),
                        address.getCep(),
                        address.getUf(),
                        address.getCity(),
                        address.getNumber(),
                        address.getComplement()
                );
        }
}
