package com.huobi.wss.event;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PublicHeartbeatSubResponse {
    private String op;
    private String topic;
    private String event;
    private Long ts;
    private DataBean data;
    @Data
    @Builder
    @AllArgsConstructor
    public static class DataBean {
        private Integer heartbeat;
        @SerializedName("estimated_recovery_time")
        private Long estimatedRecoveryTime;
    }
}
