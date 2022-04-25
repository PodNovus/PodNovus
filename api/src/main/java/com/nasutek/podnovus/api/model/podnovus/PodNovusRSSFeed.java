package com.nasutek.podnovus.api.model.podnovus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "podnovus_rssfeeds")
public class PodNovusRSSFeed {
        @Id
        private String id = UUID.randomUUID().toString();

        @Column(nullable = false)
        private String name;
        @Column
        private String description;
        @Column
        private String web;
        @Column(nullable = false)
        private String rssUrl;
        @Column
        private boolean promoted;

        public String getId() {
                return id;
        }

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

        public String getWeb() {
                return web;
        }

        public void setWeb(String web) {
                this.web = web;
        }


        public String getRssUrl() {
                return rssUrl;
        }

        public void setRssUrl(String rssUrl) {
                this.rssUrl = rssUrl;
        }

        public boolean isPromoted() {
                return promoted;
        }

        public void setPromoted(boolean promoted) {
                this.promoted = promoted;
        }
}
