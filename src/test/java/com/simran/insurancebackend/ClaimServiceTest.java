package com.simran.insurancebackend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClaimServiceTest {

    @Mock
    private ClaimRepository repo;

    @InjectMocks
    private ClaimService service;

    @Test
    void testGetAllClaims() {

        Claim c1 = new Claim();
        c1.setUserName("Simran");

        Claim c2 = new Claim();
        c2.setUserName("John");

        List<Claim> fakeList = Arrays.asList(c1, c2);

        when(repo.findAll()).thenReturn(fakeList);

        List<Claim> result = service.getAllClaims();

        assertEquals(2, result.size());

        verify(repo, times(1)).findAll();
    }

    // ✅ SEPARATE METHOD (outside the above one)
    @Test
    void testGetClaimById() {

        Claim claim = new Claim();
        claim.setId(1L);
        claim.setUserName("Simran");

        when(repo.findById(1L)).thenReturn(java.util.Optional.of(claim));

        Claim result = service.getClaimById(1L);

        assertEquals("Simran", result.getUserName());

        verify(repo, times(1)).findById(1L);
    }
}