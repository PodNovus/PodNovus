package com.nasutek.podnovus.backend.repositories;

import com.nasutek.podnovus.api.model.streamdesk.StreamDeskDatabase;
import com.nasutek.podnovus.backend.repositories.managers.StreamDeskDatabaseRepositoryManager;
import org.springframework.data.repository.CrudRepository;

public interface StreamDeskDatabaseRepository extends CrudRepository<StreamDeskDatabase, String>, StreamDeskDatabaseRepositoryManager {
}
