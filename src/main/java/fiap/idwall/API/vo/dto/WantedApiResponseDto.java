package fiap.idwall.API.vo.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
public class WantedApiResponseDto {
        private String hair_raw;
        private String eyes_raw;
        private Double reward_min;
        private Double reward_max;
        private String sex;
        @JsonProperty("title")
        private String title;

    public String getHair_raw() {
        return hair_raw;
    }

    public void setHair_raw(String hair_raw) {
        this.hair_raw = hair_raw;
    }

    public String getEyes_raw() {
        return eyes_raw;
    }

    public void setEyes_raw(String eyes_raw) {
        this.eyes_raw = eyes_raw;
    }

    public Double getReward_min() {
        return reward_min;
    }

    public void setReward_min(Double reward_min) {
        this.reward_min = reward_min;
    }

    public Double getReward_max() {
        return reward_max;
    }

    public void setReward_max(Double reward_max) {
        this.reward_max = reward_max;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle_max(String title) {
        this.title = title;
    }
}
