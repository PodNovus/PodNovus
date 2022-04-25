package com.nasutek.podnovus.api.model.podnovus;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "podnovus_database")
public class PodNovusDatabase {
        @Id
        private String id = UUID.randomUUID().toString();

        @Column(nullable = false)
        private String databaseType = "PodNovus Database Format";
        @Column(nullable = false)
        private String minimumCompatable = "1.0.0";
        @Column(nullable = false)
        private String databaseVersion = "1";
        @Column(nullable = false)
        private String name;
        @Column
        private String description;
        @Column(nullable = false)
        private String vendorName;

        @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
        private PodNovusProvider rootProvider = new PodNovusProvider();

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getVendorName() {
                return vendorName;
        }

        public void setVendorName(String vendorName) {
                this.vendorName = vendorName;
        }

        public PodNovusProvider getRootProvider() {
                return rootProvider;
        }

        public String getId() {
                return id;
        }

        public String getDatabaseType() {
                return databaseType;
        }

        public String getMinimumCompatable() {
                return minimumCompatable;
        }

        public String getDatabaseVersion() {
                return databaseVersion;
        }
}
