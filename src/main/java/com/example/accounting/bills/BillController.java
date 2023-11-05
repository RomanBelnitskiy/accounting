package com.example.accounting.bills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {
    private final BillService service;

    public BillController(BillService service) {
        this.service = service;
    }

    @GetMapping
    public List<Bill> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Bill saveBill(@RequestBody Bill bill) {
        return service.save(bill);
    }

    @PutMapping
    public Bill update(@RequestBody Bill bill) {
        return service.save(bill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
