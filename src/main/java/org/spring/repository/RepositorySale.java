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


    @Query(value = "SELECT * FROM sales_items s WHERE s.id_seller = :idSeller", nativeQuery = true)
    public List<Sale> findSalesBySeller(@Param("idSeller") String idSeller);

    /**
     * @param idClient idClient.
     * @return list.
     */
    @Query(value = "SELECT * FROM sales_items s WHERE s.id_client = :idClient", nativeQuery = true)
    public List<Sale> findSalesByClient(@Param("idClient") String idClient);

    /**
     * @param idUser idUser.
     * @return list.
     */
    @Query(value = "SELECT * FROM sales s WHERE s.id_seller = :idUser OR s.id_client = :idUser",
            nativeQuery = true)
    public List<Sale> findSalesRelatedWithUser(@Param("idUser") String idUser);

}
