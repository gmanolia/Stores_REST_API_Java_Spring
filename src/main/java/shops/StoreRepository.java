package shops;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, Integer> {

        List<Store> findByStoreID(String storeID);
}
