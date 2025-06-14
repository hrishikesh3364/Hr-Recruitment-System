package com.Employee.HrRecruitmentSystem.Controller;

import com.Employee.HrRecruitmentSystem.DTO.CandidateCVDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {

    private final List<CandidateCVDto> candidates = new ArrayList<>();


    @PostMapping("/candidates")
    ResponseEntity<String> createCandidate(@Valid @RequestBody CandidateCVDto candidateCVDto) {
        candidates.add(candidateCVDto);
        return ResponseEntity.ok("Candidate saved successfully.");
    }


    @GetMapping("/candidates")
    public ResponseEntity<List<CandidateCVDto>> getAllCandidates() {
        return ResponseEntity.ok(candidates);
    }


    @GetMapping("/candidates/{id}")
    public ResponseEntity<?> getCandidateById(@PathVariable int id) {
        if (id >= 0 && id < candidates.size()) {
            return ResponseEntity.ok(candidates.get(id));
        } else {
            return ResponseEntity.badRequest().body("Candidate not found with index: " + id);
        }
    }
}
