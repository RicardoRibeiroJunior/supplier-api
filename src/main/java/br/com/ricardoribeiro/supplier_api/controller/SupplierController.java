package br.com.ricardoribeiro.supplier_api.controller;

import br.com.ricardoribeiro.supplier_api.dto.DataSupplier;
import br.com.ricardoribeiro.supplier_api.dto.DataUpdateSupplierForm;
import br.com.ricardoribeiro.supplier_api.service.SupplierService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    @Transactional
    public ResponseEntity<DataSupplier> save(@RequestBody @Valid DataSupplier dataForm, UriComponentsBuilder uriBuilder){
        DataSupplier dataSupplier = supplierService.save(dataForm);
        URI uri = uriBuilder.path("supplier/{id}").buildAndExpand(dataSupplier.id()).toUri();
        return ResponseEntity.created(uri).body(dataSupplier);
    }

    @GetMapping
    public ResponseEntity<Page<DataSupplier>> getAll(@PageableDefault(size=10, sort= {"id"}, page=0) Pageable pagination){
        return ResponseEntity.ok(supplierService.getAll(pagination));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataSupplier> getById(@PathVariable @NotNull Long id){
        return ResponseEntity.ok(supplierService.getById(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataSupplier> update(@RequestBody @Valid DataUpdateSupplierForm dados){
        return ResponseEntity.ok(new DataSupplier(supplierService.updateSupplier(dados)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

}
