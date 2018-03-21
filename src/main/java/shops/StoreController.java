package shops;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class StoreController {

    private static final String coord = "coordinates!";
    private final AtomicInteger counter = new AtomicInteger();
    
    @Autowired
    private StoreRepository storeRepository;

   // @RequestMapping(value = "/getStoreCoord", method={RequestMethod.GET})
   // public Store getStore(@RequestParam(value="name", defaultValue="World") String name) {
   //     return new Store(counter.increimentAndGet());
   // }

    @RequestMapping("/createStore")
    public Store create(@RequestParam(value="storeName") String storeName) {
        Integer storeID;
        try {
            storeID = counter.incrementAndGet();
            Store store = new Store(storeID, storeName);
            storeRepository.save(store);
            return store; 
        } catch (Exception ex){ 
            //return "Error occurred while creating store:" + ex.toString();
        }
        return new Store();
    }
    
    @RequestMapping("/getStoresList")  //PUBLIC
    public Store getStoresList() {
        return new Store();
    }

    @RequestMapping("/changeStore")  //SHOPKEEPER
    public Store changeStoreInfo() {
        return new Store();
    }
    
    @RequestMapping("/addStore")        //ADMIN
    public Store addStore() {
        return new Store();
    }
}
