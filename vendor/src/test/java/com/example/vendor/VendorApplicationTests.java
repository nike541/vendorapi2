package com.example.vendor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import Entity.VendorEntity;
import Repository.VendorRepository;
import model.Vendor;
import service.VendorService;
import service.VendorServiceimp;

@SpringBootTest
class VendorApplicationTests {
    
	  @Mock
	    private VendorRepository vendorRepository;
	   @InjectMocks
	    private VendorServiceimp vendorService;
    @Test
	public void createVendor_success() {
        // Arrange
        Vendor vendor = new Vendor();
        vendor.setName("Test Vendor");
        vendor.setCode("TEST001");
        vendor.setAddress("123 Main St");
        vendor.setCity("Anytown");
        vendor.setState("CA");
        vendor.setPincode("123456");
        vendor.setPhone("1234567890");
        vendor.setEmail("testvendor@test.com");
        
        VendorEntity vendorentity=new VendorEntity();
		BeanUtils.copyProperties(vendor, vendorentity);
		
		
		when(vendorRepository.save(vendorentity)).thenReturn(vendorentity);

        // Act
        Vendor result = vendorService.createVendor(vendor);

        // Assert
        assertNotNull(result);
        assertEquals(vendor.getName(), result.getName());
        assertEquals(vendor.getCode(), result.getCode());
        assertEquals(vendor.getAddress(), result.getAddress());
        assertEquals(vendor.getCity(), result.getCity());
        assertEquals(vendor.getState(), result.getState());
        assertEquals(vendor.getPincode(), result.getPincode());
        assertEquals(vendor.getPhone(), result.getPhone());
        assertEquals(vendor.getEmail(), result.getEmail());
}
    

    @Test
    public void testUpdateVendor() {
        Vendor vendor = vendorService.createVendor(new Vendor("ACME001", "123 Main St", "Anytown", "CA", "123456", "555-555-5555", "acme@example.com", "ACME"));
        vendor.setName("ACME Inc");
        Vendor updatedVendor = vendorService.updateVendor(vendor.getId(), vendor);
        assertEquals("ACME Inc", updatedVendor.getName());
    }
    

    @Test
    public void testDeleteVendor() {
        Vendor vendor = vendorService.createVendor(new Vendor("ACME Corp", "ACME001", "123 Main St", "Anytown", "CA", "123456", "555-555-5555", "acme@example.com"));
        vendorService.deleteVendor(vendor.getId());
        assertNull(vendorService.getVendorById(vendor.getId()));
    }
}
