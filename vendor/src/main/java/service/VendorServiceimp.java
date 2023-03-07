package service;
import java.util.*;
import java.util.function.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.VendorEntity;
import Repository.VendorRepository;
import model.Vendor;
import Entity.VendorEntity;
@Service
public class VendorServiceimp implements VendorService{
    @Autowired
	private VendorRepository vendorRepository;
	public VendorServiceimp(VendorRepository vendorRepository) {
		
		this.vendorRepository = vendorRepository;
	}
	
	@Override
	public Vendor createVendor(Vendor vendor) {
		
		
		VendorEntity vendorentity=new VendorEntity();
		BeanUtils.copyProperties(vendor, vendorentity);
		
		vendorRepository.save(vendorentity);
		return vendor;
	}
	
	@Override
	public List<Vendor> getAllVendors() {
		List<VendorEntity> vendorentities = vendorRepository.findAll();
		List<Vendor> vendorees=vendorentities.stream().map(emp -> new Vendor
				(
				emp.getId(),
				emp.getName(),
				emp.getCode(),
				emp.getAddress(),
				emp.getCity(),
				emp.getState(),
				emp.getPincode(),
				emp.getPhone(),
				emp.getEmail()
				))
			.collect(Collectors.toList());
		return vendorees;
	}
	
	@Override
	public Vendor getVendorById(Long id) {
		VendorEntity vendorentity=vendorRepository.findById(id).get();
		Vendor vendor=new Vendor();
	    BeanUtils.copyProperties(vendorentity, vendor);
	    return vendor;
		}
	
	@Override
	public Vendor updateVendor(Long id, Vendor vendor) {
		VendorEntity vendorentity=vendorRepository.findById(id).get();
		vendorentity.setName(vendor.getName());
		vendorentity.setCode(vendor.getCode());
		vendorentity.setAddress(vendor.getAddress());
		vendorentity.setCity(vendor.getCity());
		vendorentity.setState(vendor.getState());
		vendorentity.setPincode(vendor.getPincode());
		vendorentity.setPhone(vendor.getPhone());
		vendorentity.setEmail(vendor.getEmail());
		
		vendorRepository.save(vendorentity);
		return vendor;
		
		
	}
	
	 @Override
	    public boolean deleteVendor(Long id) {
	        VendorEntity vendor = vendorRepository.findById(id).get();
	        vendorRepository.delete(vendor);
	        return true;
	    }

	
}
