package com.nasutek.podnovus.backend.repositories.managers;

import com.nasutek.podnovus.api.model.streamdesk.StreamDeskDatabase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StreamDeskDatabaseRepositoryManagerImpl implements StreamDeskDatabaseRepositoryManager {
        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public StreamDeskDatabase update(StreamDeskDatabase db) {
                return entityManager.merge(db);
        }
}
