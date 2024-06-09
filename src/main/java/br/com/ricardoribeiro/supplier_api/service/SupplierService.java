package br.com.ricardoribeiro.supplier_api.service;

import br.com.ricardoribeiro.supplier_api.domain.Supplier;
import br.com.ricardoribeiro.supplier_api.dto.DataSupplier;
import br.com.ricardoribeiro.supplier_api.dto.DataUpdateSupplierForm;
import br.com.ricardoribeiro.supplier_api.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    public DataSupplier save(DataSupplier dataForm) {
        Supplier supplier = supplierRepository.save(new Supplier(dataForm));
        return new DataSupplier(supplier);
    }

    public Page<DataSupplier> getAll(Pageable pagination) {
        return supplierRepository.findAll(pagination).map(DataSupplier::new);
    }

    public DataSupplier getById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fornecedor inexistente."));
        return new DataSupplier(supplier);
    }


    public Supplier updateSupplier(DataUpdateSupplierForm dataUpdateSupplierForm) {
        Supplier supplier = supplierRepository.getReferenceById(dataUpdateSupplierForm.id());
        supplier.update(dataUpdateSupplierForm);
        return supplier;
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
