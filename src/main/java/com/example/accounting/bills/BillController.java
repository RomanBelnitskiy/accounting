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
    public List<BillDto> getAll() {
        return service.findAll();
    }

    @PostMapping
    public BillDto saveBill(@RequestBody BillDto billDto) {
        return service.save(billDto);
    }

    @PutMapping
    public BillDto update(@RequestBody BillDto billDto) {
        return service.save(billDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
