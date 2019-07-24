package org.spring.repository;

import org.spring.models.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface.
 */
@Repository
public interface RepositorySale extends CrudRepository<Sale, Integer> {



   // public @Query("SELECT s FROM sales s WHERE s.id_seller = :idSeller")
    //List<Sale> findSalesBySeller(@Param("idSeller") String idSeller);

    /**
     * @param idClient idClient.
     * @return list.
     */
   // public @Query("SELECT s FROM sales s WHERE s.id_client = :idClient")
   // List<Sale> findSalesByClient(@Param("idClient") String idClient);

    /**
     * @param idUser idUser.
     * @return list.
     */
    public @Query(value = "SELECT * FROM sales s WHERE s.id_seller = :idUser OR s.id_client = :idUser",
            nativeQuery = true)
    List<Sale> findSalesRelatedWithUser(@Param("idUser") String idUser);

}
