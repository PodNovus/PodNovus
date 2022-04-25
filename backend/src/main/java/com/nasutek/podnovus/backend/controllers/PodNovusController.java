package com.nasutek.podnovus.backend.controllers;

import com.nasutek.podnovus.api.model.podnovus.PodNovusDatabase;
import com.nasutek.podnovus.api.model.streamdesk.StreamDeskDatabase;
import com.nasutek.podnovus.backend.repositories.PodNovusDatabaseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/podnovus")
@Tag(name = "PodNovus Database")
public class PodNovusController {
        @Autowired
        PodNovusDatabaseRepository podNovusDatabaseRepository;

        @GetMapping("/database/{id}")
        @Operation(summary = "Gets the specified PodNovus database.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Found the PodNovus Database",
                        content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PodNovusDatabase.class))}),
                @ApiResponse(responseCode = "404", description = "Database not found",
                        content = @Content)
        })
        public ResponseEntity<PodNovusDatabase> getV3Database(@Parameter(description = "ID of the database to pull") @PathVariable("id") String id) {
                var returnValue = podNovusDatabaseRepository.findById(id);
                if (returnValue.isPresent())
                        return ResponseEntity.status(HttpStatus.OK).body(returnValue.get());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
}
