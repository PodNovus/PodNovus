package com.nasutek.podnovus.api.model.streamdesk;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "streamdesk_database")
public class StreamDeskDatabase {
        @Id
        private String id = UUID.randomUUID().toString();

        @Column(nullable = false)
        private String databaseType = "StreamDesk Legacy Format";
        @Column(nullable = false)
        private String minimumCompatable = "3.0.0";
        @Column(nullable = false)
        private String databaseVersion = "2";
        @Column(nullable = false)
        private String name;
        @Column
        private String description;
        @Column(nullable = false)
        private String vendorName;

        @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
        private StreamDeskProvider rootProvider = new StreamDeskProvider();

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "database")
        private List<StreamDeskChatEmbed> chatEmbeds = new ArrayList<>();

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "database")
        private List<StreamDeskStreamEmbed> streamEmbeds = new ArrayList<>();

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

        public StreamDeskProvider getRootProvider() {
                return rootProvider;
        }

        public List<StreamDeskChatEmbed> getChatEmbeds() {
                return chatEmbeds;
        }

        public List<StreamDeskStreamEmbed> getStreamEmbeds() {
                return streamEmbeds;
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
