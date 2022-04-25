package com.nasutek.podnovus.backend.controllers;

import com.nasutek.podnovus.api.model.streamdesk.StreamDeskDatabase;
import com.nasutek.podnovus.backend.repositories.StreamDeskDatabaseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v2/streamdesk")
@Tag(name = "StreamDesk Database")
public class StreamDeskController {
        @Autowired
        StreamDeskDatabaseRepository streamDeskDatabaseRepository;

        @GetMapping("/database/{id}")
        @Operation(summary = "Gets the specified StreamDesk database.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Found the StreamDesk Database",
                        content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StreamDeskDatabase.class))}),
                @ApiResponse(responseCode = "404", description = "Database not found",
                        content = @Content)
        })
        public ResponseEntity<StreamDeskDatabase> getV3Database(@Parameter(description = "ID of the database to pull") @PathVariable("id") String id) {
                var returnValue = streamDeskDatabaseRepository.findById(id);
                if (returnValue.isPresent())
                        return ResponseEntity.status(HttpStatus.OK).body(returnValue.get());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        @PostMapping(path = "/database", consumes = MediaType.APPLICATION_JSON_VALUE)
        @Transactional
        public String manageDatabase(@RequestBody StreamDeskDatabase database) {
                var db = streamDeskDatabaseRepository.update(database);
                return db.getId();
        }

        @DeleteMapping("/database/{id}")
        @Operation(summary = "Deletes the specified StreamDesk database.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully deleted the database. Returns the id of the deleted database.",
                        content = @Content),
                @ApiResponse(responseCode = "404", description = "Database not found",
                        content = @Content)
        })
        public ResponseEntity<String> deleteV3Database(@Parameter(description = "ID of the database to delete") @PathVariable("id") String id) {
                var returnValue = streamDeskDatabaseRepository.findById(id);
                if (returnValue.isPresent()) {
                        streamDeskDatabaseRepository.delete(returnValue.get());
                        return ResponseEntity.status(HttpStatus.OK).body(id);
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
}
