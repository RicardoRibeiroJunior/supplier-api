package br.com.ricardoribeiro.supplier_api.domain;

import br.com.ricardoribeiro.supplier_api.dto.DataAddress;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String cep;
    private String uf;
    private String city;
    private String number;
    private String complement;

    public Address(DataAddress dataAddress) {
        this.street = dataAddress.street();
        this.neighborhood = dataAddress.neighborhood();
        this.cep = dataAddress.cep();
        this.uf = dataAddress.uf();
        this.city = dataAddress.city();
        this.number = dataAddress.number();
        this.complement = dataAddress.complement();
    }

    public void update(DataAddress dataAddress) {
        this.street = dataAddress.street();
        this.neighborhood = dataAddress.neighborhood();
        this.cep = dataAddress.cep();
        this.uf = dataAddress.uf();
        this.city = dataAddress.city();
        this.number = dataAddress.number();
        this.complement = dataAddress.complement();
    }
}
