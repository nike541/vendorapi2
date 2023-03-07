package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.VendorEntity;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity,Long> {
            
	VendorEntity findbyCode(String code);
}

