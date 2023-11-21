package com.example.accounting.bills;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {
    private final BillRepository repository;

    public BillService(BillRepository repository) {
        this.repository = repository;
    }

    public List<BillDto> findAll() {
        return repository.findAll()
                .stream()
                .map(Bill::toDto)
                .collect(Collectors.toList());
    }

    public BillDto save(BillDto billDto) {
        Bill bill = Bill.toEntity(billDto);
        return repository.save(bill).toDto();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
