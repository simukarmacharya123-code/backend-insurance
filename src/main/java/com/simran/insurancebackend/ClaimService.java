package com.simran.insurancebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simran.insurancebackend.dto.ClaimRequest;
import com.simran.insurancebackend.dto.ClaimResponse;

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

    public ClaimResponse createClaim(ClaimRequest request) {

        // Convert DTO → Entity
        Claim claim = new Claim();
        claim.setClaimType(request.getClaimType());
        claim.setUserName(request.getUserName());
        claim.setStatus(request.getStatus());
        claim.setDescription(request.getDescription());
        claim.setAmount(request.getAmount());

        // Save to DB
        Claim saved = repo.save(claim);

        // Convert Entity → Response DTO
        ClaimResponse response = new ClaimResponse();
        response.setId(saved.getId());
        response.setClaimType(saved.getClaimType());
        response.setUserName(saved.getUserName());
        response.setStatus(saved.getStatus());
        response.setDescription(saved.getDescription());
        response.setAmount(saved.getAmount());

        return response;
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
    public int calculateTotal(int a, int b) {
        return a + b;
    }
}