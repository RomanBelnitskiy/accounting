package com.example.accounting.bills;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillRepository repository;

    public BillService(BillRepository repository) {
        this.repository = repository;
    }

    public List<Bill> findAll() {
        return repository.findAll();
    }

    public Bill save(Bill bill) {
        return repository.save(bill);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
