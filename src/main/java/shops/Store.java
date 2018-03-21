package shops;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Store {
        
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer storeID;
        private String storeName;
        private String latitude;
        private String longitude ;
        
        public Store() {
        }

        public Store(Integer storeID, String longitude, String latitude) {
            this.storeID = storeID;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public Store(Integer storeID, String storeName) {
            this.storeID = storeID;
            this.storeName = storeName;
        }
        
        public Integer getStoreID() {
            return storeID;
        }

        public String getLongitude() {
            return longitude;
        }

        public String getLatitude() {
            return latitude;
        }
}
