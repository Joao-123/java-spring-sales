package org.spring.repository;

import org.spring.models.SaleItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface.
 */
@Repository
public interface RepositorySaleItem extends CrudRepository<SaleItem, Integer> {

    /**
     * @param idSale idSale.
     * @return list.
     */
    @Query(value = "SELECT * FROM sales_items s WHERE s.id_sale = :idSale", nativeQuery = true)
    List<SaleItem> findSaleRelated(@Param("idSale") Integer idSale);

    /**
     * @param idItem idItem.
     * @return list.
     */
    @Query(value = "SELECT * FROM sales_items s WHERE s.id_item = :idItem", nativeQuery = true)
    List<SaleItem> findItemRelated(@Param("idItem") Integer idItem);

    //@Query(value = "SELECT * FROM sales_items s WHERE s.id_sale = :idSale OR s.id_item = :idItem",
    //        nativeQuery = true)
    //List<SaleItem> findSaleItemRelated(@Param("idSale") Integer idSale,@Param("idItem") Integer idItem);
}
