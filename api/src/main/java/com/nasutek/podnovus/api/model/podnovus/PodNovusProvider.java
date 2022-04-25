package com.nasutek.podnovus.api.model.podnovus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "podnovus_provider")
public class PodNovusProvider {
        @Id
        private String id = UUID.randomUUID().toString();

        @Column(nullable = false)
        private String name = "Root Provider";

        @Column
        private String description;

        @Column
        private boolean pinned;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "root_provider")
        private List<PodNovusProvider> subProviders = new ArrayList<>();

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "provider")
        private List<PodNovusRSSFeed> rssFeeds = new ArrayList<>();

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

        public boolean isPinned() {
                return pinned;
        }

        public void setPinned(boolean pinned) {
                this.pinned = pinned;
        }

        public List<PodNovusProvider> getSubProviders() {
                return subProviders;
        }

        public List<PodNovusRSSFeed> getRSSFeeds() {
                return rssFeeds;
        }

        public String getId() {
                return id;
        }
}
