package net.joostit.winchhunt.repositories;

import net.joostit.winchhunt.entities.Site;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface SiteRepository extends CrudRepository<Site, Integer> {

}
