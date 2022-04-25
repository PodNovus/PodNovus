package com.nasutek.podnovus.api.model.streamdesk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "streamdesk_streamembed")
public class StreamDeskStreamEmbed {
        @Id
        private String id = UUID.randomUUID().toString();

        @Column
        private String embedName;
        @Column
        private String embedFormat;

        public String getEmbedName() {
                return embedName;
        }

        public void setEmbedName(String embedName) {
                this.embedName = embedName;
        }

        public String getEmbedFormat() {
                return embedFormat;
        }

        public void setEmbedFormat(String embedFormat) {
                this.embedFormat = embedFormat;
        }

        public String getId() {
                return id;
        }
}
