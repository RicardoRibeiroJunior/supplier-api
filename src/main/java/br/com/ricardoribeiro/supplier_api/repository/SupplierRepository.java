package br.com.ricardoribeiro.supplier_api.repository;

import br.com.ricardoribeiro.supplier_api.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
