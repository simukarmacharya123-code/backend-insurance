package com.simran.insurancebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository repo;

    public List<Claim> getAllClaims() {
        return repo.findAll();
    }

    public Claim getClaimById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + id));
    }

    public Claim createClaim(Claim claim) {
        return repo.save(claim);
    }

    public Claim updateClaim(Long id, Claim updatedClaim) {
        Claim claim = repo.findById(id).orElseThrow();

        claim.setUserName(updatedClaim.getUserName());
        claim.setClaimType(updatedClaim.getClaimType());
        claim.setAmount(updatedClaim.getAmount());
        claim.setStatus(updatedClaim.getStatus());

        return repo.save(claim);
    }

    public void deleteClaim(Long id) {
        repo.deleteById(id);
    }
}