package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import model.Vendor;
import service.VendorService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vendors")
public class VendorController {

	
	private final VendorService vendorservice;
	 
	public VendorController(VendorService vendorservice) {
		this.vendorservice=vendorservice;
	}
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor vendor) {
		
		
		return vendorservice.createVendor(vendor);
		
	}
	
	@GetMapping("/vendor")
	public List<Vendor> getAllVendors(){
		
		return vendorservice.getAllVendors();
		
	 }
	
	 @DeleteMapping("/vendors/{id}")
	    public ResponseEntity<Map<String,Boolean>> deletevendor(@PathVariable Long id) {
	        boolean deleted = false;
	        deleted = vendorservice.deleteVendor(id);
	        Map<String,Boolean> response = new HashMap<>();
	        response.put("deleted", deleted);
	        return ResponseEntity.ok(response);
	    }
	 
	 @GetMapping("/vendors/{id}")
	    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
	        Vendor Vendor = null;
	        Vendor = vendorservice.getVendorById(id);
	        return ResponseEntity.ok(Vendor);
	    }
	 
	 @PutMapping("/vendors/{id}")
	    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id,
	                                                   @RequestBody Vendor Vendor) {
	        Vendor = vendorservice.updateVendor(id, Vendor);
	        return ResponseEntity.ok(Vendor);
	    }

	}

