package com.simran.insurancebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ClaimService service;

    // GET all claims
    @GetMapping("/claims")
    public List<Claim> getClaims() {
        return service.getAllClaims();
    }

    // GET by ID
    @GetMapping("/claims/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return service.getClaimById(id);
    }

    // POST new claim
    @PostMapping("/claims")
    public Claim createClaim(@Valid @RequestBody Claim claim) {
        return service.createClaim(claim);
    }

    // PUT update claim
    @PutMapping("/claims/{id}")
    public Claim updateClaim(@PathVariable Long id, @Valid @RequestBody Claim updatedClaim) {
        return service.updateClaim(id, updatedClaim);
    }

    // DELETE claim
    @DeleteMapping("/claims/{id}")
    public String deleteClaim(@PathVariable Long id) {
        service.deleteClaim(id);
        return "Claim deleted successfully";

    }

    // 🔥 ADD THIS HERE (new API)
    @GetMapping("/hello")
    public String hello() {
        return "Hello Simran from cloned project!";
    }
}