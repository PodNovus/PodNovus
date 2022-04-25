package com.nasutek.podnovus.api;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Properties;

public class PodNovusVersion {
        private boolean gitPropertiesExists = true;
        private String version = "0.0.0-SNAPSHOT";
        private String gitCommitId = "XXXXXXXXXXXX";
        private String gitBranch = "dev";
        private String buildTime = "YYYYMMDD_HHMM";
        private boolean dirtyBuild;

        public PodNovusVersion() {
                try (InputStream input = PodNovusVersion.class.getClassLoader().getResourceAsStream("git.properties")) {
                        Properties prop = new Properties();

                        if (input == null) {
                                gitPropertiesExists = false;
                                return;
                        }

                        prop.load(input);

                        //get the property value and print it out
                        version = prop.getProperty("git.build.version");
                        gitCommitId = prop.getProperty("git.commit.id.abbrev");
                        gitBranch = prop.getProperty("git.branch");
                        var dateTime = prop.getProperty("git.build.time");
                        var dateTimeObject = LocalDateTime.parse(dateTime.substring(0, dateTime.length() - 5));
                        buildTime = String.format("%d%02d%02d_%02d%02d",
                                dateTimeObject.getYear(), dateTimeObject.getMonthValue(),
                                dateTimeObject.getDayOfMonth(), dateTimeObject.getHour(),
                                dateTimeObject.getMinute()
                        );
                        dirtyBuild = Boolean.parseBoolean(prop.getProperty("git.dirty"));
                } catch (IOException ex) {
                        gitPropertiesExists = false;
                        ex.printStackTrace();
                }
        }

        public String getVersion() {
                return version;
        }

        public String getGitCommitId() {
                return gitCommitId;
        }

        public boolean isGitPropertiesExists() {
                return gitPropertiesExists;
        }

        public String getBuildTime() {
                return buildTime;
        }

        public String getGitBranch() {
                return gitBranch;
        }
}
