package br.com.ricardoribeiro.supplier_api.domain;

import br.com.ricardoribeiro.supplier_api.dto.DataSupplier;
import br.com.ricardoribeiro.supplier_api.dto.DataUpdateSupplierForm;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String branch;
    private String phone;

    @Embedded
    private Address address;

    public Supplier(DataSupplier dataForm) {
        this.name = dataForm.name();
        this.cnpj = dataForm.cnpj();
        this.branch = dataForm.branch();
        this.phone = dataForm.phone();
        this.address = new Address(dataForm.addressForm());
    }

    public void update(@Valid DataUpdateSupplierForm dataUpdateSupplierForm) {

        this.name = dataUpdateSupplierForm.name();
        this.cnpj = dataUpdateSupplierForm.cnpj();
        this.branch = dataUpdateSupplierForm.branch();
        this.phone = dataUpdateSupplierForm.phone();
        this.address.update(dataUpdateSupplierForm.addressForm());

    }
}
