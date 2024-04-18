package comp382.assignment1.Inventory.repository;


import comp382.assignment1.Inventory.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring recognize repositories by the fact that they extend one of the predefined Repository interfaces
 * JpaRepositoryIt has full API CrudRepository and PagingAndSortingRepository. So, basically, Jpa Repository contains the APIs for basic CRUD operations, the APIS for pagination, and the APIs for sorting.
 *
 */
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}