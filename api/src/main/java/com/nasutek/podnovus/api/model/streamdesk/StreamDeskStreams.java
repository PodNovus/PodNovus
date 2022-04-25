package com.nasutek.podnovus.api.model.streamdesk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "streamdesk_streams")
public class StreamDeskStreams {
        @Id
        private String id = UUID.randomUUID().toString();
        @Column(nullable = false)
        private String name;
        @Column
        private String description;
        @Column
        private String web;
        @Column
        private String tags;
        @Column
        private boolean promoted;
        @Column(nullable = false)
        private String streamEmbedId;
        @Column
        private String streamEmbedData;
        @Column(nullable = false)
        private String chatEmbedId;
        @Column
        private String chatEmbedData;
        @Column(nullable = false)
        private int width;
        @Column(nullable = false)
        private int height;

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

        public String getTags() {
                return tags;
        }

        public void setTags(String tags) {
                this.tags = tags;
        }

        public boolean isPromoted() {
                return promoted;
        }

        public void setPromoted(boolean promoted) {
                this.promoted = promoted;
        }

        public String getStreamEmbedId() {
                return streamEmbedId;
        }

        public void setStreamEmbedId(String streamEmbedId) {
                this.streamEmbedId = streamEmbedId;
        }

        public String getStreamEmbedData() {
                return streamEmbedData;
        }

        public void setStreamEmbedData(String streamEmbedData) {
                this.streamEmbedData = streamEmbedData;
        }

        public String getChatEmbedId() {
                return chatEmbedId;
        }

        public void setChatEmbedId(String chatEmbedId) {
                this.chatEmbedId = chatEmbedId;
        }

        public String getChatEmbedData() {
                return chatEmbedData;
        }

        public void setChatEmbedData(String chatEmbedData) {
                this.chatEmbedData = chatEmbedData;
        }

        public int getWidth() {
                return width;
        }

        public void setWidth(int width) {
                this.width = width;
        }

        public int getHeight() {
                return height;
        }

        public void setHeight(int height) {
                this.height = height;
        }
}
