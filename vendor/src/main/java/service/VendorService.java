package service;

import java.util.List;

import Entity.VendorEntity;
import model.Vendor;

public interface VendorService {
 
	public Vendor createVendor(Vendor vendor);
    public List<Vendor> getAllVendors();
    public Vendor getVendorById(Long id);
    public Vendor updateVendor(Long id, Vendor vendor);
    public boolean deleteVendor(Long id);
    
}
