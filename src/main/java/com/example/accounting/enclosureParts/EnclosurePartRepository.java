package com.example.accounting.enclosureParts;

import com.example.accounting.enclosures.Enclosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnclosurePartRepository extends JpaRepository<EnclosurePart, Long> {
//    @Query(value = "SELECT ep FROM EnclosurePart ep WHERE ep.enclosure.id = :enclosureId")
    List<EnclosurePart> findByEnclosure(Enclosure enclosure);
}
