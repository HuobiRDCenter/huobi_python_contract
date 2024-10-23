package com.huobi.api.response.coin_swap.market;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SummaryResponse {
    private Page page;
    private List<Components> components;
    private List<Incidents> incidents;
    @SerializedName("scheduled_maintenances")
    private List<ScheduledMaintenances> scheduledMaintenances;
    private Status status;
    @Builder
    @Data
    @AllArgsConstructor
    public static class Page{
        private String id;
        private String name;
        private String url;
        @SerializedName("time_zone")
        private String timeZone;
        @SerializedName("updated_at")
        private String updatedAt;
    }
    @Builder
    @Data
    @AllArgsConstructor
    public static class Components{
        private String id;
        private String name;
        private String status;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        private Integer position;
        private String description;
        private Boolean showcase;
        @SerializedName("group_id")
        private String groupId;
        @SerializedName("page_id")
        private String pageId;
        private Boolean group;
        @SerializedName("only_show_if_degraded")
        private Boolean onlyShowIfDegraded;
    }
    @Builder
    @Data
    @AllArgsConstructor
    public static class Incidents{
        private String id;
        private String name;
        private String status;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("monitoring_at")
        private String monitoringAt;
        @SerializedName("resolved_at")
        private String resolvedAt;
        private String impact;
        private String shortlink;
        @SerializedName("started_at")
        private String startedAt;
        @SerializedName("page_id")
        private String pageId;
        @SerializedName("incident_updates")
        private List<IncidentUpdates> incidentUpdates;
        private List<Components> components;
    }
    @Builder
    @Data
    @AllArgsConstructor
    public static class IncidentUpdates{
        private String id;
        private String status;
        private String body;
        @SerializedName("incident_id")
        private String incidentId;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("display_at")
        private String displayAt;
        @SerializedName("affected_components")
        private List<AffectedComponents> affectedComponents;
        @SerializedName("deliver_notifications")
        private Boolean deliverNotifications;
        @SerializedName("custom_tweet")
        private String customTweet;
        @SerializedName("tweet_id")
        private String tweetId;
    }
    @Builder
    @Data
    @AllArgsConstructor
    public static class AffectedComponents{
        private String code;
        private String name;
        @SerializedName("old_status")
        private String oldStatus;
        @SerializedName("new_status")
        private String newStatus;
    }
    @Builder
    @Data
    @AllArgsConstructor
    public static class ScheduledMaintenances{
        private String id;
        private String name;
        private String status;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("monitoring_at")
        private String monitoringAt;
        @SerializedName("resolved_at")
        private String resolvedAt;
        private String impact;
        private String shortlink;
        @SerializedName("started_at")
        private String startedAt;
        @SerializedName("page_id")
        private String pageId;
        @SerializedName("incident_updates")
        private List<IncidentUpdates> incidentUpdates;
        private List<Components> components;
        @SerializedName("scheduled_for")
        private String scheduledFor;
        @SerializedName("scheduled_until")
        private String scheduledUntil;
    }
    @Builder
    @Data
    @AllArgsConstructor
    public static class Status{
        private String indicator;
        private String description;
    }
}
