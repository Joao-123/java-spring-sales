package org.spring.repository;

import org.spring.models.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interface.
 */
public interface RepositorySale extends CrudRepository<Sale, Integer> {

    /**
     * @param idSeller idSeller.
     * @param idClient idClient.
     * @return list.
     */
    @Query(value = "SELECT * FROM sales s WHERE s.id_seller = :idSeller OR s.id_client = :idClient",
            nativeQuery = true)
    List<Sale> findSaleUserRelated(@Param("idSeller") String idSeller, @Param("idClient") String idClient);

    /**
     * @param idSeller idSeller.
     * @return list.
     */
    @Query("SELECT s FROM sales s WHERE s.id_seller = :idSeller")
    List<Sale> findSalesBySeller(@Param("idSeller") String idSeller);

    /**
     * @param idClient idClient.
     * @return list.
     */
    @Query("SELECT s FROM sales s WHERE s.id_client = :idClient")
    List<Sale> findSalesByClient(@Param("idClient") String idClient);

}
