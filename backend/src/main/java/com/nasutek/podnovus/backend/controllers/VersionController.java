package com.nasutek.podnovus.backend.controllers;

import com.nasutek.podnovus.api.PodNovusVersion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/version")
@Tag(name = "PodNovus Version Information")
public class VersionController {
        @GetMapping("/")
        @Operation(summary = "Gets the PodNovus Backend Version.")
        @ApiResponses(value =
        @ApiResponse(responseCode = "200", description = "Includes PodNovus Version Data",
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PodNovusVersion.class))})
        )
        public ResponseEntity<PodNovusVersion> getVersion() {
                return ResponseEntity.accepted().body(new PodNovusVersion());
        }
}
