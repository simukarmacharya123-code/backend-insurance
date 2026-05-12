package com.simran.insurancebackend;

import com.simran.insurancebackend.dto.ClaimRequest;
import com.simran.insurancebackend.dto.ClaimResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
// ✅ ADD THESE HERE
import com.simran.insurancebackend.dto.ClaimRequest;
import com.simran.insurancebackend.dto.ClaimResponse;
@RequestMapping("/")
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
    public ClaimResponse createClaim(@Valid @RequestBody ClaimRequest request) {
        return service.createClaim(request);
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